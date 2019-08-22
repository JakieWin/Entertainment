package club.jk.springboot.service;

import club.jk.springboot.entity.User;

public interface UserService {
    public User getUser(String openid);
    public void deleteUser(String openid);
    public void addUser(String openid);
}
