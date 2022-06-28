package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.notepad.controller.NoteController;
import com.example.notepad.view.AddNoteActivity;
import com.example.notepad.view.ShowNoteActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    NoteController noteController;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.noteController = new NoteController(getApplicationContext());

        this.fab = findViewById(R.id.fab);
        this.listView = findViewById(R.id.listview);

        this.fab.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AddNoteActivity.class);
            startActivity(i);
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                this.noteController.getNotesTitles());

        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener((adapterView, view, i, l) -> {

            Intent intent = new Intent(getApplicationContext(), ShowNoteActivity.class);
            intent.putExtra("id",i);
            startActivity(intent);
        });
    }
}