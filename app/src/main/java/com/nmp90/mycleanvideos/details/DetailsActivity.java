package com.nmp90.mycleanvideos.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nmp90.mycleanvideos.R;
import com.nmp90.mycleanvideos.utils.InjectHelper;

import java.util.List;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsPresenter.View {

    public static final String KEY_MOVIE_ID = "movieId";

    public static void open(String movieId, Activity activity) {
        Intent intent = new Intent(activity, DetailsActivity.class);
        intent.putExtra(KEY_MOVIE_ID, movieId);
        activity.startActivity(intent);
    }

    @Inject
    DetailsPresenter detailsPresenter;

    private ListView actorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        InjectHelper.getActivityComponent(this).inject(this);

        actorsList = findViewById(R.id.actors_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String movieId = getIntent().getStringExtra(KEY_MOVIE_ID);
        detailsPresenter.startPresenting(this, movieId);
    }

    @Override
    protected void onPause() {
        super.onPause();
        detailsPresenter.stopPresenting();
    }

    @Override
    public void showActors(List<String> actors) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, actors);
        actorsList.setAdapter(adapter);
    }
}
