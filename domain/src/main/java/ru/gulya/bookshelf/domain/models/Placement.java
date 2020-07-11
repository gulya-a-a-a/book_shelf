package ru.gulya.bookshelf.domain.models;

import java.io.Serializable;

public class Placement implements Serializable {
    private long mId;
    private String mTitle;

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
}
