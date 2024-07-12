package com.example.my_blog.realm;

import com.example.my_blog.service.LUserService;
import com.example.my_blog.vo.UserVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/22
 */
public class LoginRealm  extends AuthorizingRealm {
    @Resource
    private LUserService lUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 授权，在认证之后执行
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
        if (StringUtils.isEmpty(token.getPrincipal())) {
            throw new AuthenticationException("token无效");
        }
//        String name = tokenUtil.getUserName((String) token.getPrincipal());
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        UserVo user = lUserService.getUserByName(username);
        //判断用户名是否为aaa否则抛出异常完事密码错误
//        if(user==null){
//            throw new UnknownAccountException("用户名不存在");
//        }
        //把盐放进来
        ByteSource salt=ByteSource.Util.bytes("ljf6522..yes");
        //new SimpleAuthenticationInfo(登录的用户名,数据库查的加密密码，盐值, Realm名可以直接写getName()随便叫啥没所谓)
        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),salt,getName());
    }

}
