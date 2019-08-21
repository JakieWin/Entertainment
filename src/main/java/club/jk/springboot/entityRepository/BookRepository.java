package club.jk.springboot.entityRepository;

import club.jk.springboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAll();
    void deleteById(long id);
    List<Book> findByUpLoader(long id);
    Page<Book> findByCategoryId(long categoryId, Pageable pageable);
    Page<Book> findByBookNameLikeOrAuthorLikeOrContentLike(String bookName,String author,String content,Pageable pageable);
}
