package com.example.my_blog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.my_blog.service.LUserService;
import com.example.my_blog.vo.RoleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserTokenUtil {
    /**
     * jwt 加密算法
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserTokenUtil.class);

    private Algorithm algorithm;
    private JWTVerifier verifier;

//    @Value("${jwt.secret}")
//    private String secret;
//    @Value("${jwt.expiration}")
//    private Long expiration;

    @Resource
    private LUserService lUserService;

    public UserTokenUtil() {
        algorithm = Algorithm.HMAC256("ljf");
        verifier = JWT.require(algorithm).build();
    }

    /**
     * 创建用户token，并将token创建时间存入
     *
     * @param username 用户名称
     * @return token字符串
     */
    public String createToken(String username) {
//        生成token时间
        Date expireTime = new Date(System.currentTimeMillis() + 12 * 60 * 60 * 1000);
//        Map<String, Object> claims = new HashMap<>();
////        claims.put("id",userDetails.getId());
//        claims.put(CLAIM_KEY_USERNAME, username);
//        claims.put(CLAIM_KEY_CREATED, new Date());

        List<String> roleNameList = lUserService.getUserByNameAndRolesAndPs(username).getRoles().stream().map(RoleVo::getRoleName).collect(Collectors.toList());

        return JWT.create()
                .withClaim("roles", roleNameList)
                .withClaim("username", username)
                .withExpiresAt(expireTime)
                .sign(algorithm);
    }

    /**
     * 校验token合法性
     *
     * @param token
     * @return
     */
//    public String verify(String token) {
//        try {
//            verifier.verify(token);
//            return "success";
//        } catch (TokenExpiredException e){
//            // token过期
//            return "TokenExpiredException";
//        } catch (Exception exception) {
//            return "otherException";
//        }
//    }

    public DecodedJWT verifyToken(String token) {

        try {
            return verifier.verify(token);
        } catch (Exception e) {
            throw new TokenExpiredException("token 解析失败");
        }
    }

    /**
     * 取得用户名
     *
     * @param token
     * @return
     */
    public String getUserName(String token) {
        DecodedJWT jwt = verifyToken(token);
        return jwt.getClaim("username").asString();
    }

    public List<String> getUserRoles(String token) {
        DecodedJWT jwt = verifyToken(token);
        return jwt.getClaim("roles").asList(String.class);
    }
}
