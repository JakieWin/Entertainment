package club.jk.springboot.wechatController;

import club.jk.springboot.entity.Book;
import club.jk.springboot.entityRepository.BookRepository;
import club.jk.springboot.service.BookService;
import club.jk.springboot.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WcBookController {

    @Autowired
    BookRepository bookRepository;

    @Resource
    BookService bookService;

    //根据类别寻找书籍
    @RequestMapping("/getBookByCategory")
    public List<Book> getBookByCategory(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                        @RequestParam(value = "size", defaultValue = "5") Integer size,
                                        @RequestParam(value = "categoryId", defaultValue = "1") long categoryId){
        //设置分页参数
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.ASC,"id");
        List<Book> books = bookService.findByCategoryId(categoryId,pageable);
        return books;
    }

    //根据搜索寻找书籍
    @RequestMapping("getBookBySearch")
    public List<Book> getBookBySearch(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "5") Integer size,
                                      @RequestParam(value = "search",required = false) String search){
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.ASC,"id");
        List<Book> books = bookService.findBySearch(search,pageable);
        return books;
    }
}
