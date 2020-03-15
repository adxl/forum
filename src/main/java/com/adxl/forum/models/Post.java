package com.adxl.forum.models;

import java.util.Date;

public class Post {

    private String text;
    private int upvotes;
    private int downvotes;
    private Date date;

    public Post() {
    }

    public Post(String text) {
        this.text = text;
        upvotes = 0;
        downvotes = 0;
        date = new Date();
    }

    public String getText() {
        return text;
    }

    public void upvote() {
        upvotes++;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void downvote() {
        downvotes++;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public int getScore() {
        return upvotes - downvotes;
    }

    public Date getDate() {
        return date;
    }
}
