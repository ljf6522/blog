package com.example.my_blog.utils;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/10/14
 */
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IpUtils {

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }
    /**
     * 3.通过调用接口根据ip获取归属地
     */
    public static String getAddress(String ip) {
        try {
            URL realUrl = new URL("http://whois.pconline.com.cn/ipJson.jsp?ip=" + ip + "&json=true");
//            URL realUrl = new URL("http://ip.taobao.com/outGetIpInfo?ip=" + ip + "accessKey=alibaba-inc");

            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setReadTimeout(6000);
            conn.setConnectTimeout(6000);
            conn.setInstanceFollowRedirects(false);
            int code = conn.getResponseCode();
            StringBuilder sb = new StringBuilder();
            String ipaddr = "";
            if (code == 200) {
                InputStream in = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));//指定编码格式
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
//                System.out.println("==" + sb);
                String pro = sb.substring((sb.indexOf("pro") + 6), sb.indexOf("proCode") - 3);
                String city = sb.substring((sb.indexOf("city") + 7), sb.indexOf("cityCode") - 3);
                String addr = (sb.substring(sb.indexOf("addr") + 7, sb.indexOf("regionNames") - 3)).trim();
                String ipAddr = pro + city;
                if (StringUtils.isBlank(ipAddr)) {
                    ipaddr = addr;
                } else {
                    ipaddr = pro.equals(city) ? pro : pro + city;
                }

            }
            return ipaddr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
