package com.jimminor.game;

import com.almasb.fxgl.app.DSLKt;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.extra.physics.handlers.CollectibleHandler;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.settings.GameSettings;
import com.almasb.fxgl.texture.Texture;
import com.jimminor.componentes.ShipFactory;
import com.jimminor.componentes.SpaceEntity;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Map;

import static com.almasb.fxgl.app.DSLKt.*;

/**
 * @author  Giammarco Moscariello   - ( gia.moscariello@gmail.com ) -
 */
public class BasicGameApp extends GameApplication {

    private Entity myShip;
    private Entity enimyShip;
    private Entity player;
    private int life = 500;

    @Override protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(600);
        gameSettings.setHeight(600);
        gameSettings.setTitle("My First Game app");
        gameSettings.setVersion("0.1");
        gameSettings.setCloseConfirmation(true);
        gameSettings.setIntroEnabled(false);
    }

    @Override protected void initGame() {
        // Create add a Factory
        getGameWorld().addEntityFactory(new ShipFactory());

        getGameWorld().addEntities(Entities.makeScreenBounds(30));

        myShip = spawn("myShip",450,450);
        enimyShip = spawn("enemyShip",150,30);
    }

    @Override protected  void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                myShip.translateX(5);
                myShip.getCenter();
                getGameState().increment("pixelsMoved", +5);
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                myShip.translateX(-5); // move left 5 pixels
                getGameState().increment("pixelsMoved", -5);
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                myShip.translateY(-5); // move up 5 pixels
                getGameState().increment("pixelsMoved", -5);
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                myShip.translateY(5); // move down 5 pixels
                getGameState().increment("pixelsMoved", +5);
            }
        }, KeyCode.S);

        input.addAction(new UserAction("shoot") {
            @Override
            protected void onActionBegin () {
                Entity bullet = spawn("bullet",myShip.getPosition());
                bullet.rotateBy(90);

            }

        },KeyCode.SPACE);
    }

    @Override protected void initUI() {
//        Texture brickTexture = getAssetLoader().loadTexture("orangeship3.png");
//       brickTexture.setTranslateX(150);
//        brickTexture.setTranslateY(30);

        //getGameScene().addUINode(brickTexture);
	    //etGameScene().setBackgroundRepeat("space.jpg");
        getGameScene().setBackgroundColor(Color.PURPLE);

    }

    @Override protected  void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved",0);
    }

    @Override protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(SpaceEntity.MYSHIP, SpaceEntity.ENEMY_SHIP){
            @Override
            protected void onCollisionBegin (Entity myShip, Entity enemyShip) {
            	life--;
            	System.out.println(life);
            }
        });
    }
    public static  void main (String args[]){
        launch(args);
    }
}
