package com.snail.service.base;

import com.snail.pojo.form.ShareForm;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 * 用户分享Service接口
 *
 * Created by panyuanyuan on 2017/10/15.
 */
public interface IShareService {

    /**
     * 分页查询分享列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map<String, Object> listShares(Integer pageNo, Integer pageSize);

    /**
     * 添加文章, 返回文章的html文章链接
     *
     * @param shareForm
     */
    String insertShare(ShareForm shareForm, HttpSession session);
}
