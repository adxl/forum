package com.adxl.forum.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer extends Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Answer(String text) {
        super(text);
    }

    public Answer() {

    }
}
