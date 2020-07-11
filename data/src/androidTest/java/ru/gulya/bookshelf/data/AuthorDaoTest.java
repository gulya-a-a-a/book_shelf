package ru.gulya.bookshelf.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.disposables.Disposable;
import ru.gulya.bookshelf.data.database.BookShelfDatabase;
import ru.gulya.bookshelf.data.repository.AuthorsRepository;
import ru.gulya.bookshelf.domain.models.Author;

@RunWith(AndroidJUnit4.class)
public class AuthorDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private BookShelfDatabase mDatabase;

    private AuthorsRepository mAuthorsRepository;

    final Author AUTHOR = new Author(1, "Leo", "Tolstoy");

    @Before
    public void initDb() {
        mDatabase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                BookShelfDatabase.class)
                .allowMainThreadQueries()
                .build();

        mAuthorsRepository = new AuthorsRepository(mDatabase.getAuthorDao());
    }

    @After
    public void closeDb() {
        mDatabase.close();
    }


    @Test
    public void insertAndGetAuthor() {
        Long result = mDatabase.getAuthorDao().insert(AUTHOR).blockingGet();

        Disposable d = mDatabase.getAuthorDao().getAuthorById(AUTHOR.getId())
                .test()
                .assertValue(author -> author != null && (author.getId() == AUTHOR.getId()) &&
                        author.getFirstName().equals(AUTHOR.getFirstName()) &&
                        author.getSurname().equals(AUTHOR.getSurname()));
    }

    @Test
    public void insertToRepo() {
        Long res = mAuthorsRepository.insert(AUTHOR).blockingGet();

        Disposable d = mAuthorsRepository.getShortInfoById(AUTHOR.getId())
                .test()
                .assertValue(author -> author != null && (author.getId() == AUTHOR.getId()) &&
                        author.getFirstName().equals(AUTHOR.getFirstName()) &&
                        author.getSurname().equals(AUTHOR.getSurname()));
    }

    @Test
    public void deleteAndGetAuthor() {
        Long result = mDatabase.getAuthorDao().insert(AUTHOR).blockingGet();

        mDatabase.getAuthorDao().deleteAllAuthors();

        mDatabase.getAuthorDao().getAll()
                .test()
                .assertNoValues();
    }
}
