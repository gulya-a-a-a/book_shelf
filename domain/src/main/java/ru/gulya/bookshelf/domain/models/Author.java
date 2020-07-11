package ru.gulya.bookshelf.domain.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Author implements Serializable {

    private long id;

    private String firstName;
    private String surname;

    public Author(long id) {
        this.id = id;
    }

    public Author(String firstName, String surname) {
        this(0, firstName, surname);
    }

    public Author(long id, String firstName, String surname) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }
}
