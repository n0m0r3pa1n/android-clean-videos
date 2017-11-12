package com.nmp90.mycleanvideos;

import com.nmp90.mycleanvideos.list.GetMoviesInteractor;
import com.nmp90.mycleanvideos.list.Movie;
import com.nmp90.mycleanvideos.list.MoviesRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class GetMoviesInteractorTest {
    private GetMoviesInteractor getMoviesInteractor;

    @Mock
    MoviesRepository moviesRepository;

    @Mock
    Movie movie;

    @Before
    public void setUp() {
        getMoviesInteractor = new GetMoviesInteractor(moviesRepository, new TestSchedulers());
    }

    @Test
    public void returnsMovieFromSearch() throws Exception {
        List<Movie> result = Arrays.asList(movie);
        given(moviesRepository.getMovies(any())).willReturn(Single.just(result));

        TestObserver<List<Movie>> testObserver = getMoviesInteractor.getMovies("Test").test();

        testObserver.awaitTerminalEvent();
        testObserver.assertResult(result);
    }
}