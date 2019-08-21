package club.jk.springboot.service;

import club.jk.springboot.entity.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BookService {
    public List<Book> findByCategoryId(long categoryId, Pageable pageable);
    public List<Book> findBySearch(String search,Pageable pageable);
}
