package com.example.a21_pc21.juego;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorJugador extends ArrayAdapter<Jugador> {
    public AdaptadorJugador(@NonNull Context context, List<Jugador> object) {
        super(context, 0, object);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Jugador jugador = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_jugador, parent, false);
        }
        TextView editContador = convertView.findViewById(R.id.editContador);
        TextView editNombre = convertView.findViewById(R.id.editNombre);
        TextView editVictorias = convertView.findViewById(R.id.editVictorias);
        TextView editEmpates = convertView.findViewById(R.id.editEmpates);
        TextView editDerrotas = convertView.findViewById(R.id.editDerrotas);
        editContador.setText(String.valueOf(position+1));
        editNombre.setText(jugador.getNick());
        editVictorias.setText("Victorias: "+String.valueOf(jugador.getVictorias()));
        editEmpates.setText("Empates: "+String.valueOf(jugador.getEmpates()));
        editDerrotas.setText("Derrotas: "+String.valueOf(jugador.getDerrotas()));


        return convertView;
    }

}
