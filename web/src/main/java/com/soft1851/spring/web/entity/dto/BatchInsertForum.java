package com.soft1851.spring.web.entity.dto;

import com.soft1851.spring.web.entity.Forum;
import lombok.Data;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/22 11:24
 * @Description:
 */
@Data
public class BatchInsertForum {
    List<Forum> forumList;
}
