package cinedroid.cinedroid.films;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cinedroid.cinedroid.R;
import cinedroid.cinedroid.objects.Film;

public class FilmAdapter extends ArrayAdapter<Film> {

    public FilmAdapter(Context context, List<Film> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elmt_list,parent, false);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ViewHolder();

            viewHolder.textView_titre = convertView.findViewById(R.id.filmName);
            viewHolder.textView_dateSortie = convertView.findViewById(R.id.filmDate);

            convertView.setTag(viewHolder);
        }

        Film film = getItem(position);

        viewHolder.textView_titre.setText(film.getTitre());
        viewHolder.textView_dateSortie.setText(film.getDateSortie());

        return convertView;
    }

    private class ViewHolder{
        public TextView textView_titre;
        public TextView textView_dateSortie;
    }

}
