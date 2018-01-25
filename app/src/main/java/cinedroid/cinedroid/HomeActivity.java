package cinedroid.cinedroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import cinedroid.cinedroid.films.FilmActivity;
import cinedroid.cinedroid.realisateurs.RealisateurActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button button_film = findViewById(R.id.film_app);
        button_film.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, FilmActivity.class)));

        final Button button_realisateur = findViewById(R.id.realisateur_app);
        button_realisateur.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, RealisateurActivity.class)));
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}

