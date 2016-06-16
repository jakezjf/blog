package com.jf.model;

import java.util.Date;

public class BlogComment {
    private Integer comId;

    private Integer blogId;

    private String userId;

    private Date addTime;

    private String comInfo;

    private String back1;

    private String back2;

    private String back3;

    private String back4;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getComInfo() {
        return comInfo;
    }

    public void setComInfo(String comInfo) {
        this.comInfo = comInfo == null ? null : comInfo.trim();
    }

    public String getBack1() {
        return back1;
    }

    public void setBack1(String back1) {
        this.back1 = back1 == null ? null : back1.trim();
    }

    public String getBack2() {
        return back2;
    }

    public void setBack2(String back2) {
        this.back2 = back2 == null ? null : back2.trim();
    }

    public String getBack3() {
        return back3;
    }

    public void setBack3(String back3) {
        this.back3 = back3 == null ? null : back3.trim();
    }

    public String getBack4() {
        return back4;
    }

    public void setBack4(String back4) {
        this.back4 = back4 == null ? null : back4.trim();
    }
}