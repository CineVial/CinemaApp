package cinedroid.cinedroid.films;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.films.fragments.ListFilmFragment;

public class FilmActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        if(savedInstanceState != null){
            return;
        }

        ListFilmFragment listFragment = new ListFilmFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.filmFragment, listFragment).commit();

    }
}
