package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes = new ArrayList<>();

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
    }
}