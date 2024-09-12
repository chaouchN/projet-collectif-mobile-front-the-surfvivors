package com.example.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;
import java.util.List;


public class SpotAdapter extends ArrayAdapter<spot> {
    public SpotAdapter(Context context, List<spot> spots) {
        super(context, 0, spots);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenez l'objet spot pour cette position
        spot currentSpot = getItem(position);

        // Vérifiez si une vue existante est réutilisée, sinon gonflez la vue
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_spot, parent, false);
        }

        // Références des vues
        TextView beachName = convertView.findViewById(R.id.beach_name);
        TextView countryName = convertView.findViewById(R.id.country_name);

        // Remplir les vues avec les données
        beachName.setText(currentSpot.getBeach());
        countryName.setText(currentSpot.getCountry());

        // Retournez la vue complète pour afficher à l'écran
        return convertView;
    }
}

