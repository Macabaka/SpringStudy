package com.soft1851.springmvc.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jack
 * @Date: 2020/3/28 22:31
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rank {
    private  String id;
    private  String pic;
    private String title;
    private  String duration;
    private String author;
}
