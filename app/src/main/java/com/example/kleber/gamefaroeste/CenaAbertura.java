package com.example.kleber.gamefaroeste;


import com.example.kleber.gamefaroeste.AndGraph.AGGameManager;
import com.example.kleber.gamefaroeste.AndGraph.AGScene;
import com.example.kleber.gamefaroeste.AndGraph.AGScreenManager;
import com.example.kleber.gamefaroeste.AndGraph.AGSoundManager;
import com.example.kleber.gamefaroeste.AndGraph.AGSprite;
import com.example.kleber.gamefaroeste.AndGraph.AGTimer;

//UMA CENA DA APLICACAO
public class CenaAbertura extends AGScene {

    AGTimer tempo = null;
    AGSprite pantera = null;


    public CenaAbertura(AGGameManager pManager) {
        super(pManager);
    }

    //CHAMADO TODA VEZ QUE A CENA FOR ATIVADA
    //SEMPRE QUE A CENA FOR EXIBIDA
    @Override
    public void init() {

        tempo = new AGTimer(3000);

        //Musica longa
        AGSoundManager.vrMusic.loadMusic("oest.mp3", true);
        AGSoundManager.vrMusic.play();

        setSceneBackgroundColor(132, 108, 38);

        pantera = createSprite(R.mipmap.pantera, 2, 4);
        pantera.setScreenPercent(40, 15);

        //CONFIGURA O CENTRO DO OBJETO
        pantera.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        pantera.vrPosition.setY(AGScreenManager.iScreenHeight /2);

        //quantidade de quadros trocados por segundo
        //voltar para o primeiro?
        //frame inicial
        //frame final
        pantera.addAnimation(20, true, 0, 7);

        //espelhamento
        //pantera.iMirror = AGSprite.HORIZONTAL;//espelhamento horizontal
    }

    //APOS O RETORNO DE UMA INTERRUPCAO
    @Override
    public void restart() {
    }

    //QUANDO UM INTERRUPCAO OCERRER
    @Override
    public void stop() {
    }

    //CHAMADO N VEZES POR SEGUNDO
    @Override
    public void loop() {

//        tempo.update();

//        if (tempo.isTimeEnded()) {
            //TROCA A CENA
            vrGameManager.setCurrentScene(1);
//        }
    }
}
