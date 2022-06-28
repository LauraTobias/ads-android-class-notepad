package com.example.notepad.model;

public class Note {

    Integer id;
    String title;
    String text;

    public Note(String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Note(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getText() { return this.text; }
}
