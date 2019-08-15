package club.jk.springboot.wechatController;

import club.jk.springboot.entityRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wechat")
public class WcUserController {

    @Value("${wx.openAppid}")
    private String wxAppid;
    @Value("${wx.openSecret}")
    private String wxOpenSecret;
    private String session_key;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/regist")
    public void regist(){

    }

    @RequestMapping("/login")
    public String Login(@RequestParam String userName,@RequestParam String passWord){
        userRepository.findByUserName(userName);
        if(passWord==passWord){
            
            return "redirect:/index";

        }
        return "";
    }
}
