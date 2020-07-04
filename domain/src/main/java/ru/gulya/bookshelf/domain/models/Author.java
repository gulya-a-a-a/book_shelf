package ru.gulya.bookshelf.domain.models;

public class Author {
    private final long id;

    private String firstName;
    private String surname;

    public Author(long id) {
        this.id = id;
    }

    public Author(String firstName, String surname) {
        this.id = 0;
        this.firstName = firstName;
        this.surname = surname;
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
}
