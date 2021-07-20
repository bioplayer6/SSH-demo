package com.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.image.SecurityCode;
import com.image.SecurityImage;
 
 //添加注解使这个类对象成为控制器
@Controller
@RequestMapping(value = "/code")
public class CodeController {
     //固定public String
     @RequestMapping(value = "/code")
     public void img(HttpServletResponse response, HttpSession session) throws IOException {
         // 获得验证码字符串
         String cool = SecurityCode.getSecurityCode();
         // 将验证码字符串存入到session作用域中,目的是为了判断时有条件可依
         session.setAttribute("code", cool);
         // 将验证码字符串组装拼接成验证码图片
         BufferedImage image = SecurityImage.createImage(cool);
         // 响应到客户端
         ServletOutputStream out = response.getOutputStream();
         // 打印输出验证码到页面中
         ImageIO.write(image, "png", out);
     }
 }
