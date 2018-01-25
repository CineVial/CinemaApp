package cinedroid.cinedroid.realisateurs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.realisateurs.fragments.ListRealisateurFragment;

public class RealisateurActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realisateur);

        if(savedInstanceState != null){
            return;
        }

        ListRealisateurFragment listFragment = new ListRealisateurFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.realisateurFragment, listFragment).commit();

    }
}
