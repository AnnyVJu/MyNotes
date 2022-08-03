package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDaysOfWeek;
    private RadioGroup radioGroupPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDaysOfWeek = findViewById(R.id.spinnerDaysOfWeek);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);
    }

    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String dayOfWeek = spinnerDaysOfWeek.getSelectedItem().toString();
        int radioButtonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radiobutton = findViewById(radioButtonId);
        int priority = Integer.parseInt(radiobutton.getText().toString());
        Note note = new Note(title, description, dayOfWeek, priority);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}