package com.snail.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户分享信息Vo
 *
 * Created by panyuanyuan on 2017/10/15.
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShareInfoVo {

    /** 分享标题 */
    private String title;

    /** 创建时间 */
    private String createAt;

    /** 分享内容的tag */
    private String tagetName;

    /** 被收藏次数 */
    private Integer collectCount;

    /** 被评论次数 */
    private Integer commentCount;

    /** 浏览次数 */
    private String scanCount;

    /** 分享用户id */
    private Integer userId;

    /** 用户昵称 */
    private String loginName;

    /** 用户昵称 */
    private String userIcon;

}
