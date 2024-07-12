package com.example.my_blog.other;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/22
 */
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.HostAuthenticationToken;

public class JwtToken implements HostAuthenticationToken {

    private final String token;
    private String host;


    public JwtToken(String token) {
        this.token = token;
    }
    public JwtToken(String token, String host){
        this.token = token;
        this.host = host;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    public String getToken() {
        return this.token;
    }


}
