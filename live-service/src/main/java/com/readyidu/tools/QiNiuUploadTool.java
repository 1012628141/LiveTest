package com.readyidu.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by 123 on 2017/12/18.
 */
public class QiNiuUploadTool {

    public static String accessKey = "8qXT7YOMZ-GtjM36rtkzKMEuZSaDrtbSPetdXYIf";
    public static String secretKey = "zbp-eUwRuMzucnYr37u_zXyNsiKkxBrTB84CmmSu";
    private static String bucket = "com-live";
    public static String zipPath = "/C:/Users/Administrator/Desktop/";
    public static String CALLBACKURL = "http://218.75.36.107:11116/app/callBackUpdate";
    public static String CALLBACKBODYTYPE = "application/x-www-form-urlencoded";
    public static String CHAINURL = "http://p15mjwx7g.bkt.clouddn.com/";
    public static String CALLBACKBODY = "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"acount\":$(x:acount)}";
    private static String key = null;

    public static String getToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        return upToken;
    }

    public static String getOverrideToken(String key) {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key, 3600, new StringMap().put("insertOnly", 0));
        System.out.println(upToken);
        return upToken;
    }

    public static String upLoad(String path,String key) {
               Configuration cfg = new Configuration(Zone.zone0());
               UploadManager uploadManager = new UploadManager(cfg);
                try {
                       String token = getOverrideToken(key);//获取 token
                       Response response = uploadManager.put(path, key, token);//执行上传，通过token来识别 该上传是“覆盖上传”
                       System.out.println(response.toString());
                       return CHAINURL+key;
                  } catch (QiniuException e) {
                       System.out.println(e.response.statusCode);
                      e.printStackTrace();
                 }
                 return null;
    }




    /*public static String upLoad(String localFilePath,String key) {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(localFilePath, key, getOverrideToken(key));
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return CHAINURL+key;
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
    }*/

    public static String upLoad(String localFilePath) {
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
    public static String byteUpdate(byte[] uploadBytes) {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(uploadBytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            return "error";
        }
    }

    public static String upLoadWithCallBack(String localFilePath) {
        long expireSeconds = 3600;
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        StringMap putPolicy = new StringMap();
        putPolicy.put("callbackBody", CALLBACKBODY);
        putPolicy.put("callbackUrl", CALLBACKURL);
        putPolicy.put("callbackBodyType", CALLBACKBODYTYPE);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy, false);
        try {
            InputStream in = new FileInputStream(localFilePath);
            StringMap params = new StringMap();
            params.put("x:acount",123456);
            Response response = uploadManager.put(in, key, upToken, params, null);
            //解析上传成功的结果

            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
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
                if (!new File(zipPath).exists()) {
                    new File(zipPath).mkdirs();
                }
                File zipFile = new File(zipPath + "/" + zipName + ".zip");
                if (zipFile.exists()) {
                    zipFile.delete();
                }
                zipFile.createNewFile();
                File sourceFiles = new File(sourcePath);
                if (null == sourceFiles) {
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

    public static JSONObject parseCallBack(HttpServletRequest request) throws IOException {
        //回调地址
        Auth auth = Auth.create(accessKey, secretKey);
        /**
         * 这两个参数根据实际所使用的HTTP框架进行获取
         */
        String callbackAuthHeader = request.getHeader("Authorization");
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte[] callbackBody = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {

            int readlen = request.getInputStream().read(callbackBody, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return auth.isValidCallback(callbackAuthHeader
                , CALLBACKURL
                , callbackBody
                , CALLBACKBODYTYPE)
                ? JSON.parseObject(new String(callbackBody)) : null;
    }
}
