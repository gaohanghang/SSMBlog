package ssm.blog.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 博客实体
 * @author 高行行
 */
public class Blog {

    private Integer id; //博客主键
    private String title; //博客题目
    private String summary; //博客摘要
    private Date releaseDate; //发布日期
    private Integer clickHit; //评论次数
    private Integer replyHit; //回复次数
    private String content; //博客内容
    private String keyWord; //关键字，用空格隔开

    private BlogType blogType; //博客类型
    private Integer blogCount; //博客数量，非博客实际属性，用于根据发布日期归档查询
    private String releaseDateStr; //发布日期的字符串，只取年月

    private List<String> imageList = new LinkedList<String>();//博客里存的图片，主要用于展示缩略图

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }


}
