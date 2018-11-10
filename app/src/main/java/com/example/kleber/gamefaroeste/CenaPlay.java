package com.example.kleber.gamefaroeste;


import android.widget.Toast;

import com.example.kleber.gamefaroeste.AndGraph.AGActivityGame;
import com.example.kleber.gamefaroeste.AndGraph.AGGameManager;
import com.example.kleber.gamefaroeste.AndGraph.AGInputManager;
import com.example.kleber.gamefaroeste.AndGraph.AGScene;
import com.example.kleber.gamefaroeste.AndGraph.AGScreenManager;
import com.example.kleber.gamefaroeste.AndGraph.AGSoundManager;
import com.example.kleber.gamefaroeste.AndGraph.AGSprite;
import com.example.kleber.gamefaroeste.AndGraph.AGVector2D;

//UMA CENA DA APLICACAO
public class CenaPlay extends AGScene {

    AGSprite bg = null;
    AGSprite cowboy = null;

    int codigoDoSom;
    int somTiro;

    //CONTROLAM O PULO
    boolean pulando = false;
    boolean alturaMax = false;
    float altura;


    public CenaPlay(AGGameManager pManager) {
        super(pManager);
    }

    //CHAMADO TODA VEZ QUE A CENA FOR ATIVADA
    //SEMPRE QUE A CENA FOR EXIBIDA
    @Override
    public void init() {
        //COLOCO SOM DE TOQUE NA MEMORIA
        codigoDoSom = AGSoundManager.vrSoundEffects.loadSoundEffect("toc.wav");
        somTiro = AGSoundManager.vrSoundEffects.loadSoundEffect("tiro.mp3");

        //DESLIGA MUSICA DO MENU
        AGSoundManager.vrMusic.stop();

        //CARREGA BACKGROUND
        bg = createSprite(R.mipmap.bg, 1, 1);
        bg.setScreenPercent(100, 100);
        bg.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        bg.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

        //CARREGA CAWBOY
        cowboy = createSprite(R.mipmap.cowboy, 14, 1);
        cowboy.setScreenPercent(30, 50);
        cowboy.vrPosition.setX(AGScreenManager.iScreenWidth * 0.15f);
        this.altura = AGScreenManager.iScreenHeight * 0.25f;
        cowboy.vrPosition.setY(altura);

        //ANIMACAO 0 -> ANDANDO
        cowboy.addAnimation(15, true, 1, 9);
        //ANIMACAO 1 -> ATIRANDO
        cowboy.addAnimation(15, false, 10, 13);

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

        //TERMINOU DE DAR O TIRO
        if (cowboy.getCurrentAnimation().isAnimationEnded())
            cowboy.setCurrentAnimation(0);

        //CLICOU NA TELA
        if (AGInputManager.vrTouchEvents.screenClicked()) {


            float a = AGScreenManager.iScreenWidth / 2;
            float b = AGInputManager.vrTouchEvents.getLastPosition().getX();

            //CLICOU NA DIREITA
            if (b > a) {
                AGSoundManager.vrSoundEffects.play(somTiro);
                cowboy.setCurrentAnimation(1);

            } else {
                //CLICOU NA ESQUERDA
                AGSoundManager.vrSoundEffects.play(codigoDoSom);
                pulando = true;
            }
        }

        if (pulando) {

            //ELEVA/DECLINA
            cowboy.vrPosition.setY(altura);

            //VERIFICA SE JA CHEGOU NA ALTURA MAX
            if (altura >= AGScreenManager.iScreenHeight * 0.45f) {
                alturaMax = true;
            }

            //VERIFICA SE É PARA SUBIR OU PARA DESCER
            if (alturaMax == false) {
                altura += 10;
            } else {
                altura -= 10;
            }

            //VERIFICA VOLTOU AO CHAO
            if (altura <= AGScreenManager.iScreenHeight * 0.25f) {
                pulando = false;
                alturaMax = false;
                return;
            }

        }

    }
}
