package com.snail.pojo.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  @description 标签Form
 *
 *  @author Jiankun.Zhangsun 2017年11月4日21:43:19
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareTagForm {

    /** 标签ID */
    private Integer id;

    /** 标签名 */
    private String tagName;

    /** 所属专题ID */
    private Integer categoryId;
}
