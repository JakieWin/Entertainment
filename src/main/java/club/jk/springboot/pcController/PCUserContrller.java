package club.jk.springboot.pcController;

import club.jk.springboot.entity.User;
import club.jk.springboot.entityRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PCUserContrller {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("setUser")
    public void setUser(){
        Date date = new Date();
        DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = format.format(date);
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User user = userRepository.findByUserName("jk");
        return user;
    }

    @RequestMapping("/getAll")
    public List<User> getAll(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
