package com.example.kleber.gamefaroeste;

import android.os.Bundle;

import com.example.kleber.gamefaroeste.AndGraph.AGActivityGame;


public class Principalctivity extends AGActivityGame {

    private CenaAbertura abertura;
    private CenaMenu menu;
    private CenaPlay play;
    private CenaSobre sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //INICIALIZA O MOTOR GRAFICO
        init(this, false);

        //INSTANCIA CENA
        abertura = new CenaAbertura(getGameManager());
        menu = new CenaMenu(getGameManager());
        play = new CenaPlay(getGameManager());
        sobre = new CenaSobre(getGameManager());

        //REGISTRA CENAS
        getGameManager().addScene(abertura);
        getGameManager().addScene(menu);
        getGameManager().addScene(play);
        getGameManager().addScene(sobre);
    }
}
