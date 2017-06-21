package com.example.demo.entity;

import java.util.Date;

/**
 * Created by admin on 2017/6/2.
 */
public class Blog {

    private Long id;
    private String title;
    private String content;
    private Date createdTime;

    public Blog() {
    }

    public Blog(Long id, String title, String content, Date createdTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdTime = createdTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
