package com.example.my_blog.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
//    private static Logger log = LoggerFactory.getLogger(JWTUtil.class);
//
//    private static final long EXPIRE = 1 * 60 * 1000;// token的有效时长
//    private static final String SECRET = "jwt+shiro+heZhan";// token的私钥
//    private static final String USER_KEY = "username";
//
//
//    public static String createBearerToken(String userName){
//        return "Bearer " + createToken(userName);
//    }
//
//    /**
//     * 创建token
//     * @return 创建的token
//     */
//    public static String createToken(String username){
//        // token的过期时间
//        long current = System.currentTimeMillis();
//        Date date = new Date(current + EXPIRE);
//        // jwt的header部分
////        Map<String, Object> map = new HashMap<>();
////        map.put("alg", "HS256");
////        map.put("typ", "JWT");
//        Algorithm algorithm = Algorithm.HMAC256("ljf");
//        // 创建token
//        String token;
//        try {
//            token = JWT.create()
//                    .withClaim(USER_KEY, username) //存储用户信息
//                    .withClaim("current", current) //当前的时间戳
//                    .withExpiresAt(date) //过期时间
//                    .withIssuedAt(new Date(current)) //签发时间
//                    .sign(algorithm);
//        } catch (Exception e){
//            log.error("为用户{}创建token失败", username);
//            throw new RuntimeException("为用户创建token失败", e);
//        }
//        return token;
//    }
//
//    /**
//     * 校验token
//     * @param token 传入的token
//     * @return 是否校验通过
//     */
//    public static DecodedJWT verifyToken(String token) throws AuthenticationException {
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//            return verifier.verify(token);
//        } catch (Exception e){
//            log.error("校验token={}失败", token, e);
//            throw e;
//        }
//    }
//
//    /**
//     * 从token中获取用户信息
//     * @param token 传入的token
//     * @return 用户信息
//     */
//    public static String getUserInfo(String token){
//        try {
//            DecodedJWT jwt = verifyToken(token);
//            return jwt.getClaim(USER_KEY).asString();
//        } catch (Exception e){
//            log.error("从token={}中获取用户信息失败", token, e);
//            return null;
//        }
//    }
//
//    /**
//     * 判断是否过期
//     */
//    public static boolean isExpire(String token) {
//        DecodedJWT jwt = JWT.decode(token);
//        return jwt.getExpiresAt().getTime() < System.currentTimeMillis();
//    }

}
