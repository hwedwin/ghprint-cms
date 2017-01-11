package com.ghprint.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by xiaoming on 16/3/14.
 * 应用属性获取
 * 应用改造完成后,可以在应用部署服务器通过 curl http://localhost:8030/healthcheck.html 查看访问结果
 * TODO 考虑到当前logback和log4j的使用还没统一,demo中不输出日志,有代码洁癖的各位,请自行补足日志信息输出
 */
@Controller
@RequestMapping("/")
public class HealthCheckController {


    /**
     * 定义响应信息
     */
    private String opsInfo;



    public HealthCheckController() {
        BufferedInputStream inputStream=null;
        try{
            inputStream = new BufferedInputStream(HealthCheckController.class.getResourceAsStream("/healthcheck.html"));
            StringBuilder sb = new StringBuilder();
            byte[] line = new byte[2048];
            while (inputStream.read(line) != -1) {
                sb.append(new String(line));
            }
            opsInfo = sb.toString();
        } catch (FileNotFoundException e) {
            opsInfo = "healthcheck.html file not exist";
            System.out.print(opsInfo);
        } catch (IOException e) {
            opsInfo = "healthcheck.html info read error";
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * 应用打包相关信息
     *
     * @return project.version
     */
    @RequestMapping({"healthcheck.html"})
    @ResponseBody
    public String healthCheck() {
        return opsInfo;
    }

}











