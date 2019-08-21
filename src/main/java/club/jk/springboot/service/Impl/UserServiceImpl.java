package club.jk.springboot.service.Impl;

import club.jk.springboot.entity.User;
import club.jk.springboot.entityRepository.UserRepository;
import club.jk.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public void deleteUser(String openid) {
        userRepository.deleteByOpenid(openid);
    }

    @Override
    public User getUserInfo(String openid) {
        User user =userRepository.findByOpenid(openid);
        return user;
    }
}
