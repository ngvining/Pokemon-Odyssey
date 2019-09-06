package com.game.pokemon.Screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.pokemon.Pokemon;


public class MainMenu implements Screen {

    final Pokemon game;

    private Stage stage;
    private Table table;
    private Skin skin;
    private TextButton newGame;
    private TextButton loadGame;
    private TextButton options;
    private TextButton quit;

    public class MyActor extends Actor {
        Texture menubackground = new Texture("res/MenuScreenBoat.png");

        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(menubackground,0,0, stage.getWidth(), stage.getHeight());
        }
    }

    public class TitleLogo extends Actor {
        Texture title = new Texture("res/Pokemontitle.png");

        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(title,stage.getWidth()/4f,stage.getHeight()-140, stage.getWidth()/2, stage.getHeight()/4);
        }
    }

    public MainMenu(final Pokemon game) {

        this.game = game;

        stage = new Stage(new FitViewport(480, 480));

        MyActor myActor = new MyActor();
        TitleLogo titleLogo = new TitleLogo();

        stage.addActor(myActor);
        stage.addActor(titleLogo);

        Gdx.input.setInputProcessor(stage);

        //TODO add skin json
        skin = new Skin(Gdx.files.internal("res/test/skin/uiskin.json"));

        newGame = new TextButton("New Game", skin);
        loadGame = new TextButton("Load Game", skin);
        options = new TextButton("Options", skin);
        quit = new TextButton("Quit", skin);

        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        table.align(0);

        table.addActor(newGame);
        newGame.setBounds(Pokemon.gamewindowwidth/2-quit.getWidth(), Pokemon.gamewindowheight-340, 90, 30);

        table.addActor(loadGame);
        loadGame.setBounds(Pokemon.gamewindowwidth/2-quit.getWidth(), Pokemon.gamewindowheight-380, 90, 30);

        table.addActor(options);
        options.setBounds(Pokemon.gamewindowwidth/2-quit.getWidth(), Pokemon.gamewindowheight-420, 90, 30);

        table.addActor(quit);
        quit.setBounds(Pokemon.gamewindowwidth/2-quit.getWidth(), Pokemon.gamewindowheight-460, 90, 30);

        stage.addActor(table);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        if (newGame.isPressed()) {
            game.setScreen(new GameScreen(game));
        }

        if (quit.isPressed()) {
             Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
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
        stage.dispose();
    }
}
