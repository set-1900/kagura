package com.bahu.buffzs.aop;

import com.bahu.buffzs.pojo.BuffLog;
import com.bahu.buffzs.service.LoggerService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author： Mr.Baron
 * @date： 2019/11/29
 * @description：
 */
@Slf4j
@Aspect//这是一个切面
@Component//告诉Spring需要将其加入到IOC容器
public class BuffLogger {
    @Autowired
    private LoggerService gameLoggerService;

    //切点， 每一个controller请求方法
    @Pointcut("execution(public * com.bahu.buffzs.controller.ApkController.createAndSetSignApk(..))")
    public void pointCut() {

    }

    //切点2， 每一个controller请求方法
    @Pointcut("execution(public * com.bahu.buffzs.controller..*.*(..))")
    public void pointCut2() {

    }

    /**
     * 点击下载按钮 创建一条日志
     *
     * @param joinPoint
     * @param returnMsg
     */
    @AfterReturning(pointcut = "pointCut()", returning = "returnMsg")
    public void doAfterReturn(JoinPoint joinPoint, Object returnMsg) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration<String> enumerations = request.getParameterNames();
        Map<String, String> parameterMaps = Maps.newHashMap();
        if (enumerations != null) {
            while (enumerations.hasMoreElements()) {
                String parameter = enumerations.nextElement();
                parameterMaps.put(parameter, request.getParameter(parameter));
            }
        }
        String url = parameterMaps.get("url");
        if (parameterMaps.get("url") == null) {
            log.info(url + "url is null");
            return;
        }
        gameLoggerService.save(url);
        //与前置增强一致记录下方法名
        log.info("buffLog----class_method==>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }

    @Around("execution(public * com.bahu.buffzs.controller..*.*(..))")
    public Object doAfterReturn22(ProceedingJoinPoint pjp) {
        String methodName = "";
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //获取 method 操作方法  action 操作名称
            //首先获取ProceedingJoinPoint 签名  (方法有签名   方法名称 返回值类型 参数类型 及 参数个数)
            Signature signature = pjp.getSignature();
            if (signature instanceof MethodSignature) { //判断当前签名是不是方法签名
                MethodSignature methodSignature = (MethodSignature) signature; //如果是的话 就进行转换成方法签名
                Method method = methodSignature.getMethod(); //获取方法
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    methodName = method.getName();
                    log.info("=================" + methodName + "方法日志记录开始=================");
                    log.info("URL: " + request.getRequestURL());
                    Parameter[] methodParameters = method.getParameters();
                    String str = "";
                    if (methodParameters.length != 0) {
                        for (int i = 0; i < methodParameters.length; i++) {
                            str += methodParameters[i].getParameterizedType().getTypeName() + " " + methodParameters[i].getName() + ", ";
                        }
                        str = str.substring(0, str.length() - 2);
                    }
                    Class<?> returnType = method.getReturnType();
                    log.info("执行方法: public " + returnType.getSimpleName() + " " + methodName + "(" + str + ")");
                }
            }
            //1.获取当前执行方法所需的参数
            Object[] args = pjp.getArgs();
            String param = "";
            for (Object arg : args) {
                if (arg != null) {
                    if (!arg.equals("")) {
                        param += arg.toString() + ", ";
                    } else {
                        param += ", ";
                    }
                } else {
                    param += ", ";
                }
            }
            if (!param.toString().equals("")) param = param.substring(0, param.length()-2);
            log.info("方法实际参数: " + param);
            //2.执行方法并返回
            return pjp.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
            loging(e);
        } finally {
            log.info("=================" + methodName + "日志记录结束=================");
        }
        return null;
    }

    public void loging(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        log.info(sw.toString());
    }

}
