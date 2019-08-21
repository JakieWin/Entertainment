package club.jk.springboot.wechatController;


import club.jk.springboot.entity.User;
import club.jk.springboot.entityRepository.ReadRecordRepository;
import club.jk.springboot.entityRepository.UserRepository;
import club.jk.springboot.service.ReadService;
import club.jk.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private String session_key;



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
    }

    @RequestMapping("getUserInfo")
    public User getUserInfo(String openid){
        //获得用户所有信息
        User user = userService.getUserInfo(openid);
        return user;
    }

    @RequestMapping("deleteUser")
    public void deleteUser(String openid){
        //删除用户所有阅读记录
        readService.deleteReadByUserId(userService.getUserInfo(openid).getId());
        //删除用户
        userService.deleteUser(openid);
    }




}
