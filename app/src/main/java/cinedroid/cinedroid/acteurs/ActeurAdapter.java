package cinedroid.cinedroid.acteurs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.objects.Acteur;

public class ActeurAdapter extends ArrayAdapter<Acteur> {

    public ActeurAdapter(Context context, List<Acteur> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elmt_list_acteur,parent, false);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolder();

            viewHolder.textView_prenom = convertView.findViewById(R.id.acteurFirstName);
            viewHolder.textView_nom = convertView.findViewById(R.id.acteurName);

            convertView.setTag(viewHolder);
        }

        Acteur acteur = getItem(position);

        viewHolder.textView_prenom.setText(acteur.getPrenAct());
        viewHolder.textView_nom.setText(acteur.getNomAct());

        return convertView;
    }

    private class ViewHolder{
        public TextView textView_prenom;
        public TextView textView_nom;
    }

}
