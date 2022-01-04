/**
 * 
 */
package com.agoni.security.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {

	//被调用之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
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
