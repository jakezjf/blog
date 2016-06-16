package com.jf.model;

public class BlogType {
    private Integer blogType;

    private String typeName;

    private String back1;

    private String back2;

    private String back3;

    private String back4;

    public Integer getBlogType() {
        return blogType;
    }

    public void setBlogType(Integer blogType) {
        this.blogType = blogType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
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