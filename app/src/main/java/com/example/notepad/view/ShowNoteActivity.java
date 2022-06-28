package com.example.notepad.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notepad.R;
import com.example.notepad.controller.NoteController;
import com.example.notepad.model.Note;

public class ShowNoteActivity extends AppCompatActivity {
    TextView txtTitle;
    TextView txtText;
    NoteController noteController;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        int noteId = getIntent().getExtras().getInt("id");

        this.txtTitle = findViewById(R.id.txtTitle);
        this.txtText = findViewById(R.id.txtText);

        this.noteController = new NoteController(getBaseContext());
        this.note = noteController.getNotes().get(noteId);

        this.txtTitle.setText(this.note.getTitle());
        this.txtText.setText(this.note.getText());
    }
}
