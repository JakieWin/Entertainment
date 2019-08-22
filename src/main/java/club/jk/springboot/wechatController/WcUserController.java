package club.jk.springboot.wechatController;


import club.jk.springboot.common.HttpRequest;
import club.jk.springboot.entity.User;
import club.jk.springboot.service.ReadService;
import club.jk.springboot.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wechat")
public class WcUserController {

    @Value("${wx.openAppid}")
    private String wxAppid;
    @Value("${wx.openSecret}")
    private String wxOpenSecret;
    private String sessionUrl="https://api.weixin.qq.com/sns/jscode2session";



    @Resource
    UserService userService;

    @Resource
    ReadService readService;

    @RequestMapping("/regist")
    public void regist(){

    }

    @RequestMapping("/login")
    public void Login(String code){
        System.out.println(code);
        Map<String,String> param =new HashMap<>();
        param.put("appid",wxAppid);
        param.put("secret",wxOpenSecret);
        param.put("js_code",code);
        param.put("grant_type","authorization_code");
        String session = HttpRequest.sendGet(sessionUrl,param);
        JsonNode web_sessionJson;
        try {
            web_sessionJson = new ObjectMapper().readTree(session);
            String openid = web_sessionJson.path("openid").asText();
            String sessionKey = web_sessionJson.path("session_key").asText();
            System.out.println(openid);
            System.out.println(sessionKey);
            //判断数据库中该openid是否已经存在
            if(StringUtils.isEmpty(userService.getUser(openid))){
                userService.addUser(openid);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("getUserInfo")
    public User getUserInfo(String openid){
        //获得用户所有信息
        User user = userService.getUser(openid);
        return user;
    }

    @RequestMapping("deleteUser")
    public void deleteUser(String openid){
        //删除用户所有阅读记录
        readService.deleteReadByUserId(userService.getUser(openid).getId());
        //删除用户
        userService.deleteUser(openid);
    }
}
