package com.nmp90.mycleanvideos;

import com.nmp90.mycleanvideos.api.MoviesApiService;
import com.nmp90.mycleanvideos.list.Movie;
import com.nmp90.mycleanvideos.list.MovieApiMapper;
import com.nmp90.mycleanvideos.list.MovieJson;
import com.nmp90.mycleanvideos.list.MoviesApiRepository;
import com.nmp90.mycleanvideos.list.MoviesRepository;
import com.nmp90.mycleanvideos.list.SearchJson;

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
public class MoviesApiRepositoryTest {

    private MoviesRepository moviesRepository;

    @Mock
    MoviesApiService moviesApiService;

    @Mock
    MovieApiMapper movieApiMapper;

    @Mock
    SearchJson searchJson;

    @Mock
    MovieJson movieJson;

    @Mock
    Movie movie;

    @Before
    public void setUp() {
        moviesRepository = new MoviesApiRepository(moviesApiService, movieApiMapper);
    }

    @Test
    public void returnsMoviesFromSearch() throws Exception {
        given(moviesApiService.getMovies(any(), any())).willReturn(Single.just(searchJson));
        given(searchJson.getMovies()).willReturn(Arrays.asList(movieJson));
        given(movieApiMapper.toMovie(any())).willReturn(movie);

        TestObserver<List<Movie>> testObserver = moviesRepository.getMovies("test").test();

        testObserver.awaitTerminalEvent();
        testObserver.assertResult(Arrays.asList(movie));
    }
}