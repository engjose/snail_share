package com.snail.service.base;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description 文件上传服务
 * @author Jiankun.Zhangsun 2017/10/15 21:30
 * @verion v1.0
 * @since v1.0
 */
public interface IFileService {

    /**
     * 文件上传
     *
     * @param file 上传文件对象
     * @param path 文件的本地路径
     * @return 文件所在服务器的资源路径
     */
    String uploadFile(MultipartFile file, String path);
}
