package ru.gulya.bookshelf.domain.models;

import java.io.Serializable;

public class Bookcase implements Serializable {
    private long mId;
    private String mTitle;
    private Placement mPlacement;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Placement getPlacement() {
        return mPlacement;
    }

    public void setPlacement(Placement placement) {
        mPlacement = placement;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }
}
