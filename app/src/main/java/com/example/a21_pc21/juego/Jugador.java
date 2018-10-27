package com.example.a21_pc21.juego;


import java.io.Serializable;

public class Jugador {

    private int id;
    private String Nick;
    private int Victorias;
    private int Derrotas;
    private int Empates;

    Jugador(int i, String n, int v, int d, int e){
        this.id=i;
        this.Nick=n;
        this.Victorias=v;
        this.Derrotas=d;
        this.Empates=e;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String nick) {
        Nick = nick;
    }

    public int getVictorias() {
        return Victorias;
    }

    public void setVictorias(int victorias) {
        Victorias = victorias;
    }

    public int getDerrotas() {
        return Derrotas;
    }

    public void setDerrotas(int derrotas) {
        Derrotas = derrotas;
    }

    public int getEmpates() {
        return Empates;
    }

    public void setEmpates(int empates) {
        Empates = empates;
    }



}
