package com.example.notepad.controller;

import android.content.Context;

import com.example.notepad.model.NoteDAO;
import com.example.notepad.model.Note;

import java.util.ArrayList;

public class NoteController {

    Context mContext;
    NoteDAO noteDao;

    public NoteController(Context context) {
        this.mContext = context;
        this.noteDao = new NoteDAO(mContext);
    }

    public ArrayList<Note> getNotes() {
        return this.noteDao.getNotes();
    }

    public ArrayList<String> getNotesTitles() {

        ArrayList<String> arrayAdapterResult = new ArrayList<String>();
        for (Note n : this.noteDao.getNotes())
            arrayAdapterResult.add(n.getTitle());

        return arrayAdapterResult;
    }

    public void saveNote(Note note){
        this.noteDao.addNote(note);
    }
}
