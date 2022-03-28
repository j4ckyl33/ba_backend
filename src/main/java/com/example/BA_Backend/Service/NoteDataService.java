package com.example.BA_Backend.Service;

import com.example.BA_Backend.Model.NoteModel;
import com.example.BA_Backend.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteDataService {

    @Autowired
    private NoteRepository noteRepository;

    public List<NoteModel> getAllNotes(){return noteRepository.getAllNotes();}

    public void createNote(NoteModel note){
        noteRepository.saveNote(note);
    }

    public void updateNote(NoteModel note){
        noteRepository.updateNote(note);
    }

    public void deleteNote(NoteModel note){
        noteRepository.deleteNote(note);
    }

    public void createMassNotes(){noteRepository.createMassNotes();}
    public void deleteMassNotes(){noteRepository.deleteMassNotes();}
    public void updateMassNotes(){noteRepository.updateMassNotes();}
}
