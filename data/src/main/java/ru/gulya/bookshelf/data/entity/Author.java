package ru.gulya.bookshelf.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "authors")
public class Author {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String firstName;
    private String surname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @NonNull
    @Override
    public String toString() {
        return String.format("%s %s", firstName, surname);
    }
}
