package com.soft1851.springmvc.web.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.springmvc.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.annotation.Resource;
import java.io.Closeable;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/28 17:31
 * @Description:
 */
public class JueJinSpider {
    private  static final   Integer SUCCESS =200;

    public static List<Topic> getTopics(){
        List<Topic> topicList = new ArrayList<>();
        //目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7da684f265da798e129277&device_id=1585388059749&token=eyJhY2Nlc3NfdG9rZW4iOiJzb1NJcXVyZ3Z6TjJxSWZaIiwicmVmcmVzaF90b2tlbiI6IndDaGZVU2VSdmZjQlBqalYiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(get, context);
        }catch(IOException e){
            e.printStackTrace();
        }
//        System.out.println(response.getStatusLine());
        //如果请求成功，则获取网页源码
        if(response.getStatusLine().getStatusCode() == SUCCESS){
            HttpEntity entity = response.getEntity();
            String res = null;
            try{
                res = EntityUtils.toString(entity, "UTF-8");
            }catch(IOException e){
                e.printStackTrace();
            }
//            System.out.println(res);
            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
            list.forEach(o->{
                JSONObject json = JSONObject.parseObject(o.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followersCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topicList.add(topic);
            });
        }else{
            System.out.println("请求失败");
        }

        try{
            response.close();
            httpClient.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return topicList;
    }

    public static void main(String[] args) {
        getTopics();
    }
}
