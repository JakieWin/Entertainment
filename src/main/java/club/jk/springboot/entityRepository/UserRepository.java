package club.jk.springboot.entityRepository;

import club.jk.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll();
    User findByUserName(String userName);
    List<User> findByUserNameContaining(String userName);
    User findByUserNameContainingOrEmailAddrContaining(String userName,String emailAddr);


}
