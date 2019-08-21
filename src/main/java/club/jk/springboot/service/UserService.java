package club.jk.springboot.service;

import club.jk.springboot.entity.User;

public interface UserService {
    public User getUserInfo(String openid);
    public void deleteUser(String openid);
}
