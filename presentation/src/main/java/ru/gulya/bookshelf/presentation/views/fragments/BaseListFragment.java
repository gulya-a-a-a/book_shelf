package ru.gulya.bookshelf.presentation.views.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import ru.gulya.bookshelf.presentation.R;
import ru.gulya.bookshelf.presentation.presenters.BaseListPresenter;
import ru.gulya.bookshelf.presentation.views.ListFragmentOnClickListener;
import ru.gulya.bookshelf.presentation.views.ListView;
import ru.gulya.bookshelf.presentation.views.adapters.BaseListAdapter;

public abstract class BaseListFragment<T, ListPresenter extends BaseListPresenter<T>,
        ListAdapter extends BaseListAdapter<T, ? extends RecyclerView.ViewHolder>>
        extends Fragment implements ListView<T> {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private Button mRetryButton;

    @Inject
    ListPresenter mListPresenter;

    @Inject
    ListAdapter mListAdapter;

    protected ListFragmentOnClickListener<T> mFragmentOnClickListener;

    private BaseListAdapter.OnItemClickListener<T> mOnItemClickListener = item -> {
        if (mFragmentOnClickListener != null) {
            mFragmentOnClickListener.onItemSelectClicked(item);
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListPresenter.setView(this);
        Activity activity = getActivity();
        if (activity instanceof ListFragmentOnClickListener) {
            mFragmentOnClickListener = (ListFragmentOnClickListener<T>) activity;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mListPresenter.getItemsList();
    }

    protected void initControls(View fragmentView, int recyclerViewId) {
        mProgressBar = fragmentView.findViewById(R.id.loading_progress);
        mRetryButton = fragmentView.findViewById(R.id.btn_retry);

        mRetryButton.setOnClickListener(v -> mListPresenter.getItemsList());

        mListAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView = fragmentView.findViewById(recyclerViewId);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mListAdapter);
    }

    @Override
    public void showItemList(List<T> itemCollection) {
        mListAdapter.setItemList(itemCollection);
    }

    @Override
    public void showSpecificItem(T item) {

    }

    @Override
    public void showLoading() {
        mRecyclerView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {

    }
}
