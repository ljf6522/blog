package com.example.my_blog.aop;

import cn.hutool.core.thread.ThreadUtil;
import com.example.my_blog.ann.HoneyLogs;
import com.example.my_blog.model.LVisitLog;
import com.example.my_blog.service.LVisitLogService;
import com.example.my_blog.utils.IpUtils;
import com.example.my_blog.utils.UserAgentUtils;
import com.example.my_blog.utils.UserTokenUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
//@Slf4j
public class LogsAspect {
    @Resource
    LVisitLogService lVisitLogService;
    @Resource
    private UserTokenUtil tokenUtil;

    @AfterReturning(pointcut = "@annotation(honeyLogs)", returning = "jsonResult")
    public void recordLog(JoinPoint joinPoint, HoneyLogs honeyLogs, Object jsonResult) {

        // 获取当前登录的用户的信息
//        User loginUser = new User();
//        loginUser.setUsername("游客");
        // 获取当前登录的用户的信息
//        User loginUser = TokenUtils.getCurrentUser();
//        if (loginUser == null) { // 用户未登录的情况下  loginUser是null  是null的话我们就要从参数里面获取操作人信息
//            // 登录、注册
//            Object[] args = joinPoint.getArgs();
//            if (ArrayUtil.isNotEmpty(args)) {
//                if (args[0] instanceof User) {
//                    loginUser = (User) args[0];
//                }
//            }
//        }
//        if (loginUser == null) {
//            log.error("记录日志信息报错，未获取到当前操作用户信息");
//            return;
//        }
        // 获取HttpServletRequest对象
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userAgent = request.getHeader("user-agent");
//        获取token
//        String token = request.getHeader("token");
//        String username = tokenUtil.getUserName(token);
        // 获取到请求的ip
        String ip = IpUtils.getIpAddr(request);

        LVisitLog visitLog=new LVisitLog();
        visitLog.setVisit("游客");
        visitLog.setLogOperation(honeyLogs.operation());
        visitLog.setPage(honeyLogs.type());
        visitLog.setIpAddress(ip);
        visitLog.setIpSource(IpUtils.getAddress(ip));
        visitLog.setOs(UserAgentUtils.getOs(userAgent));
        visitLog.setBrowser(UserAgentUtils.getBorderName(userAgent));
        visitLog.setCreateTime(new Date());

//        多线程方式插入
        ThreadUtil.execAsync(() -> {
            // 异步记录日志信息
            lVisitLogService.insertLog(visitLog);
        });
    }

}