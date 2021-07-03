package ru.gulya.bookshelf.domain.models;

import java.io.Serializable;

public class Shelf implements Serializable {
    private long mId;
    private String mTitle;
    private Bookcase mBookcase;

    public Shelf(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Bookcase getBookcase() {
        return mBookcase;
    }

    public void setBookcase(Bookcase bookcase) {
        mBookcase = bookcase;
    }
}
