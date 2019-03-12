package com.iotek.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

/**
 * 从指定url下载资源
 */
public class UrlUtil {

    public static void downLoad(String urlPath, String savePath, String fileName) {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL(urlPath);
//            URLConnection urlConnection = url.openConnection();
//            is = urlConnection.getInputStream();
            is = url.openStream();
            File file = new File(savePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            fos = new FileOutputStream(file.getAbsolutePath() + "/" + fileName);
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
