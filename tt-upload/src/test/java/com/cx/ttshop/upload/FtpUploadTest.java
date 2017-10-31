package com.cx.ttshop.upload;

import com.cx.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FtpUploadTest {
    @Test
    public void testFtpUpload() throws IOException {
        //创建FTPClient客户端
        FTPClient ftpClient = new FTPClient();
        //创建FTP连接，要填写图片服务器的IP地址
        ftpClient.connect("101.132.144.85",21);
        //登录
        ftpClient.login("ftpuser","cx1212");
        //读取本地文件
        FileInputStream fileInputStream = new FileInputStream(new File("f:\\11.jpg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //二进制类型上传
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        ftpClient.storeFile("hello.jpg",fileInputStream);
        //关闭连接
        fileInputStream.close();
        //登出
        ftpClient.logout();

    }


    @Test
    public void testFtpUtil() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("f:\\11.jpg"));
        FtpUtil.uploadFile("101.132.144.85",21,"ftpuser","cx1212","/home/ftpuser/www/images","/2017/10/27","hello2.jpg",fileInputStream);
    }

}
