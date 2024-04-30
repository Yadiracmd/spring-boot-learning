package com.ztf.boot.fi.interceptor;

import com.ztf.boot.fi.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查请求头中是否有token
        String token = request.getHeader("Authorization");
        if (token != null) {
            System.out.println(token);
            boolean validate = JwtUtil.validate(token);
            if(validate){
                return true;
            }else {
                throw new Exception("Token验证失败");
            }

        } else {
            throw new Exception("Token不存在");
        }
    }
}
