package com.example.BA_Backend.Repository;

import com.example.BA_Backend.Model.NoteModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteRepository {
    @Getter @Setter
    private List<NoteModel> allNotes = new ArrayList<>();

    public NoteRepository(){
        for(int i = 0; i < 5; i++){
            NoteModel note = new NoteModel();
            note.setIndex(i);
            note.setDescription("sample Description " + i);
            note.setStatus("Done");
            note.setTitle("sample Title " + i);
            note.setDueDate("0" + i + ".03.2022");
            allNotes.add(note);
        }
    }

    public void saveNote(NoteModel note){
        allNotes.add(note);
    }

    public void updateNote(NoteModel note){
        int i = 0;
        while(i < allNotes.size()){
            if(allNotes.get(i).getIndex() == note.getIndex()){
                allNotes.set(i, note);
            }
            i++;
        }
    }

    public void deleteNote(NoteModel note){
        int i = 0;
        while(i < allNotes.size()){
            if(allNotes.get(i).getIndex() == note.getIndex()){
                allNotes.remove(i);
            }
            i++;
        }
    }

    public void createMassNotes(){
        int highestNoteIndex = allNotes.get(allNotes.size() - 1).getIndex() + 1;
        for(int i = 0; i < 1000; i++){
            NoteModel note = new NoteModel();
            note.setIndex(highestNoteIndex);
            note.setDescription("sample Description " + highestNoteIndex);
            note.setStatus("Done");
            note.setTitle("sample Title " + highestNoteIndex);
            note.setDueDate("01.03.2022");
            allNotes.add(note);
            highestNoteIndex += 1;
        }
    }

    public void updateMassNotes(){
        int highestIndex = allNotes.size() - 1;
        int highestNoteIndex = allNotes.get(allNotes.size() - 1).getIndex();
        for(int i = 0; i < 1000; i++){
            NoteModel note = new NoteModel();
            note.setDescription("Updated sample Description " + highestNoteIndex);
            note.setStatus("Done");
            note.setTitle("Updated sample Title " + highestNoteIndex);
            note.setDueDate("01.03.2022");
            allNotes.set(highestIndex, note);
            highestIndex -= 1;
            highestNoteIndex -= 1;
        }
    }

    public void deleteMassNotes(){
        int i = 0;
        int highestIndex = allNotes.size() - 1;
        while(i < 1000){
            allNotes.remove(highestIndex);
            highestIndex -= 1;
            i++;
        }
    }
}
