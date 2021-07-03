package ru.gulya.bookshelf.presentation.presenters;

import android.text.TextWatcher;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import ru.gulya.bookshelf.domain.interactor.base.AddUseCase;
import ru.gulya.bookshelf.domain.interactor.base.GetOneUseCase;
import ru.gulya.bookshelf.domain.interactor.base.UpdateUseCase;
import ru.gulya.bookshelf.presentation.views.DetailView;

public abstract class BaseItemPresenter<T> extends BasePresenter<DetailView<T>, T> {

    protected final GetOneUseCase<T> mGetOneUseCase;
    protected final AddUseCase<T> mAddUseCase;
    protected final UpdateUseCase<T> mUpdateUseCase;

    protected DetailView<T> mDetailView;

    public BaseItemPresenter(GetOneUseCase<T> getOneUseCase,
                             AddUseCase<T> addUseCase,
                             UpdateUseCase<T> updateUseCase) {
        mGetOneUseCase = getOneUseCase;
        mAddUseCase = addUseCase;
        mUpdateUseCase = updateUseCase;
    }

    public abstract void getItem(long item);

    public abstract void insertItem();

    public abstract void updateItem();

    public abstract void saveItem();

    public void destroy() {
        mGetOneUseCase.dispose();
    }

    public Observable<Object> fromEditText(EditText editText) {
        return Observable
                .create(emitter -> editText.addTextChangedListener(
                        (SimpleTextWatcher) editable -> emitter.onNext(editable.toString())))
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .filter(s -> !((String) s).isEmpty());
    }

    private interface SimpleTextWatcher extends TextWatcher {
        @Override
        default void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        default void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }
}
