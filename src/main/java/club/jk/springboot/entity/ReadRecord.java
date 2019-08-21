package club.jk.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//所有加入用户书架的书都会加一条阅读记录,进度为初始化的0，如果用户在读，则为当前进度
@Entity
public class ReadRecord implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private long userId;
    @Column
    private long bookId;
    @Column(nullable = false)
    private long chapter;                      //小说读到的章节
    @Column
    private String schedule;                   //小说阅读进度

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getChapter() {
        return chapter;
    }

    public void setChapter(long chapter) {
        this.chapter = chapter;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
