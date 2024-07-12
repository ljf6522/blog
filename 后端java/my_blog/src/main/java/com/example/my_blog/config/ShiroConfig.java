package com.example.my_blog.config;

import com.example.my_blog.filter.TokenFilter;
import com.example.my_blog.realm.LoginRealm;
import com.example.my_blog.realm.ShiroRealm;
import com.example.my_blog.other.CustomModularRealmAuthenticator;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/22
 */
@Configuration
public class ShiroConfig {
    /**
     * 配置代理，没有配置将会导致注解不生效
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /**
     * 配置代理，没有配置将会导致注解不生效
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 将自己的验证方式加入容器
     * @return
     */
    @Bean
    public Realm loginRealm() {
        LoginRealm loginRealm = new LoginRealm();
        HashedCredentialsMatcher credentials= new HashedCredentialsMatcher();
        credentials.setHashIterations(5);//加密次数
        credentials.setHashAlgorithmName("SHA-256");//加密方式
        loginRealm.setCredentialsMatcher(credentials);//注入到AuthRealm实现类中
        return loginRealm;
    }

    @Bean
    public Realm shiroRealm() {
        ShiroRealm shiroRealm=new ShiroRealm();
        return shiroRealm;
    }

    /**
     * 不应该将过滤器的实现注册为bean，否则会导致Filter过滤器顺序混乱，导致抛出异常
     * 如果一定要注册为 Bean，可以使用 Order 指定优先级，还未尝试过
     * @return
     */
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    /**
     * Filter工厂，设置对应的过滤条件和跳转条件
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        Map<String, String> map = new HashMap<>();
        //登出
        map.put("/logout", "logout");
//        map.put("/api/**", "anon");
        // 使用我们自己创建的jwt过滤器名称
        map.put("/**", "jwt");
        map.put("/login","anon");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/select");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setFilters(new HashMap<String, Filter>(){{put("jwt", tokenFilter());}});
        return shiroFilterFactoryBean;
    }


    @Bean
    public Authenticator authenticator() {
        ModularRealmAuthenticator authenticator = new CustomModularRealmAuthenticator();
//        Set<Realm> realms = new HashSet<Realm>();
//        realms.add(loginRealm());
//        realms.add(shiroRealm());
//        authenticator.setRealms(realms);
        authenticator.setRealms(Arrays.asList(shiroRealm(), loginRealm()));
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return authenticator;
    }


    /**
     * 权限管理，配置主要是Realm的管理认证，同时可以配置缓存管理等
     * @return
     */
//    @Bean
    //    将realm加入管理器中
    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        Set<Realm> realms = new HashSet<Realm>();
        realms.add(loginRealm());
        realms.add(shiroRealm());
        //realm管理
        webSecurityManager.setRealms(realms);
        webSecurityManager.setAuthenticator(authenticator());//解决多realm的异常问题重点在此
//        webSecurityManager.setRealm(loginRealm());
        return webSecurityManager;
    }

}
