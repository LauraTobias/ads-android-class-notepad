package com.example.notepad.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notepad.MainActivity;
import com.example.notepad.R;
import com.example.notepad.controller.NoteController;
import com.example.notepad.model.Note;

public class AddNoteActivity extends AppCompatActivity {

    EditText text;
    EditText title;

    private NoteController noteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        this.title = findViewById(R.id.title);
        this.text = findViewById(R.id.text);

        this.noteController = new NoteController(AddNoteActivity.this);
    }

    public void addNote(View view) {

        if(!this.title.equals("") || !this.text.equals(""))
        {
            Note note = new Note(this.title.getText().toString(), text.getText().toString());
            this.noteController.saveNote(note);

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        else
            Toast.makeText(getApplicationContext(), "Não foi possível salvar a nota!", Toast.LENGTH_SHORT).show();
    }
}