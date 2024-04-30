package com.ztf.boot.fi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;


@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求信息如下：");
        log.info("请求方法： " + request.getMethod());
        log.info("请求目标资源： " + request.getRequestURI());
        log.info("请求参数： " + getParamString(request.getParameterMap()));
        log.info("发起请求时间： " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return true;
    }

    /**
     * 将请求参数转换为字符串
     * @param paramMap 请求参数
     * @return 参数字符串
     */
    private String getParamString(Map<String, String[]> paramMap) {
        StringBuilder paramStr = new StringBuilder();
        for (String key : paramMap.keySet()) {
            paramStr.append(key).append(":");
            String[] values = paramMap.get(key);
            for(String value:values) {
                paramStr.append(value).append(",");
            }
            paramStr.append(";");
        }
        return paramStr.toString();
    }
}