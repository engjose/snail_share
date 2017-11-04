package com.snail.pojo.vo;

import lombok.*;

/**
 *  @description 标签查询Vo
 *
 *  @author Jiankun.Zhangsun 2017年11月4日18:04:50
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShareTagVo {

    /** 标签ID */
    private Integer id;

    /** 标签名称 */
    private String tagName;

    /** 专题ID */
    private Integer categoryId;
}
