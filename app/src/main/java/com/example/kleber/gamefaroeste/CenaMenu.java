package com.example.kleber.gamefaroeste;


import com.example.kleber.gamefaroeste.AndGraph.AGGameManager;
import com.example.kleber.gamefaroeste.AndGraph.AGInputManager;
import com.example.kleber.gamefaroeste.AndGraph.AGScene;
import com.example.kleber.gamefaroeste.AndGraph.AGScreenManager;
import com.example.kleber.gamefaroeste.AndGraph.AGSprite;

//UMA CENA DA APLICACAO
public class CenaMenu extends AGScene {

    AGSprite bg = null;
    AGSprite logo = null;
    AGSprite play = null;
    AGSprite sobre = null;
    AGSprite sair = null;

    public CenaMenu(AGGameManager pManager) {
        super(pManager);
    }

    //CHAMADO TODA VEZ QUE A CENA FOR ATIVADA
    //SEMPRE QUE A CENA FOR EXIBIDA
    @Override
    public void init() {

        bg = createSprite(R.mipmap.bgmenu, 1, 1);
        bg.setScreenPercent(100, 100);
        bg.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        bg.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

        logo = createSprite(R.mipmap.logo, 1, 1);
        logo.setScreenPercent(55, 45);
        logo.vrPosition.setX(AGScreenManager.iScreenWidth / 1.5f);
        logo.vrPosition.setY(AGScreenManager.iScreenHeight * 0.8f);

        play = createSprite(R.mipmap.play, 1, 1);
        play.setScreenPercent(30, 25);
        play.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        play.vrPosition.setY(AGScreenManager.iScreenHeight * 0.5f);

        sobre = createSprite(R.mipmap.duvida, 1, 1);
        sobre.setScreenPercent(25, 25);
        sobre.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        sobre.vrPosition.setY(AGScreenManager.iScreenHeight * 0.3f);

        sair = createSprite(R.mipmap.sair, 1, 1);
        sair.setScreenPercent(25, 25);
        sair.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        sair.vrPosition.setY(AGScreenManager.iScreenHeight * 0.1f);
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
        if (AGInputManager.vrTouchEvents.screenClicked()) {

//            //ve se ouve colisão entre dois sprites
//            if (play.collide(sair)){
//                //faz alguma coisa
//            }

            if (play.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                vrGameManager.setCurrentScene(2);
                return;
            }

            if (sobre.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                vrGameManager.setCurrentScene(3);
                return;
            }

            if (sair.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                vrGameManager.vrActivity.finish();
                return;
            }
        }
    }
}
