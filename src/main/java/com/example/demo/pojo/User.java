package com.example.demo.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document
public class User implements Serializable {
    @Id
    private long id;

    private SexEnum sexEnum;

    @Field(value = "name")
    private String name;

    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SexEnum getSexEnum() {
        return sexEnum;
    }

    public void setSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
