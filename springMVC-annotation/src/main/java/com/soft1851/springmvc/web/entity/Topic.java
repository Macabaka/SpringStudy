package com.soft1851.springmvc.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jack
 * @Date: 2020/3/26 10:05
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topic {
    private  String id;
    private  String topicName;
    private String topicIcon;
    private  String description;
    private  Integer msgCount;
    private Integer followersCount;
    private  Boolean followed;
}
