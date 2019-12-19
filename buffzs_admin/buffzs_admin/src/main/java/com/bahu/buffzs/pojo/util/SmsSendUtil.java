package com.bahu.buffzs.pojo.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author： Mr.Baron
 * @date： 2019/10/30
 * @description：
 */

public class SmsSendUtil {
    private static final Logger LOG = LoggerFactory.getLogger(SmsSendUtil.class);

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String PRODUCT = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";
    // 签名KEY
    private static final String ACCESS_KEY_ID = "LTAI4FtopQihZ2ss7uD1od2Y";
    // 签名密钥
    private static final String ACCESS_KEY_SECRET = "J2cQ79XpJCqtskqlQvfL7qR6BQwp6h";
    // 短信模板
    private static final String TEMPLATE_CODE = "SMS_176575332";
    // 短信签名
    private static final String SIGN_NAME = "buff助手";

    /**
     * 发送短信验证码方法
     *
     * @param mobile 手机号码
     * @param
     * @return true: 成功 false: 失败
     */
    public  boolean send(String mobile,String num) {
        try {
            /** 初始化acsClient,暂不支持region化 */
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            // cn-hangzhou: 中国.杭州
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            // 组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            // 必填: 待发送手机号
            request.setPhoneNumbers(mobile);
            // 必填: 短信签名-可在短信控制台中找到
            request.setSignName(SIGN_NAME);
            // 必填: 短信模板-可在短信控制台中找到
            request.setTemplateCode(TEMPLATE_CODE);
            /*
             * 可选: 模板中的变量替换JSON串,
             * 如模板内容为"亲爱的${name},您的验证码为${code}" */

            request.setTemplateParam("{\"code\":\"" + num + "\"}");
            // hint 此处可能会抛出异常，注意catch
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            LOG.info(sendSmsResponse.getMessage());
            LOG.info(sendSmsResponse.getCode());
            // 判断短信是否发送成功
            return sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK");
        } catch (Exception ex) {
            LOG.info("message",ex);
            throw new RuntimeException(ex);
        }

    }

}
