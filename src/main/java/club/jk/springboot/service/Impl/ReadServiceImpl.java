package club.jk.springboot.service.Impl;

import club.jk.springboot.entity.ReadRecord;
import club.jk.springboot.entityRepository.ReadRecordRepository;
import club.jk.springboot.service.ReadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReadServiceImpl implements ReadService {

    @Resource
    ReadRecordRepository readRecordRepository;

    //根据用户查看他的书架上的书情况
    @Override
    public List<ReadRecord> findByUserId(long userId,Pageable pageable) {
        Page<ReadRecord> bookShelfPage = readRecordRepository.findByUserId(userId,pageable);
        List<ReadRecord> bookshelf = bookShelfPage.getContent();
        return bookshelf;
    }

    //加入一个阅读记录
    @Override
    public void addRead(long userId, long bookId, String schedule) {
        ReadRecord readRecord = new ReadRecord();
        readRecord.setUserId(userId);
        readRecord.setBookId(bookId);
        readRecord.setChapter(1);
        readRecord.setSchedule(schedule);
        readRecordRepository.save(readRecord);
    }

    //更新用户阅读记录
    @Override
    public void updateRead(long userId, long bookId, long chapter, String schedule) {
        ReadRecord readRecord = readRecordRepository.findByUserIdAndBookId(userId,bookId);
        readRecord.setChapter(chapter);
        readRecord.setSchedule(schedule);
        readRecordRepository.save(readRecord);
    }

    //删除用户单个阅读记录
    @Override
    public void deleteRead(long userId, long bookId) {
        readRecordRepository.deleteByUserIdAndBookId(userId,bookId);
    }

    //删除用户所有阅读记录
    @Override
    public void deleteReadByUserId(long userId) {
        readRecordRepository.deleteByUserId(userId);
    }
}
