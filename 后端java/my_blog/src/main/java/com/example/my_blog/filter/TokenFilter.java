package com.example.my_blog.filter;

import cn.hutool.json.JSONObject;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.my_blog.common.Result;
import com.example.my_blog.utils.JWTUtil;
import com.example.my_blog.utils.UserTokenUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.BearerToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * shiro的过滤器
 */
public class TokenFilter extends BasicHttpAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(TokenFilter.class);

    /**
     * 判断用户是否想要登入。
     * 检测header里面是否包含Authorization字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(AUTHORIZATION_HEADER);
        return authorization != null;
    }

    /**
     * 这里我们详细说明下为什么最终返回的都是true，即允许访问
     * 例如我们提供一个地址 GET /article
     * 登入用户和游客看到的内容是不同的
     * 如果在这里返回了false，请求会被直接拦截，用户看不到任何东西
     * 所以我们在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
     * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
     * 但是这样做有一个缺点，就是不能够对GET,POST等请求进行分别过滤鉴权(因为我们重写了官方的方法)，但实际上对应用影响不大
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断请求的请求头是否带上 "Token"
        if (isLoginAttempt(request, response)) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                return executeLogin(request, response);
            } catch (Exception e) {
                //token 错误
                e.printStackTrace();
                return false;
            }
        }
        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }

//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//        // GET和OPTIONS请求全部放行
//        if (request.getMethod().equals("GET")) {
//            return true;
//        }
//        if (request.getMethod().equals("OPTIONS")) {
//            return true;
//        }
//
//        String url = request.getRequestURL().toString();
//        // 截取请求路径的一部分
//        // 如：localhost:8080/api/user/modify
//        // 截取：/user/modify
//        String str = url.substring(url.lastIndexOf(":") + 9);
//
//        System.out.println("拦截请求路径：{}"+ str);
//        // 登录注册放行
//        if (str.startsWith("/user/") && !str.contains("modify")) {
//            return true;
//        }
//
//        String token = request.getHeader("JWT");
//        System.out.println("JWT:" + token);
//
//        if (token!=null) {
//            System.out.println("过滤器拦截到请求：{}，拦截原因：用户未登录"+url);
//        }
//
//        BearerToken jwtToken = new BearerToken(token);
//        try {
//            getSubject(servletRequest, servletResponse).login(jwtToken);
//        } catch (Exception e) {
//            return false;
//        }
//
//        return true;
//    }
@Override
protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse response, Object mappedValue) throws Exception {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    //在拦截器中设置允许跨域
    httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setHeader("Access-Control-Allow-Headers","*");
    httpServletResponse.setHeader("Access-Control-Allow-Methods","*");
    httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
    httpServletResponse.setHeader("Access-Control-Max-Age","3600");
    httpServletResponse.setStatus(200);
    httpServletResponse.setContentType("application/json;charset=utf-8");
    PrintWriter out = httpServletResponse.getWriter();
    //ResponseDataVO vo = new ResponseDataVO();
    //vo.setCode("403");
    //vo.setMessage("登录失效，请重新登录");
    //out.println(vo);
    JSONObject json = new JSONObject();
    json.put("code", 401);
    json.put("message", "登录失效，请重新登录!");
    json.put("data","");
    out.println(json);
    out.flush();
    out.close();
    return false;//return false阻止shiro继续走其他的自定义filter
}



    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
//        System.out.println("token："+token);
        BearerToken jwtToken = new BearerToken(token, request.getRemoteAddr());
        try {
            getSubject(request, response).login(jwtToken);
            // 如果没有抛出异常则代表登入成功，返回true
            return true;
        } catch (AuthenticationException e) {
//            httpServletRequest.setAttribute("exception", "未登录！"+e);
//            httpServletRequest.getRequestDispatcher("/error").forward(request, response);
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().print("401");
            return false;
        }
//        return true;
    }

}
