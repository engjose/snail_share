package com.snail.service.impl;

import com.google.common.collect.Lists;
import com.snail.service.base.IFileService;
import com.snail.util.FTPUtil;
import com.snail.util.PropertiesUtil;
import java.io.File;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description 文件上传
 * @author Jiankun.Zhangsun 2017/10/15 21:39
 * @verion v1.0
 * @since v1.0
 */
@Service
public class FileServiceImpl implements IFileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 文件上传
     *
     * @param file 上传文件对象
     * @param path 文件的本地路径
     * @return 文件所在服务器的资源路径
     */
    @Override
    public String uploadFile(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        String fileExtention = fileName.substring(fileName.lastIndexOf(".") + 1);
        String fileNamePrefix = DateFormatUtils.format(new Date(), "yyyyMMdd");
        String newFileName = UUID.randomUUID().toString().replace("-", "");
        String uploadFileName = new StringBuilder().append(fileNamePrefix).append(newFileName).append(".").append(fileExtention).toString();
        File targetFile = new File(path, uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        try {
            //上传到本地服务器
            file.transferTo(targetFile);
            //上传文件到FTP
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //删除本地文件
            targetFile.delete();
        } catch (Exception e) {
            logger.error("upload file to upload server err");
        }
        return PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFile.getName();
    }
}
