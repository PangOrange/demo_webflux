package com.example.demo.vo;

public class UserVo {
    private long id;

    private int sexCode;

    private String sexName;

    private String name;

    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSexCode() {
        return sexCode;
    }

    public void setSexCode(int sexCode) {
        this.sexCode = sexCode;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
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
