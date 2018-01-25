package cinedroid.cinedroid.films.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.objects.Film;

public class FilmFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.film_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        film((Film) bundle.getSerializable("film"));
    }

    public void film(Film film){
        ((TextView) getActivity().findViewById(R.id.filmNameDetails)).setText(film.getTitre());
        ((TextView) getActivity().findViewById(R.id.filmDureeDetails)).setText(film.getDuree().toString());
        ((TextView) getActivity().findViewById(R.id.filmDateDetails)).setText(film.getDateSortie());
        ((TextView) getActivity().findViewById(R.id.filmBudgetDetails)).setText(film.getBudget().toString());
        ((TextView) getActivity().findViewById(R.id.filmRecetteDetails)).setText(film.getMontantRecette().toString());
        ((TextView) getActivity().findViewById(R.id.filmRealisateurDetails)).setText(film.getNoRea().toString());
        ((TextView) getActivity().findViewById(R.id.filmCategorieDetails)).setText(film.getCodeCat());
    }

}