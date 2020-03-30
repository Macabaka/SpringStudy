package com.soft1851.springmvc.web.util;

import com.soft1851.springmvc.web.entity.Blog;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.naming.Context;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 01:05
 * @Description:
 */
public class CsdnSpider {
    private  static final Integer SUCCESS =200;

    private  int index=0;
    public static List<Blog> getBlog(){
        String[] allUrl ={"https://blog.csdn.net/","https://blog.csdn.net/nav/watchers",
        "https://blog.csdn.net/nav/career","https://blog.csdn.net/nav/python","https://blog.csdn.net/nav/java","https://ai.csdn.net/",
                "https://blog.csdn.net/nav/web","https://blog.csdn.net/nav/arch","https://blockchain.csdn.net/","https://blog.csdn.net/nav/db",
                "https://blog.csdn.net/nav/5g","https://blog.csdn.net/nav/game","https://blog.csdn.net/nav/mobile","https://blog.csdn.net/nav/ops",
                "https://blog.csdn.net/nav/sec","https://cloud.csdn.net/","https://blog.csdn.net/nav/engineering","https://blog.csdn.net/nav/iot",
                "https://blog.csdn.net/nav/fund","https://blog.csdn.net/nav/avi","https://blog.csdn.net/nav/other"
        };
        List<Blog> blogList = new ArrayList<>();
        for(int i =0;i<allUrl.length;i++){
            String url = allUrl[i];
            String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:74.0) Gecko/20100101 Firefox/74.0";
            CloseableHttpClient httpClient = HttpClients.createDefault();
            try{
                HttpGet httpGet = new HttpGet(url);
                httpGet.setHeader("User-Agent",userAgent);
                HttpClientContext context = HttpClientContext.create();
                CloseableHttpResponse response = httpClient.execute(httpGet, context);
                int statusCode = response.getStatusLine().getStatusCode();

                if(statusCode==SUCCESS){
                    HttpEntity entity = response.getEntity();
                    if(entity!=null){
                        String res= EntityUtils.toString(entity);
                        Document document = Jsoup.parse(res);
//                    System.out.println(document);
                        Elements elements =document.getElementsByClass("clearfix");
                        for(Element element:elements){
//                        获取博客标题
                            String title = element.getElementsByTag("h2").text();
//                        获取博客描述
                            String description = element.getElementsByClass("summary oneline").text();
                            //获取作者姓名
                            String authorName = element.getElementsByTag("dd").text();
                            if(!("".equals(title)||("".equals(description)&&"".equals(authorName)))){
                                Blog blog = Blog.builder().author(authorName).title(title).description(description).build();
                                blogList.add(blog);
                            }else{

                            }
                        }
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return blogList;
    }

    public static void main(String[] args) {
        System.out.println(getBlog().size());
    }
}
