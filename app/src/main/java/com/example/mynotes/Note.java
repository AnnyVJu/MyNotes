package com.example.mynotes;

public class Note {
    private String title;
    private String description;
    private String dayOfWeek;
    private int priority;
    private int id;

    public Note(int id, String title, String description, String dayOfWeek, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getPriority() {
        return priority;
    }
}
