package com.bahu.buffzs.controller;

import com.bahu.buffzs.pojo.BuffAdminUser;
import com.bahu.buffzs.pojo.BuffUser;
import com.bahu.buffzs.pojo.dto.Result;
import com.bahu.buffzs.pojo.util.SmsSendUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-09
 **/

@Slf4j
@Controller
@Api(description = "登录接口")
@RequestMapping()
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/login")
    public String login() {
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        if (principal != null) {
            return "index";
        }
        return "login";
    }

    /**
     * 跳转到login页面
     *
     * @return
     */
    @RequestMapping(value = "")
    public String loginMain(HttpServletRequest request) {
        String code = request.getParameter("code");
        String username = request.getParameter("username");

        //String s = redisTemplate.opsForValue().get("user_" + username).toString();
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        if (principal != null) {
            if (code.equals("")) {
                return "index";
            }
            return "index";
        }
        return "login";
    }


    @RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
    public String login2() {
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        if (principal != null) {
            return "index";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }


    @ResponseBody
    @RequestMapping(value = "/page")
    public String goHome(BuffUser user) {
//System.out.println(newUser.getName()+newUser.getPassword());
        //shiro用户认证
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken userToken = new UsernamePasswordToken(user.getUsername(), user.getId());
        //执行登录方法,用捕捉异常去判断是否登录成功
        if (StringUtils.isBlank(user.getUsername())) {
            return null;
        }
        String error = null;
        try {
            subject.login(userToken);
            return "redirect:/index";
        } catch (AccountException e) {
            error = "账号名密码错误";
            return "login";
        }

    }

    @ResponseBody
    @GetMapping(value = "/login/main")
    public ModelAndView main(@RequestBody BuffAdminUser adminUser , HttpServletRequest request) {
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        System.out.println(code + "=====" + username);
        String username1 = adminUser.getUsername();
        String password = adminUser.getPassword();
        System.out.println(username1 + password);


        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        ModelAndView mode = new ModelAndView();
        mode.setViewName("index");
        mode.addObject("username", principal);
        return mode;
    }

    @ResponseBody
    @RequestMapping(value = "/")
    public ModelAndView agent() {
        ModelAndView mode = new ModelAndView();
        Subject s = SecurityUtils.getSubject();
        if (s.isAuthenticated()) {
            mode.setViewName("index");
        } else {
            mode.setViewName("login");

        }
        return mode;
    }


    @GetMapping("/login1")
    public ModelAndView login3(HttpServletRequest request) {
        ModelAndView mode = new ModelAndView();
        mode.setViewName("text1");
        return mode;
    }


    @ResponseBody
    @ApiOperation(value = "发送短信")
    @RequestMapping(value = "/sendsms")
    public Result sendsms(@RequestParam String phone) {
        //生成随机验证码: 6位随机数字字符串
        String num = RandomStringUtils.randomNumeric(6);
        if (phone != null || !"".equals(phone)) {
            SmsSendUtil smsSendUtil = new SmsSendUtil();
            boolean send = smsSendUtil.send(phone, num);
            if (send) {
                redisTemplate.opsForValue().set("user_" + phone, num, 5, TimeUnit.MINUTES);
                log.info("短信已发送");
                return Result.success("短信已发送");
            } else {
                log.info("短信发送失败");
                return Result.error("短信发送失败");
            }
        }
        return Result.error("号码不正确");
    }


    /**
     * 手机账号登陆
     *
     * @param request
     * @param userDto
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/register")
    public Result register(HttpServletRequest request, BuffUser userDto) {
        String mobile = userDto.getPhone();
        //验证手机号码
        if (mobile == null || "".equals(mobile)) {
            throw new RuntimeException("手机号码不能为空");
        }

        //  String code = userDto.getCode();

        //从缓存中取出数据
//        String key = "user_" + mobile;
//
//        String num = (String) redisTemplate.opsForValue().get(key);
//        System.out.println(num);
//        if (num == null || "".equals(num)) {
//            return new Result(false, 404, "验证码不能空");
//        }
//        if (!code.equals(num) && code != null) {
//            return new Result(false, 404, "验证码错误");
//        }
        //随机用户昵称
        String username = "buff_" + RandomStringUtils.randomNumeric(6);
        System.out.println(username);

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        BuffUser buffUser = new BuffUser();
        BeanUtils.copyProperties(userDto, buffUser);
        buffUser.setIp(ip);
/*        buffUser.setUsername(username);
        buffUser.setUpdateTime(new Date());
        userMapper.update(buffUser);
        BuffUser buffUser1 = userMapper.selectByModulId(buffUser.getModulId());
        loginMapper.updateByModulId(userDto.getModulId());*/
        return Result.success();


    }

}
