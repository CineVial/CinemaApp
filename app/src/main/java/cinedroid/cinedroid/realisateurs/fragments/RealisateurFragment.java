package cinedroid.cinedroid.realisateurs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.objects.Realisateur;

public class RealisateurFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.realisateur_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        realisateur((Realisateur) bundle.getSerializable("realisateur"));
    }

    public void realisateur(Realisateur realisateur){
        //details TODO
    }

}