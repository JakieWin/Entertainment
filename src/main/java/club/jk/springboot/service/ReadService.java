package club.jk.springboot.service;

import club.jk.springboot.entity.ReadRecord;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReadService {
    public List<ReadRecord> findByUserId(long userId,Pageable pageable);
    public void addRead(long userId,long bookId,String schedule);
    public void updateRead(long userId,long bookId,long chapter,String schedule);
    public void deleteRead(long userId,long bookId);
    public void deleteReadByUserId(long userId);
}
