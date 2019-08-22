package club.jk.springboot.service.Impl;

import club.jk.springboot.entity.User;
import club.jk.springboot.entityRepository.UserRepository;
import club.jk.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public void addUser(String openid) {
        User user = new User();
        user.setOpenid(openid);
        userRepository.findByOpenid(openid);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setRegTime(format.format(new Date()));
        userRepository.save(user);
    }

    //根据用户的openid删除用户
    @Override
    public void deleteUser(String openid) {
        userRepository.deleteByOpenid(openid);
    }

    //根据用户的openid获取用户的信息
    @Override
    public User getUser(String openid) {
        User user =userRepository.findByOpenid(openid);
        return user;
    }
}
