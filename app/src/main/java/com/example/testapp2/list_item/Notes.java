package com.example.testapp2.list_item;

public class Notes {

    private String note;
    private String date;

    public Notes(String date, String note){
        this.date = date;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
