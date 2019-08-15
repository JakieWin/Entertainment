package club.jk.springboot.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String bookName;
    @Column(nullable = false)
    private long categoryId;                              //小说分类id
    @Column(nullable = false)
    private String author;                                //作者名
    @Column(nullable = false)
    private long UpLoader;                           //上传者的id
    @Column(nullable = false)
    private String content;                           //小说简介
    @Column
    private String bookPath;                         //小说文件路径
    @Column
    private long chapterNumber;                     //小说章节的总数目
    @Column
    private String bookCoverPath;                  //小说封面图片路径

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author!= null){
            this.author = author;
        }
        //如果作者名未设置，则默认为无名氏
        if(author == null){
            author = "无名氏";
        }
    }

    public long getUpLoader() {
        return UpLoader;
    }

    public void setUpLoader(long upLoader) {
        UpLoader = upLoader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public long getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(long chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getBookCoverPath() {
        return bookCoverPath;
    }

    public void setBookCoverPath(String bookCoverPath) {
        this.bookCoverPath = bookCoverPath;
    }
}
