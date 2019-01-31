package utils;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName: collect
 * @Package: utils
 * @ClassName: HttpUtils
 * @Author: 一条小咸鱼
 * @Description: ${description}
 * @Date: 2019/1/30 17:04
 * @Version: 1.0
 */
public class HttpUtils {

    public static String postRequest(String strURL,Object obj){
        OutputStreamWriter out = null;
        InputStream is = null;
        String result = null;
        try {
            // 创建连接
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            // 设置请求方式
            connection.setRequestMethod("POST");
            // 设置接收数据的格式
            connection.setRequestProperty("Accept", "application/json");
            // 设置发送数据的格式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // utf-8编码
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.append(JSON.toJSONString(obj));
            out.flush();
            out.close();
            // 读取响应
            is = connection.getInputStream();
            // 获取长度
            int length = (int) connection.getContentLength();
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                // utf-8编码
                result = new String(data, "UTF-8");
                System.out.println("主机返回:" + result);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
