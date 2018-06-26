package com.example.scitmaster.memoria;

/**
 * Created by SCITMASTER on 2018-03-08.
 */

public class Memo {
    private String id;
    private String title;
    private String context;


    public Memo(String id ,String title, String context) {
        this.id = id;
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
