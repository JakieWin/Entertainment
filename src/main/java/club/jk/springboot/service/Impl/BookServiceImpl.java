package club.jk.springboot.service.Impl;

import club.jk.springboot.entity.Book;
import club.jk.springboot.entityRepository.BookRepository;
import club.jk.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookRepository bookRepository;

    //根据书的类目显示书籍
    @Override
    public List<Book> findByCategoryId(long categoryId,Pageable pageable) {
        Page<Book> booksPage = bookRepository.findByCategoryId(categoryId,pageable);
        List<Book> books = booksPage.getContent();
        return books;
    }

    //传入分页参数及搜索内容，对小说书名，作者，概述进行模糊搜索
    @Override
    public List<Book> findBySearch(String search,Pageable pageable) {
        search = "%" + search + "%";//只可以搜索传入搜索内容为连贯的
        //将搜索内容对书籍的名称、作者、概述均进行匹配，从而实现模糊搜索
        Page<Book> booksPage= bookRepository.findByBookNameLikeOrAuthorLikeOrContentLike(search,search,search,pageable);
        List<Book> books = booksPage.getContent();
        return books;
    }
}
