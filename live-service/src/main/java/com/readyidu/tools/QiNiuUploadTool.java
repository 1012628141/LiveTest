package com.readyidu.tools;

import com.google.gson.Gson;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import javax.security.auth.x500.X500Principal;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Created by 123 on 2017/12/18.
 */
public class QiNiuUploadTool {

    private static String accessKey = "8qXT7YOMZ-GtjM36rtkzKMEuZSaDrtbSPetdXYIf";
    private static String secretKey = "zbp-eUwRuMzucnYr37u_zXyNsiKkxBrTB84CmmSu";
    private static String bucket = "com-live";
    public static String zipPath = "/C:/Users/Administrator/Desktop/";
    private static String key = null;
    public static String getToken(){
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        return upToken;
    }
    public static String upLoad(String localFilePath){
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(localFilePath, key, getToken());
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return putRet.hash;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }
    public static String upLoadwithCallback(String localFilePath){
        long expireSeconds = 3600;
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        StringMap putPolicy = new StringMap();
        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize),\"version\":\"$(x:version)\",\"acount\":$(x:acount)}");
        putPolicy.put("callbackUrl", "http://api.example.com/qiniu/upload/callback");
        putPolicy.put("callbackBodyType", "application/json");
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
        try {
            InputStream in = new FileInputStream(localFilePath);
            Response response = uploadManager.put(in, key, upToken,putPolicy,null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return putRet.hash;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean createCardImgZip(String sourcePath, String zipName) {
        boolean result = false;
        File sourceFile = new File(sourcePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (sourceFile.exists() == false) {
            System.out.println("File catalog:" + sourcePath + "not exist!");
        } else {
            try {
                if(!new File(zipPath).exists()){
                    new File(zipPath).mkdirs();
                }
                File zipFile = new File(zipPath + "/" + zipName + ".zip");
                if (zipFile.exists()) {
                    zipFile.delete();
                }
                zipFile.createNewFile();
                File sourceFiles = new File(sourcePath);
                if (null == sourceFiles ) {
                    System.out.println("File Catalog:" + sourcePath + "nothing in there,don't hava to compress!");
                } else {
                    fos = new FileOutputStream(zipFile);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    byte[] bufs = new byte[1024 * 10];
                    ZipEntry zipEntry = new ZipEntry(sourceFiles.getName());
                    zos.putNextEntry(zipEntry);
                    // read documents and put them in the zip
                    fis = new FileInputStream(sourceFiles);
                    bis = new BufferedInputStream(fis, 1024 * 10);
                    int read = 0;
                    while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                        zos.write(bufs, 0, read);
                    }
                    result = true;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                try {
                    if (null != bis)
                        bis.close();
                    if (null != zos)
                        zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}
