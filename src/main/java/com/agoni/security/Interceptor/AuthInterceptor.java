/**
 * 
 */
package com.agoni.security.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agoni.security.utils.JwtTokenUtil;
import com.alibaba.druid.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	//被调用之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String requestURI = request.getRequestURI();
		if (StringUtils.equals("/login/getToken",requestURI)){
			return true;
		}
		String token = request.getHeader("token");// 从 http 请求头中取出 token
		log.info("1：preHandle ==> " + token);
		// 执行认证
		if (token == null) {
			throw new RuntimeException("无token，请重新登录");
		}
		try {
			Jwt jwt = JwtTokenUtil.checkToken(token);
			log.info(jwt.toString());
			//			Jwt jwt = jwtTokenUtil.checkToken(token);
		}catch (Exception e){
			e.printStackTrace();
		}
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	//异常会被调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
		log.info("2：postHandle");
		Long start = (Long) request.getAttribute("startTime");
		log.info("time interceptor 耗时:"+ (System.currentTimeMillis() - start));

	}

	//都会被调用
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		log.info("3：afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		log.info("time interceptor 耗时:"+ (System.currentTimeMillis() - start));
		log.info("ex is "+ex);

	}

}
