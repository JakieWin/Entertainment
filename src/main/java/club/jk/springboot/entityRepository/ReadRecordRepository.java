package club.jk.springboot.entityRepository;

import club.jk.springboot.entity.ReadRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadRecordRepository extends JpaRepository<ReadRecord,Long> {
    List<ReadRecord> findByUserId(long userId);
    ReadRecord findByUserIdAndBookId(long userId,long bookId);
    void deleteByUserId(long userId);
}
