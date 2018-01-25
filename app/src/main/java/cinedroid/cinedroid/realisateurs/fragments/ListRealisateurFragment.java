package cinedroid.cinedroid.realisateurs.fragments;

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
import cinedroid.cinedroid.objects.Realisateur;
import cinedroid.cinedroid.realisateurs.RealisateurAdapter;

public class ListRealisateurFragment extends Fragment {

    private ListView listView;
    private List<Realisateur> realisateurList;
    private RealisateurAdapter realisateurAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_realisateur_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        listRealisateur();
    }

    @Override
    public void onResume() {
        super.onResume();

        init();
        listRealisateur();
    }

    private void init() {
        this.realisateurList = new ArrayList<>();
        this.listView = getActivity().findViewById(R.id.realisateurList);

    }

    private void listRealisateur() {
        final String api_url = "http://api.cinema-epul.tk/realisateurs";
        final Realisateur default_realisateur = new Realisateur();
        final Context context = getActivity().getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest (api_url, response -> {
            try {
                for(int i=0; i < response.length(); i++) {
                    JSONObject jsonObject = response.getJSONObject(i);
                    Realisateur realisateur = new Realisateur(jsonObject);
                    realisateurList.add(realisateur);
                }
            }
            catch(JSONException e) {
                e.printStackTrace();
                realisateurList.add(default_realisateur);
            }

            realisateurAdapter = new RealisateurAdapter(context, realisateurList);
            listView.setAdapter(realisateurAdapter);

        }, null);
        queue.add(jsonArrayRequest);

        this.listView.setOnItemClickListener((parent, view, position, id) -> {
            RealisateurFragment realisateurFragment = new RealisateurFragment();

            Bundle bundle = new Bundle();
            Realisateur realisateur = realisateurList.get(position);
            bundle.putSerializable("realisateur", realisateur);
            realisateurFragment.setArguments(bundle);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.realisateurFragment, realisateurFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

}
