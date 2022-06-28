package com.example.notepad.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NoteDAO {

    SQLiteDatabase database;

    public NoteDAO(Context context) {

        database = context.openOrCreateDatabase("dbNotes", context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS note(" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "title varchar NOT NULL," +
                "text varchar)");
    }

    public ArrayList<Note> getNotes(){
        ArrayList<Note> noteArrayList = new ArrayList<>();

        Cursor cursor;
        cursor = database.rawQuery("SELECT * FROM note", null,null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            int idIndex = cursor.getColumnIndex("id");
            int titleIndex = cursor.getColumnIndex("title");
            int textIndex = cursor.getColumnIndex("text");

            int id = cursor.getInt(idIndex);
            String title = cursor.getString(titleIndex);
            String text = cursor.getString(textIndex);

            noteArrayList.add(new Note(title,text));

            cursor.moveToNext();
        }

        return noteArrayList;
    }

    public void addNote(Note note){
        database.execSQL("INSERT INTO note (title,text) VALUES ('"+note.getTitle()+"','"+note.getText()+"');");
    }
}
