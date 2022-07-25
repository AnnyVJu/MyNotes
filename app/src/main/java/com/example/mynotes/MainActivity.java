package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    public static final ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes=findViewById(R.id.recyclerViewNotes);
        notes.add(new Note("Ортодонт", "Запись к стоматологу", "Вторник", 1));
        notes.add(new Note("Врач", "Запись в поликлинику", "Вторник", 1));
        notes.add(new Note("Магазин", "Купить салфетки", "Суббота", 2));
        notes.add(new Note("Магазин", "Купить крепеж", "Суббота", 2));
        notes.add(new Note("Дом", "Прибраться в шкафу", "Воскресенье", 3));
        notes.add(new Note("Дом", "Помыть окна", "Вторник", 3));
        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }
}