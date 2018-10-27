package com.example.a21_pc21.juego;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ArrayAdapter adapter;
    Boolean Listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        adapter = new AdaptadorJugador(Lista.this,MainActivity.listaJugadores);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();
        Listado=getIntent().getBooleanExtra("Listado", false);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if(!Listado){
            Intent lista = new Intent(getApplicationContext(), Juego.class);
            lista.putExtra("Position", position);
            startActivity(lista);
            finish();
        }
    }
}

