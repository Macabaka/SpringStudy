package com.soft1851.springmvc.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jack
 * @Date: 2020/3/29 01:07
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {
    private  Integer id;
    private  String title;
    private  String description;
    private  String author;
    private  String authorAvatar;
}
