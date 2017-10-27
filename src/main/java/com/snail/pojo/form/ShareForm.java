package com.snail.pojo.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Panyuanyuan
 * @Date: Created in 下午3:12 2017/10/21
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShareForm {

    /** 分享文章title */
    private String title;

    /** 文章列表展示Icon */
    private String shareIcon;

    /** 文章描述 */
    private String shareDesc;

    /** 文章链接 */
    private String shareUrl;

    /** 关联内容表Id */
    private Integer contentId;

    /** 文章标签Id */
    private Integer tagId;

    /** 文章标签名称 */
    private String tagName;

    /** 文章作者Id */
    private Integer userId;

    /** 作者头像链接 */
    private String userIcon;

    /** 作者昵称 */
    private String loginName;

    /** 浏览次数 */
    private Integer scanCount;

    /** 收藏次数 */
    private Integer collectCount;

    /** 评论次数 */
    private Integer commentCount;

    /** 点赞次数 */
    private Integer starCount;

    /** 文章内容 */
    private String content;

}
