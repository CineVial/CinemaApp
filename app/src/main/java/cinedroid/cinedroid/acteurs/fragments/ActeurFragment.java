package cinedroid.cinedroid.acteurs.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.objects.Acteur;

public class ActeurFragment extends Fragment {
    private Acteur acteur;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.acteur_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        acteur((Acteur) bundle.getSerializable("acteur"));
    }

    @SuppressLint("SetTextI18n")
    public void acteur(Acteur acteur){
        this.acteur = acteur;
        this.acteur();
    }

    @SuppressLint("SetTextI18n")
    public void acteur() {

        String date = acteur.getDateDeces();
        if (date == "null")
            date = "";

        ((TextView) getActivity().findViewById(R.id.acteurFirstNameDetails)).setText(acteur.getPrenAct());
        ((TextView) getActivity().findViewById(R.id.acteurNameDetails)).setText(acteur.getNomAct());
        ((TextView) getActivity().findViewById(R.id.acteurDateNaissDetails)).setText(acteur.getDateNaiss());
        ((TextView) getActivity().findViewById(R.id.acteurDateDecesDetails)).setText(date);
    }



}