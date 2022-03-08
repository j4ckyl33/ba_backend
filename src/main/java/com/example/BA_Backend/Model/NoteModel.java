package com.example.BA_Backend.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class NoteModel {
    @Getter @Setter
    private int index;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String status;

    @Getter @Setter
    private String dueDate;
}
