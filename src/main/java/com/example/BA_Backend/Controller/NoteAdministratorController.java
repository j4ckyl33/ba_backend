package com.example.BA_Backend.Controller;

import com.example.BA_Backend.Model.NoteModel;
import com.example.BA_Backend.Service.NoteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteAdministratorController {
    @Autowired
    private NoteDataService service;

    @GetMapping(path="/note/listnotes")
    public List<NoteModel> apiCallGet(){
        return service.getAllNotes();
    }

    @PostMapping(path="/note/{apiCall}")
    public void apiCallPost(@PathVariable String apiCall, @RequestBody NoteModel note){
        switch (apiCall){
            case "createnote":
                service.createNote(note);
                break;
            case "updatenote":
                service.updateNote(note);
                break;
            case "updatemassnotes":
                service.updateMassNotes();
                break;
            case "createmassnotes":
                service.createMassNotes();
                break;
            case "deletemassnotes":
                service.deleteMassNotes();
                break;
            default:
                break;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path="/note/deletenote")
    public void apiCallDelete(@RequestBody NoteModel note){
        service.deleteNote(note);
    }
}
