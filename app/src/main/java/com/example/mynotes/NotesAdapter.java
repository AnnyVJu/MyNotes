package com.example.mynotes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<Note> notes;
    private OnNoteClickListener onNoteClickListener;

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    interface OnNoteClickListener {
        void onNoteClick(int position);
        void onLongClick(int position);
    }

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder notesViewHolder, int i) {
Note note = notes.get(i);
notesViewHolder.textViewTitle.setText(note.getTitle());
notesViewHolder.textViewDescription.setText(note.getDescription());
notesViewHolder.textViewDayOfWeek.setText(note.getDayOfWeek() + 1);
int colorId;
int priority = note.getPriority();
switch (priority) {
    case 1:
        colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_red_light);
        break;
    case 2:
        colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_orange_light);
        break;
    default:
        colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_green_light);
        break;
       }
       notesViewHolder.textViewTitle.setBackgroundColor(colorId);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewDayOfWeek;

        public NotesViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewDayOfWeek = itemView.findViewById(R.id.textViewDayOfWeek);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNoteClickListener !=null) {
                        onNoteClickListener.onNoteClick(getAdapterPosition());
                    }
                }
            });
itemView.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        if (onNoteClickListener !=null) {
            onNoteClickListener.onLongClick(getAdapterPosition());
        }
        return true;
    }
});
        }
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public List<Note> getNotes() {
        return notes;
    }
}
