package cinedroid.cinedroid.acteurs.fragments;

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
import cinedroid.cinedroid.acteurs.ActeurAdapter;
import cinedroid.cinedroid.objects.Acteur;

public class ListActeurFragment extends Fragment {

    private ListView listView;
    private List<Acteur> acteurList;
    private ActeurAdapter acteurAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_acteur_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        listActeur();
    }

    @Override
    public void onResume() {
        super.onResume();

        init();
        listActeur();
    }

    private void init() {
        this.acteurList = new ArrayList<>();
        this.listView = getActivity().findViewById(R.id.acteurList);

    }

    private void listActeur() {
        final String api_url = "http://api.cinema-epul.tk/acteurs";
        final Acteur default_acteur = new Acteur();
        final Context context = getActivity().getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest (api_url, response -> {
            try {
                for(int i=0; i < response.length(); i++) {
                    JSONObject jsonObject = response.getJSONObject(i);
                    Acteur acteur = new Acteur(jsonObject);
                    acteurList.add(acteur);
                }
            }
            catch(JSONException e) {
                e.printStackTrace();
                acteurList.add(default_acteur);
            }

            acteurAdapter = new ActeurAdapter(context, acteurList);
            listView.setAdapter(acteurAdapter);

        }, null);
        queue.add(jsonArrayRequest);

        this.listView.setOnItemClickListener((parent, view, position, id) -> {
            ActeurFragment acteurFragment = new ActeurFragment();

            Bundle bundle = new Bundle();
            Acteur acteur = acteurList.get(position);
            bundle.putSerializable("acteur", acteur);
            acteurFragment.setArguments(bundle);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.acteurFragment, acteurFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

}
