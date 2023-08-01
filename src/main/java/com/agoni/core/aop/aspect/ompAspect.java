package com.agoni.core.aop.aspect;

import cn.hutool.json.JSONUtil;
import com.agoni.system.utils.UserUtil;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/6/6
 */
@Aspect
@Component
@Slf4j
public class ompAspect {

    /***
     * 切点
     *
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-06-06
     */
    @Pointcut("execution(* com.agoni.dgy.service.impl.*.searchPage(..) )")
    public void pintCutWithin() {}

    /**
     * 切面
     *
     * @param pjp pjp
     * @AfterReturning 注解中的四个参数分别为：
     * value：切入点表达式，用于指定哪些方法会被拦截到；
     * returning：用于获取被拦截方法返回值的名字；
     * argNames：用于获取被拦截方法参数名列表；
     * pointcut：指定一个切入点，该参数也可以使用 value 来替代。
     */
//    @Before(value = "pintCutWithin()")
    public void doAfterReturning(JoinPoint pjp) {
        log.info("请求参数:" + JSON.toJSONString(pjp.getArgs()));
        Object[] args = pjp.getArgs();
    }

    @Around(value = "pintCutWithin())")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        log.info("用户名:" + UserUtil.getName());
        log.info("URL:" + request.getRequestURL().toString());
        log.info("IP:" + request.getRemoteAddr());

        log.info("请求方法:" + pjp.getSignature().getName());
        List<Object> paramList = Stream.of(pjp.getArgs())
                .filter(args -> !(args instanceof ServletRequest))
                .filter(args -> !(args instanceof ServletResponse))
                .collect(Collectors.toList());
        String printParamStr = paramList.size() == 1 ? JSONUtil.toJsonStr(paramList.get(0)) : JSONUtil.toJsonStr(paramList);
        log.info("请求参数:" + printParamStr);

        // 获取当前执行的Service实例
        Object proceed = pjp.proceed();
        return proceed;
    }

}