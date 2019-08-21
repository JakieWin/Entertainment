package club.jk.springboot.wechatController;

import club.jk.springboot.entity.ReadRecord;
import club.jk.springboot.entityRepository.ReadRecordRepository;
import club.jk.springboot.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WcReadController {

    @Resource
    ReadService readService;

    @RequestMapping("/getMyRead")
    public List<ReadRecord> getMyShelf(long userId,Integer page, Integer size){
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,"id");
        List<ReadRecord> bookShelf = readService.findByUserId(userId,pageable);
        return bookShelf;
    }

    //将某本书加入书架
    @RequestMapping("addRead")
    public void addRead(long userId,long bookId,String schedule){
        readService.addRead(userId,bookId,schedule);
    }

    @RequestMapping("updateRead")
    public void updateRead(long userId,long bookId,long chapter,String schedule){
        readService.updateRead(userId,bookId,chapter,schedule);
    }

    @RequestMapping("deleteRead")
    public void updateRead(long userId,long bookId){
        readService.deleteRead(userId,bookId);
    }
}
