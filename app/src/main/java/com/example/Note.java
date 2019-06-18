package com.example;

import java.io.Serializable;

public class Note implements Serializable {

    String title;
    String description;
    String tag;

    public Note(String title, String description, String tag) {
        this.title = title;
        this.description = description;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return description;
    }

    public String getTag() {
        return tag;
    }
}
