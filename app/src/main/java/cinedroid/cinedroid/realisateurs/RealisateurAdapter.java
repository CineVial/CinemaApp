package cinedroid.cinedroid.realisateurs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.objects.Realisateur;

public class RealisateurAdapter extends ArrayAdapter<Realisateur> {

    public RealisateurAdapter(Context context, List<Realisateur> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elmt_list_realisateur,parent, false);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolder();

            viewHolder.textView_prenom = convertView.findViewById(R.id.realisateurName);
            viewHolder.textView_nom = convertView.findViewById(R.id.realisateurFirstName);

            convertView.setTag(viewHolder);
        }

        Realisateur realisateur = getItem(position);

        viewHolder.textView_prenom.setText(realisateur.getPrenRea());
        viewHolder.textView_nom.setText(realisateur.getNomRea());

        return convertView;
    }

    private class ViewHolder{
        public TextView textView_prenom;
        public TextView textView_nom;
    }

}
