package com.game.pokemon;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Entity extends Actor {

    private TiledMap map;
    private int x, y;
    private float finalx, finaly;
    private int targetx, targety;
    private int startx, starty;
    private float  mapwidth, mapheight;
    private PLAYER_STATE state;
    private float animTimer;
    private float ANIM_TIME = 0.5f;
    private int xcell, ycell;


    //Assigns the State of the Entity and its current moving Status
    public enum PLAYER_STATE {
        STANDING,
        WALKING;
    }

    //The Entity Central Class
    public Entity(TiledMap map, float x, float y) {

        this.map = map;
        this.x = (int) x;
        this.y = (int) y;
        this.finalx = x;
        this.finaly = y;
        this.state = PLAYER_STATE.STANDING;

    }

    public boolean move (int destx, int desty) {

        //
        if (state != PLAYER_STATE.STANDING) {
            return false;
        }

        //
        if (x+destx >= getMapwidth()*2 || x+destx < 0 || y+desty >= getMapheight()*2 || y+desty < 0) {
            return false;
        }

        //
        beginmove(x, y, destx, desty);

        //
        x+=destx;
        y+=desty;

        return true;
    }

    private void beginmove(int originx, int originY, int destx, int desty ) {

        this.startx = originx;
        this.starty = originY;
        this.targetx = originx+destx;
        this.targety = originY+desty;
        this.finalx = originx;
        this.finaly = originY;
        animTimer = 0f;
        state = PLAYER_STATE.WALKING;
    }

    private void finishMove () {
        state = PLAYER_STATE.STANDING;
        this.finalx = targetx;
        this.finaly = targety;
        this.startx = 0;
        this.starty = 0;
        this.targetx = 0;
        this.targety = 0;
    }

    public void update() {
        if (state == PLAYER_STATE.WALKING){
            animTimer += 0.04;
            finalx = Interpolation.linear.apply(startx, targetx, animTimer/ANIM_TIME);
            finaly = Interpolation.linear.apply(starty, targety, animTimer/ANIM_TIME);
            if (animTimer > ANIM_TIME) {
                finishMove();
            }
        }
    }

    public boolean getCollisionDown () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 1");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX(), getEntityY() - 1).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    //Get Collision for tile above the Entity and sends it to the Controller Class to determine collision using Tile Properties
    public boolean getCollisionUp () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 1");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX(), getEntityY() + 1).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    //Get Collision for tile left of the Entity and sends it to the Controller Class to determine collision using Tile Properties
    public boolean getCollisionLeft () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 1");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX() - 1, getEntityY()).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    //Get Collision for tile right of the Entity and sends it to the Controller Class to determine collision using Tile Properties
    public boolean getCollisionRight () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 1");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX() + 1, getEntityY()).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionDown1 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 2");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX(), getEntityY() - 1).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionDown2 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 3");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX(), getEntityY() - 1).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }
        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionUp1 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 2");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX(), getEntityY() + 1).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionUp2 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 3");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX(), getEntityY() + 1).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionRight1 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 2");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX() + 1, getEntityY()).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionRight2 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 3");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX() + 1, getEntityY()).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionLeft1 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 2");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX() - 1, getEntityY()).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    public boolean getCollisionLeft2 () {

        TiledMapTileLayer collisionlayer = (TiledMapTileLayer) map.getLayers().get("Tile Layer 3");
        Object collidelayer = new Object();

        try {
            collidelayer = collisionlayer.getCell(getEntityX() - 1, getEntityY()).getTile().getProperties().get("collide");
        } catch (Exception e) {
            return collidelayer == null;
        }

        if (collidelayer != null) {
            return true;
        } else return false;
    }

    //Return Entity X in pixels
    /*public int getX() {
        return x;
    }

    //Return Entity Y in pixels
    public int getY() {
        return y;
    }*/

    //Return Entity Finalx which is used for interpolation and Smooth movement
    public float getFinalx () {
        return finalx;
    }

    //Return Entity Finaly which is used for interpolation and Smooth movement
    public float getFinaly() {
        return finaly;
    }

    //Returns Entity X in Cells/Tiles
    public int getEntityX() {
        xcell = x/32;
        return xcell;
    }

    //Returns Entity Y in Cells/Tiles
    public int getEntityY(){
        ycell = y/32;
        return ycell;
    }

    //Returns Map Width in Cells/Tiles
    public float getMapwidth() {
        TiledMapTileLayer layer = (TiledMapTileLayer)map.getLayers().get("Tile Layer 1");
        return mapwidth = layer.getWidth() * layer.getTileWidth();
    }

    //Returns Map Height in Cells/Tiles
    public float getMapheight() {
        TiledMapTileLayer layer = (TiledMapTileLayer)map.getLayers().get("Tile Layer 1");
        return mapheight = layer.getHeight() * layer.getTileHeight();
    }

    //Returns Current Map Entity is on
    public TiledMap getMap() {
        return map;
    }
}