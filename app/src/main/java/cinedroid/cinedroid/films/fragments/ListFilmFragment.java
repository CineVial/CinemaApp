package cinedroid.cinedroid.films.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.films.FilmAdapter;
import cinedroid.cinedroid.objects.Film;

public class ListFilmFragment extends Fragment {

    private ListView listView;
    private List<Film> filmList;
    private FilmAdapter filmAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_film_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        init();
        listFilm();
    }

    private void init() {
        this.filmList = new ArrayList<>();
        this.listView = getActivity().findViewById(R.id.filmList);

    }

    private void listFilm() {
        final String api_url = "http://api.cinema-epul.tk/films";
        final Film default_film = new Film();
        final Context context = getActivity().getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest (api_url, response -> {
            try {
                for(int i=0; i < response.length(); i++) {
                    JSONObject jsonObject = response.getJSONObject(i);
                    Film film = new Film(jsonObject);
                    filmList.add(film);
                }
            }
            catch(JSONException e) {
                e.printStackTrace();
                filmList.add(default_film);
            }

            filmAdapter = new FilmAdapter(context, filmList);
            listView.setAdapter(filmAdapter);

        }, null);
        queue.add(jsonArrayRequest);

        this.listView.setOnItemClickListener((parent, view, position, id) -> {
            FilmFragment filmFragment = new FilmFragment();

            Bundle bundle = new Bundle();
            Film film = filmList.get(position);
            bundle.putSerializable("film", film);
            filmFragment.setArguments(bundle);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.filmFragment, filmFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

}
