package com.example.a21_pc21.juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     Button btnNuevo, btnIniciar, btnPuntajes;
    public static ArrayList<Jugador> listaJugadores;
    public static final int JUGADORNUEVO =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnPuntajes = findViewById(R.id.btnPuntajes);
        listaJugadores = new ArrayList<>();
        btnIniciar.setOnClickListener(this);
        btnNuevo.setOnClickListener(this);
        btnPuntajes.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIniciar:
                Intent li = new Intent(getApplicationContext(),List.class);
                startActivity(li);
                break;
            case R.id.btnNuevo:
                Intent nuevo = new Intent(getApplicationContext(), NuevoJugador.class);
                startActivityForResult(nuevo,JUGADORNUEVO);
                 break;
            case R.id.btnPuntajes:
                Intent lista = new Intent(getApplicationContext(), Lista.class);
                lista.putExtra("Listado",true);
                startActivity(lista);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case JUGADORNUEVO:
                if(data==null)
                    return;
                String nombre = data.getExtras().getString("Nombre");
                Jugador jug = new Jugador(listaJugadores.size()+1, nombre, 0 , 0,0);
                listaJugadores.add(jug);
                break;
        }
    }
}
