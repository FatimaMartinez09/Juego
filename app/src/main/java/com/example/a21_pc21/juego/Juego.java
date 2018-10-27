package com.example.a21_pc21.juego;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Juego extends AppCompatActivity implements View.OnClickListener {

    TextView editPuntos, editNickName, editVictorias, editDerrotas, editEmpates;
    Button btnFinalizar, btnCPU, btnPiedra, btnTijera, btnPapel;
    public final int Piedra = 1;
    public final int Papel = 2;
    public final int Tijera = 3;
    public static Jugador j;
    public static int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        editPuntos = findViewById(R.id.editPuntos);
        editNickName = findViewById(R.id.editNickName);
        editVictorias = findViewById(R.id.editVictorias);
        editDerrotas = findViewById(R.id.editDerrotas);
        editEmpates = findViewById(R.id.editEmpates);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnCPU = findViewById(R.id.btnCPU);
        btnPiedra = findViewById(R.id.btnPiedra);
        btnTijera = findViewById(R.id.btnTijera);
        btnPapel = findViewById(R.id.btnPapel);

        posicion = getIntent().getIntExtra("Posicion", 0);
        j = MainActivity.listaJugadores.get(posicion);
        editNickName.setText(j.getNick());
        editPuntos.setText("0");
        editVictorias.setText("Victorias: " + String.valueOf(j.getVictorias()));
        editDerrotas.setText("Perdidos: " + String.valueOf(j.getDerrotas()));
        editEmpates.setText("Empates: " + String.valueOf(j.getEmpates()));

        btnPiedra.setOnClickListener(this);
        btnTijera.setOnClickListener(this);
        btnPapel.setOnClickListener(this);
        btnFinalizar.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.listaJugadores.set(posicion, j);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPiedra:
                Evaluacion(Piedra);
                break;

            case R.id.btnTijera:
                Evaluacion(Tijera);
                break;

            case R.id.btnPapel:
                Evaluacion(Papel);
                break;

            case R.id.btnFinalizar:
                finish();
                break;
        }
    }

    private void Evaluacion(int Jug) {

        Random r = new Random();
        int i = r.nextInt(4 - 1) + 1;
        int puntos = Integer.parseInt(editPuntos.getText().toString());
        switch (i) {
            case 1: {
                btnCPU.setText("O");
                if (Jug == Piedra) {
                    j.setEmpates(j.getEmpates() + 1);
                    editEmpates.setText("Empatados: " + String.valueOf(j.getEmpates()));
                } else {
                    if (Jug == Papel) {
                        j.setVictorias(j.getVictorias() + 1);
                        puntos+=6;
                        editPuntos.setText(String.valueOf(puntos));
                        editVictorias.setText("Ganados: " + String.valueOf(j.getVictorias()));
                    } else {
                        puntos -= 3;
                        editPuntos.setText(String.valueOf(puntos));
                        j.setDerrotas(j.getDerrotas() + 1);
                        editDerrotas.setText("Perdidos: " + String.valueOf(j.getDerrotas()));
                    }
                }
            }
            break;

            case 2: {
                btnCPU.setText("X");
                if (Jug == Piedra) {
                    puntos+=6;
                    editPuntos.setText(String.valueOf(puntos));
                    j.setVictorias(j.getVictorias() + 1);
                    editVictorias.setText("Ganados: " + String.valueOf(j.getVictorias()));
                } else {
                    if (Jug == Papel) {
                        puntos-=3;
                        editPuntos.setText(String.valueOf(puntos));
                        j.setDerrotas(j.getDerrotas() + 1);
                        editDerrotas.setText("Perdidos: " + String.valueOf(j.getDerrotas()));
                    } else {
                        j.setEmpates(j.getEmpates() + 1);
                        editEmpates.setText("Empatados: " + String.valueOf(j.getEmpates()));
                    }
                }
            }
            break;

            case 3: {
                btnCPU.setText("[_]");
                if (Jug == Piedra) {
                    puntos-=3;
                    editPuntos.setText(String.valueOf(puntos));
                    j.setDerrotas(j.getDerrotas() + 1);
                    editDerrotas.setText("Perdidos: " + String.valueOf(j.getDerrotas()));
                } else {
                    if (Jug == Papel) {
                        j.setEmpates(j.getEmpates() + 1);
                        editEmpates.setText("Empatados: " + String.valueOf(j.getEmpates()));
                    } else {
                        puntos += 6;
                        editPuntos.setText(String.valueOf(puntos));
                        j.setVictorias(j.getVictorias() + 1);
                        editVictorias.setText("Ganados: " + String.valueOf(j.getVictorias()));
                    }
                }
            }
            break;
        }
    }
}