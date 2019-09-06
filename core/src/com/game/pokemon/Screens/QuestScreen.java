package com.game.pokemon.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.game.pokemon.Pokemon;

public class QuestScreen implements Screen {

    final Pokemon game;
    final Screen parent;
    private Stage stage;
    public Screen QuestScreen;

    public class MyActor extends Actor {
        Texture menubackground = new Texture("res/MenuScreenBoat.png");

        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(menubackground,0,0, stage.getWidth(), stage.getHeight());
        }
    }

    public QuestScreen (final Pokemon game, final Screen parent) {

        this.game = game;
        this.parent = parent;

        stage = new Stage(new FitViewport(Pokemon.gamewindowwidth, Pokemon.gamewindowheight));
        MyActor myActor = new MyActor();
        stage.addActor(myActor);

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

        //Screen screen = new Screen(QuestScreen);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            game.setScreen(parent);
        }

    }

    @Override
    public void resize(int width, int height) {

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

    }
}
