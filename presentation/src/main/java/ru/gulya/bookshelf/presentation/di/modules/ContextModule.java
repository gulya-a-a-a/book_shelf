package ru.gulya.bookshelf.presentation.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context mContext;

    public ContextModule(Context context) {
        this.mContext = context;
    }

    @Provides
    public Context getContext() {
        return mContext;
    }
}
