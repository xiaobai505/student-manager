package com.agoni.system.controller;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/sdk")
@Slf4j
@Api(tags = "短信验证")
public class SampleController {
    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId accessKeyId
     * @param accessKeySecret accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }


    @RequestMapping("/sendSms")
    @SneakyThrows(Exception.class)
    public static void main(String[] args_) {
        com.aliyun.dysmsapi20170525.Client client =
                SampleController.createClient("***", "****");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers("17611678927")
                .setSignName("GY董")
                .setTemplateCode("SMS_170660489")
                .setTemplateParam("{\"user\":\"1234\",\"pwd\":\"321aa\"}");
        RuntimeOptions runtime = new RuntimeOptions();

        // 复制代码运行请自行打印 API 的返回值
        SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, runtime);
        System.out.print("ok");
    }
}
