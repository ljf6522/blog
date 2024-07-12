package com.example.my_blog.realm;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.my_blog.model.LPermissions;
import com.example.my_blog.service.LUserService;
import com.example.my_blog.other.JwtToken;
import com.example.my_blog.utils.JWTUtil;
import com.example.my_blog.utils.UserTokenUtil;
import com.example.my_blog.vo.RoleVo;
import com.example.my_blog.vo.UserVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/22
 */
public class ShiroRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroRealm.class);

    @Resource
    private LUserService lUserService;
    @Resource
    private UserTokenUtil tokenUtil;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof BearerToken;
    }
    /**
     * 授权，在认证之后执行
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String token = (String) principals.getPrimaryPrincipal();
//        System.out.println("我是授权"+token);
        String username = tokenUtil.getUserName(token);
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();

//        System.out.println("这是roles"+tokenUtil.getUserRoles(token));

        for (String userRole : tokenUtil.getUserRoles(token)) {
            simpleAuthenticationInfo.addRole(userRole);
        }
//        根据用户名获取角色
//        UserVo user = lUserService.getUserByNameAndRolesAndPs(username);
//        添加角色和权限
//        for (RoleVo role : user.getRoles()) {
//            // 添加角色
//            simpleAuthenticationInfo.addRole(role.getRoleName());
//            // 添加权限
////            simpleAuthenticationInfo.addStringPermissions(role.getPermissions()
////                    .stream()
////                    .map(LPermissions::getPermissionsName)
////                    .collect(Collectors.toSet()));
//        }
        return simpleAuthenticationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 返回认证信息，由Shiro来比对输入的密码和存储的密码是否一致
//        if (StringUtils.isEmpty(token.getPrincipal())) {
//            throw new AuthenticationException("token无效");
//        }
        String name;
        try {
            name = tokenUtil.getUserName((String) token.getPrincipal());
        } catch (Exception e) {
            throw new AuthenticationException("该token非法，可能被篡改或过期");
        }

//        String name = tokenUtil.getUserName((String) token.getPrincipal());
//        String name = JWTUtil.getUserInfo((String) token.getPrincipal());
//        if (name == null) {
//            throw new AuthenticationException("该token非法，可能被篡改或过期");
//        }
        UserVo user = lUserService.getUserByName(name);
        if (user == null) {
//            System.out.println("用户不存在!)");
            throw new AuthenticationException("用户不存在!");
        }
//        if ("TokenExpiredException".equals(tokenUtil.verify((String) token.getPrincipal()))) {
//            throw new TokenExpiredException("token认证失效，token过期，重新登陆（人为抛出异常）");
//        }
        // 第一个参数是主体，将会在授权时封装成PrincipalCollection.getPrimaryPrincipal()进行使用，所以必须将jwt内容传回
        // 第二个参数是认证信息，即密码，为后面验证可以通过，需要和token中的内容一样
        // 第三个参数是领域名称
//        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), getName());
        return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), user.getUsername());
    }


}
