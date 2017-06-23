package com.wang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wang.model.User;
import com.wang.utils.MultiThread;
import com.wang.utils.QRcode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hppc on 2017/5/9.
 */
@Controller
@RequestMapping("/user")
//@Scope("prototype")  //这一句是 设置为多例模式 spring的bean默认是单例模式de
public class UserController {
    int aa = 0;

    @RequestMapping(value = "/dev",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String test01() {
        User user = new User();
        user.setName("王阳");
        user.setPassword("fdsa951");
        User user1 = new User();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        user1.setName(json);
        return "fuck";
    }
    @RequestMapping(value = "/luanma",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String luanMa() {
        aa++;
        MultiThread multiThread = new MultiThread("新的线程");
        multiThread.start();
        System.out.println(aa);
        return "返回";
    }
    @RequestMapping("/erweima")
    public void erWeiMa(HttpServletResponse response) {
        String content = "王阳";
        QRcode.GET_QRCODE(response,content);
        try {
            response.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println("flush时候出错");
            e.printStackTrace();
        }
        try {
            response.getOutputStream().close();
        } catch (IOException e) {
            System.out.println("close时候出错");
            e.printStackTrace();
        }
    }
}
