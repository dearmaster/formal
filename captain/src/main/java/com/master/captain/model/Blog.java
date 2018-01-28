package com.master.captain.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.master.captain.util.CustomizeDateSerialize;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_captain_blog")
public class Blog {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "subject", nullable = false, length = 100)
    private String subject;
    @Type(type="text")
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "publish_time")
    @JsonSerialize(using = CustomizeDateSerialize.class)
    private Date publishTime;
    @JsonSerialize(using = CustomizeDateSerialize.class)
    @Column(name = "latest_update_time")
    private Date latestUpdateTime;
    @JoinColumn(name = "category_id")
    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Category category;
    @Column(name = "viewed_times")
    private Integer viewedTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getLatestUpdateTime() {
        return latestUpdateTime;
    }

    public void setLatestUpdateTime(Date latestUpdateTime) {
        this.latestUpdateTime = latestUpdateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getViewedTimes() {
        return viewedTimes;
    }

    public void setViewedTimes(Integer viewedTimes) {
        this.viewedTimes = viewedTimes;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", latestUpdateTime=" + latestUpdateTime +
                ", category=" + category +
                ", viewedTimes=" + viewedTimes +
                '}';
    }

}