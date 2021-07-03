package ru.gulya.bookshelf.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import ru.gulya.bookshelf.domain.executors.PostExecutionThread;
import ru.gulya.bookshelf.domain.interactor.authors.GetAuthorsList;
import ru.gulya.bookshelf.domain.models.Author;

@RunWith(MockitoJUnitRunner.class)
public class GetAuthorsUseCaseTest {

    private GetAuthorsList mGetAuthorsList;

    @Mock
    private PostExecutionThread mockPostExecutionThread;
    @Mock
    private BookShelfRepository<Author> mockAuthorBookShelfRepository;

    @Before
    public void init() {
        mGetAuthorsList = new GetAuthorsList(mockAuthorBookShelfRepository,
                mockPostExecutionThread);
    }

    @Test
    public void testGetAuthorsUseCase() {
        mGetAuthorsList.buildUseCaseObservable(null);

        verify(mockAuthorBookShelfRepository).getAll();
        verifyNoMoreInteractions(mockAuthorBookShelfRepository);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}
