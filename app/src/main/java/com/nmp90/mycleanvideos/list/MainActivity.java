package com.nmp90.mycleanvideos.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.nmp90.mycleanvideos.R;
import com.nmp90.mycleanvideos.utils.InjectHelper;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MoviesPresenter.View {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MoviesPresenter moviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectHelper.getActivityComponent(this).inject(this);
        findViewById(R.id.btn_search).setOnClickListener(this::searchForText);
    }

    private void searchForText(View view) {
        String search = ((EditText) findViewById(R.id.et_search)).getText().toString();
        moviesPresenter.searchForMovies(search);
    }

    @Override
    public void showMovies() {

    }
}
