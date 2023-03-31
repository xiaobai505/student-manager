package com.agoni.system.utils;

import com.agoni.dgy.model.po.Logininfor;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.diboot.core.config.Cons;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gyd
 */
@Slf4j
public class httpUitl {
    private static final String[] HEADER_IP_KEYWORDS = {"X-Forwarded-For", "Proxy-Client-IP",
            "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "X-Real-IP"};

    public static Logininfor getLogininfor(HttpServletRequest request) {
        // IP
        String requestIp = httpUitl.getRequestIp(request);
        // IP所属地
        String ipAddress = httpUitl.getIpAddress(requestIp);
        // 浏览器
        String browser = httpUitl.browser(request);
        // 操作系统
        String os = httpUitl.os(request);
        return Logininfor.builder().os(os).browser(browser).ipaddr(requestIp).loginLocation(ipAddress).build();
    }
    
    /**
     * 获取客户ip地址
     * @param request
     *
     * @return
     */
    public static String getRequestIp(HttpServletRequest request) {
        for(String header : HEADER_IP_KEYWORDS){
            String ipAddresses = request.getHeader(header);
            if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
                continue;
            }
            if (StringUtils.isNotEmpty(ipAddresses)) {
                return ipAddresses.split(Cons.SEPARATOR_COMMA)[0];
            }
        }
        return request.getRemoteAddr();
    }

    public static String browser(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        String browserVersion = "Unknown-null";

        if (userAgent != null) {
            // 将 User-Agent 头信息转换为小写字母，方便匹配
            userAgent = userAgent.toLowerCase();

            // 匹配各种浏览器的正则表达式
            if (userAgent.contains("msie")) {  // IE 浏览器
                int index = userAgent.indexOf("msie");
                browserVersion = userAgent.substring(index + 5, index + 8);
            } else if (userAgent.contains("firefox")) {  // Firefox 浏览器
                int index = userAgent.indexOf("firefox");
                browserVersion = userAgent.substring(index + 8, index + 14);
            } else if (userAgent.contains("chrome")) {  // Chrome 浏览器
                int index = userAgent.indexOf("chrome");
                browserVersion = userAgent.substring(index + 7, index + 13);
            } else if (userAgent.contains("safari")) {  // Safari 浏览器
                int index = userAgent.indexOf("version");
                browserVersion = userAgent.substring(index + 8, index + 12);
            } else if (userAgent.contains("Postman")) {  // Opera 浏览器
                return "PostMan";
            }
        }

        return browserVersion;
    }


    public static String os(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        String systemVersion = "Unknown";

        if (userAgent != null) {
            // 将 User-Agent 头信息转换为小写字母，方便匹配
            userAgent = userAgent.toLowerCase();

            // 匹配各种操作系统的正则表达式
            if (userAgent.contains("windows nt")) {  // Windows 操作系统
                int index = userAgent.indexOf("windows nt");
                systemVersion = userAgent.substring(index + 11, index + 14);
            } else if (userAgent.contains("mac os x")) {  // macOS 操作系统
                int index = userAgent.indexOf("mac os x");
                systemVersion = userAgent.substring(index + 9, index + 13);
            } else if (userAgent.contains("android")) {  // Android 操作系统
                int index = userAgent.indexOf("android");
                systemVersion = userAgent.substring(index + 8, index + 12);
            } else if (userAgent.contains("iphone os")) {  // iOS 操作系统
                int index = userAgent.indexOf("iphone os");
                systemVersion = userAgent.substring(index + 10, index + 13);
            }
        }

        return systemVersion;
    }



    public static String getIpAddress(String ip){
        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        Map map = new HashMap();
        map.put("ip", ip);
        map.put("accessKey", "alibaba-inc");
        String result = post("http://ip.taobao.com/outGetIpInfo", map);
        Map valueMap = JSONObject.parseObject(result, Map.class);
    
        // 请求成功，解析响应数据
        if ("query success".equals(valueMap.get("msg"))) {
            Map<String, String> dataMap = (Map<String, String>) valueMap.get("data");
            String country = dataMap.get("country");
            String region = dataMap.get("region");
            String city = dataMap.get("city");
            return String.format("%s省-%s市-%s县", country, region, city);
        }
        return null;

    }
    
    private static String post(String url, Map<String, String> mapParameter) {
        log.debug("开始请求: url = {}, mapParameter = {}, charset = {}", url, mapParameter);
        // 创建httpClient的默认实例
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建POST请求
            HttpPost httpPost = new HttpPost(url);
            // 设置参数
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            // 迭代参数
            if (mapParameter != null && mapParameter.size() > 0) {
                mapParameter.forEach((k, v) -> nameValuePairList.add(new BasicNameValuePair(k, v)));
            }
            // 编码
            if (nameValuePairList.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairList);
                httpPost.setEntity(entity);
            }
            // 执行post请求
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                if (response != null) {
                    log.info("请求成功, 响应状态: {}", response.getStatusLine().getStatusCode());
                    HttpEntity httpEntity = response.getEntity();
                    // 如果返回的内容不为空
                    if (httpEntity != null) {
                        return EntityUtils.toString(httpEntity);
                    }
                }
            } catch (Exception e) {
                log.error("请求异常: e = {}", e);
                e.printStackTrace();
            }
        } catch (Exception e) {
            log.error("请求异常: e = {}", e);
            e.printStackTrace();
        }
        return null;
    }
}
