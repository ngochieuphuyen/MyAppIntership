package com.example.ngochieu.myappinternship;

/**
 * Created by NgocHieu on 1/2/2017.
 */

public class Week {
    private String Name;
    private String content;

    public Week(String name, String content) {
        Name = name;
        this.content = content;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
