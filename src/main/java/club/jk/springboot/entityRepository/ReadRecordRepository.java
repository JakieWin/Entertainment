package club.jk.springboot.entityRepository;

import club.jk.springboot.entity.ReadRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadRecordRepository extends JpaRepository<ReadRecord,Long> {
    Page<ReadRecord> findByUserId(long userId, Pageable pageable);
    ReadRecord findByUserIdAndBookId(long userId,long bookId);
    void deleteByUserIdAndBookId(long userId,long bookId);
    void deleteByUserId(long userId);

}
