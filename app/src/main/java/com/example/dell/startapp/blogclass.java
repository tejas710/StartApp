package com.example.dell.startapp;

/**
 * Created by DELL on 04-11-2016.
 */

public class blogclass {
    private String blogTitle;
    private String blogDescription;
    private String blogImagePath;
    private String postedUser;

    public blogclass(String blogTitle, String blogDescription, String blogImagePath, String postedUser) {
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
        this.blogImagePath = blogImagePath;
        this.postedUser = postedUser;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getBlogImagePath() {
        return blogImagePath;
    }

    public void setBlogImagePath(String blogImagePath) {
        this.blogImagePath = blogImagePath;
    }

    public String getPostedUser() {
        return postedUser;
    }

    public void setPostedUser(String postedUser) {
        this.postedUser = postedUser;
    }
}
