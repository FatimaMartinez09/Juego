package com.example.a21_pc21.juego;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoJugador extends AppCompatActivity implements View.OnClickListener {
    Button btnAceptar;
    EditText editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);
        btnAceptar=findViewById(R.id.btnAceptar);
        editNombre=findViewById(R.id.editNombre);
        btnAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAceptar:
                String Nombre = editNombre.getText().toString();
                Intent resultado = new Intent();
                resultado.putExtra("Nombre", Nombre);
                setResult(MainActivity.JUGADORNUEVO,resultado);
                finish();
                break;
        }

    }
}
