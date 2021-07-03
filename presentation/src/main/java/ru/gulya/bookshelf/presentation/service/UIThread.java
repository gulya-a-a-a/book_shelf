package ru.gulya.bookshelf.presentation.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.gulya.bookshelf.domain.executors.PostExecutionThread;

@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
