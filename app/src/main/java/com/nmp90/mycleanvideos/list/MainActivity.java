package com.nmp90.mycleanvideos.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.nmp90.mycleanvideos.R;
import com.nmp90.mycleanvideos.utils.InjectHelper;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MoviesPresenter.View {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MoviesPresenter moviesPresenter;

    private RecyclerView moviesRecyclerView;
    private MoviesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectHelper.getActivityComponent(this).inject(this);
        findViewById(R.id.btn_search).setOnClickListener(this::searchForText);
        moviesRecyclerView = findViewById(R.id.rv_results);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MoviesAdapter();
        moviesRecyclerView.setAdapter(adapter);
    }

    private void searchForText(View view) {
        String search = ((EditText) findViewById(R.id.et_search)).getText().toString();
        moviesPresenter.searchForMovies(search);
    }

    @Override
    protected void onResume() {
        super.onResume();
        moviesPresenter.startPresenting(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        moviesPresenter.stopPresenting();
    }

    @Override
    public void showMovies(List<UiMovie> movies) {
        adapter.setMovies(movies);
    }
}
