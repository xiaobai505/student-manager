package com.agoni.security.utils;

import com.diboot.core.config.Cons;
import com.diboot.core.util.V;

import javax.servlet.http.HttpServletRequest;

public class httpUitl {
    private static final String[] HEADER_IP_KEYWORDS = {"X-Forwarded-For", "Proxy-Client-IP",
            "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "X-Real-IP"};
    
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
            if (V.notEmpty(ipAddresses)) {
                return ipAddresses.split(Cons.SEPARATOR_COMMA)[0];
            }
        }
        return request.getRemoteAddr();
    }
}
