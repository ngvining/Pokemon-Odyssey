package com.game.pokemon.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.game.pokemon.*;
import com.game.pokemon.Controllers.AnimationController;
import com.game.pokemon.Controllers.PlayerController;

public class GameScreen implements Screen {

    final Pokemon game;

    private SpriteBatch batch;
    private Texture Ethan;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Entity player;
    private PlayerController controller;
    private Music defaultmusic;
    private Animation<TextureRegion> animation;
    private AnimationController animController;
    private float elapsedTime;


    private Stage stage;

    public GameScreen(final Pokemon game) {

        this.game = game;

        //Creates stage
        stage = new Stage(new FitViewport(Pokemon.gamewindowwidth, Pokemon.gamewindowheight));

        //Load the Tile Map "example.tmx" file
        map = new TmxMapLoader().load("maps/Region - KANTO/Pallet Town/Kanto-PalletTown.tmx");

        //Creates a new Orthographic Camera and positions it
        camera = new OrthographicCamera();
        camera.setToOrtho(false,stage.getWidth(), stage.getHeight());
        stage.getViewport().setCamera(camera);

        //Creates the new Entity player and places him on the map at these coordinates
        player = new Entity(map, 2688, 832);

        //Creates a controller for input from keyboard and sets it to the player
        controller =  new PlayerController(player);
        Gdx.input.setInputProcessor(controller);

        //Creates the sprite batch for the sprite for the player
        batch = new SpriteBatch();

        //Loads in the player image
        Ethan = new Texture("res/Ethansprite.png");

        //Creates a renderer for the map previously loaded
        renderer = new OrthogonalTiledMapRenderer(map, Settings.SCREEN_SCALE);

        //Loads in music
        defaultmusic = Gdx.audio.newMusic(Gdx.files.internal("res/Sound/Music/1-07 Lake.mp3"));
        defaultmusic.setLooping(true);
        defaultmusic.play();

        //Animation Controller and time
        animController = new AnimationController();
        animation = animController.getAnimation();
        elapsedTime = 0f;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        //Timer
        elapsedTime += Gdx.graphics.getDeltaTime();

        //Clears screen and sets it to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Updating camera, setting its position and making the Renderer use the camera to view
        camera.update();
        renderer.setView(camera);
        camera.position.set(player.getFinalx()+16, player.getFinaly()+16, 0);

        //Renders the Map
        renderer.render();

        /*Begin drawing sprite, drawing sprite at entity x and y.
        Sets the camera and sprite to move together and then ends batch.*/
        batch.begin();
        batch.draw(animation.getKeyFrame(elapsedTime, true), player.getFinalx()-15, player.getFinaly());
        batch.setProjectionMatrix(camera.combined);
        batch.end();

        //Updating the Entity "Player"
        player.update();

        //Updating controller to detect input for movement
        controller.update();

        //Stage Handling
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

        //Updates camera viewports if window is resized
        stage.getViewport().update(width, height, true);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        //Disposes of all loaded files
        batch.dispose();
        Ethan.dispose();
        map.dispose();
        renderer.dispose();
        defaultmusic.dispose();
        stage.dispose();

    }
}
