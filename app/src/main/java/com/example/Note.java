package com.example;

import java.io.Serializable;

public class Note implements Serializable {

    String title;
    String content;
    String tag;
    String imagePath;

    public Note(String title, String content, String tag, String imagePath) {
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }
}
