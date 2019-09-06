package com.game.pokemon.Controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.game.pokemon.Entity;
import com.game.pokemon.Settings;

public class PlayerController implements InputProcessor {

    //Creates the Entity to assign a controller too
    private Entity player;

    //Making the Controller class
    public PlayerController(Entity p) {
        this.player = p;
    }

    //Booleans for movement
    public boolean movingUP;
    public boolean movingRIGHT;
    public boolean movingLEFT;
    public boolean movingDOWN;

    //Detecting when keys are released
    @Override
    public boolean keyUp(int keycode) {

        if (keycode == Input.Keys.UP)
            return movingUP = false;
        if (keycode == Input.Keys.RIGHT)
            return movingRIGHT = false;
        if (keycode == Input.Keys.LEFT)
            return movingLEFT = false;
        if (keycode == Input.Keys.DOWN)
            return movingDOWN = false;

        return false;}

    //Detects when keys are pressed
    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.UP)
            return movingUP = true;
        if (keycode == Input.Keys.RIGHT)
            return movingRIGHT = true;
        if (keycode == Input.Keys.LEFT)
            return movingLEFT = true;
        if (keycode == Input.Keys.DOWN)
            return movingDOWN = true;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public boolean isMovingUp() {
        if (movingUP && !player.getCollisionUp() && !player.getCollisionUp1() && !player.getCollisionUp2())
            return  true;
        return false;
    }

    public boolean isMovingRight() {
        if (movingRIGHT && !player.getCollisionRight() && !player.getCollisionRight1() && !player.getCollisionRight2())
            return  true;
        return false;
    }

    public boolean isMovingLeft() {
        if (movingLEFT && !player.getCollisionLeft() && !player.getCollisionLeft1() && !player.getCollisionLeft2())
            return  true;
        return false;
    }

    public boolean isMovingDown() {
        if (movingDOWN && !player.getCollisionDown() && !player.getCollisionDown1() && !player.getCollisionDown2())
            return  true;
        return false;
    }

    public void update() {
        //Movement
        if (isMovingUp() && !player.getCollisionUp() && !player.getCollisionUp1() && !player.getCollisionUp2())
            player.move(0, Settings.TILE_SIZE);
        if (isMovingRight() && !player.getCollisionRight() && !player.getCollisionRight1() && !player.getCollisionRight2())
            player.move(Settings.TILE_SIZE, 0);
        if (isMovingLeft() && !player.getCollisionLeft() && !player.getCollisionLeft1() && !player.getCollisionLeft2())
            player.move(-Settings.TILE_SIZE, 0);
        if (isMovingDown() && !player.getCollisionDown() && !player.getCollisionDown1() && !player.getCollisionDown2())
            player.move(0, -Settings.TILE_SIZE);
    }

}
