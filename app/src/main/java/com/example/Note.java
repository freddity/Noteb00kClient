package com.example;

import java.io.Serializable;

public class Note implements Serializable {

    private String title;
    private String content;
    private String tag;

    public Note(String title, String content, String tag) {
        this.title = title;
        this.content = content;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTag() {
        return tag;
    }
}
