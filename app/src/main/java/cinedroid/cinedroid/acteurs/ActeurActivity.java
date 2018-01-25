package cinedroid.cinedroid.acteurs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.acteurs.fragments.ListActeurFragment;

public class ActeurActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acteur);

        if(savedInstanceState != null){
            return;
        }

        ListActeurFragment listFragment = new ListActeurFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.acteurFragment, listFragment).commit();

    }
}
