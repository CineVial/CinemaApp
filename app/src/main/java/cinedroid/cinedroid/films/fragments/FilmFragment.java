package cinedroid.cinedroid.films.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.objects.Categorie;
import cinedroid.cinedroid.objects.Film;
import cinedroid.cinedroid.objects.Realisateur;

public class FilmFragment extends Fragment {
    private Realisateur realisateur;
    private Categorie categorie;
    private Film film;

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

    @SuppressLint("SetTextI18n")
    public void film(Film film){
        this.film = film;

        this.getRealisateur(film);
    }

    @SuppressLint("SetTextI18n")
    public void film() {
        ((TextView) getActivity().findViewById(R.id.filmNameDetails)).setText(film.getTitre());
        ((TextView) getActivity().findViewById(R.id.filmDureeDetails)).setText(film.getDuree().toString());
        ((TextView) getActivity().findViewById(R.id.filmDateDetails)).setText(film.getDateSortie());
        ((TextView) getActivity().findViewById(R.id.filmBudgetDetails)).setText(film.getBudget().toString());
        ((TextView) getActivity().findViewById(R.id.filmRecetteDetails)).setText(film.getMontantRecette().toString());
        ((TextView) getActivity().findViewById(R.id.filmRealisateurDetails)).setText(realisateur.getPrenRea() +" "+ realisateur.getNomRea());
        ((TextView) getActivity().findViewById(R.id.filmCategorieDetails)).setText(categorie.getLibelleCat());
    }

    private void getRealisateur(Film film) {
        try {
            String api_url = "http://api.cinema-epul.tk/realisateur?r_id=" + film.getNoRea();
            Context context = getActivity().getApplicationContext();
            RequestQueue queue = Volley.newRequestQueue(context);

            JsonObjectRequest request = new JsonObjectRequest(api_url, new JSONObject(), response -> {
                try {
                    this.realisateur = new ObjectMapper().readValue(response.toString(), Realisateur.class);
                    this.getCategorie(film);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }, null);
            queue.add(request);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getCategorie(Film film) {
        try {
            String api_url = "http://api.cinema-epul.tk/categorie?c_id=" + film.getCodeCat();
            Context context = getActivity().getApplicationContext();
            RequestQueue queue = Volley.newRequestQueue(context);

            JsonObjectRequest request = new JsonObjectRequest(api_url, new JSONObject(), response -> {
                try {
                    this.categorie = new ObjectMapper().readValue(response.toString(), Categorie.class);
                    this.film();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }, null);
            queue.add(request);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}