package com.cx.ttshop.service.impl;

import com.cx.common.utils.FtpUtil;
import com.cx.common.utils.IDUtils;
import com.cx.ttshop.service.FileService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public Map<String, Object> uploadImages(MultipartFile upfile) {
        //即将放置到上传配置文件中的信息upload.properties
        String address = "101.132.144.85";
        int port = 21;
        String username = "ftpuser";
        String password = "cx1212";
        String basePath = "/home/ftpuser/www/images";
        String dateString = new DateTime().toString("/yyyy/MM/dd");
        //获取原来的文件名，包括扩展名
        String original = upfile.getOriginalFilename();
        //截取出扩展名
        String fileType = original.substring(original.lastIndexOf("."));
        //使用自定义工具类产生新的文件名，只产生了文件名，未产生扩展名
        String newName = IDUtils.genImageName();
        //拼接出新的文件名+扩展名
        newName += fileType;
        InputStream inputStream = null;
        try {
            inputStream = upfile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //上传成功返回true，否则返回false
        boolean bool = FtpUtil.uploadFile(address, port, username, password, basePath, dateString, newName, inputStream);
        Map<String,Object> map = new HashMap<String,Object>();
        if(bool){
            map.clear();
            map.put("state","SUCCESS");
            map.put("original",original);
            map.put("size",upfile.getSize());
            map.put("title",newName);
            map.put("type",fileType);
            map.put("url",dateString + "/" + newName);
        }
        return map;
    }
}
