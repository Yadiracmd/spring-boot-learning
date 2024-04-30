package com.ztf.boot.fi.interceptor;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.ztf.boot.fi.constant.Constant;
import com.ztf.boot.fi.result.Result;
import com.ztf.boot.fi.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class ImageInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开始拦截图片");
        if (!(request instanceof MultipartHttpServletRequest)) {
            return true;
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");  // 获取上传的文件，"file"应当是你的<input>标签的name属性的值

        InputStream in = file.getInputStream();
        String savePath = "D:\\upload\\" + file.getOriginalFilename();
        Path outputPath = Paths.get(savePath);
        Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);


        JSONObject jsonObject = JwtUtil.getPayload(request.getHeader("Authorization"));
        // 获取用户名和编号
        String nickname = jsonObject.get("nickname").toString();
        String userId = jsonObject.get("userId").toString();

        // 添加水印
        ImgUtil.pressText(//
                FileUtil.file(savePath), //
                FileUtil.file("D:\\upload\\new\\" + file.getOriginalFilename()), //
                nickname + " " + userId, Color.WHITE, //文字
                new Font("黑体", Font.BOLD, 100), //字体
                0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
        );


        request.setAttribute("interceptData", "D:\\upload\\new\\" + file.getOriginalFilename());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getAttribute("resultUrl").toString();


        // 通过response.getWriter().write方法将这个JSON字符串写入到response的输出流中
        BufferedImage image = QrCodeUtil.generate(url, 300, 300);


        // 将image转成base64
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        String s = Base64.getEncoder().encodeToString(outputStream.toByteArray());


        // 返回请求
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Result<String> stringResult = new Result<>();
        stringResult.setData(s);

        // 创建一个ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 使用ObjectMapper的writeValueAsString方法将stringResult对象转化为JSON字符串
        String resultJson = objectMapper.writeValueAsString(stringResult);



        response.getWriter().write(resultJson);
    }

}
