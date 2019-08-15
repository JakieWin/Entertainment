package club.jk.springboot.entityRepository;

import club.jk.springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository {
    List<Category> findAll();

}
