package com.mygdx.game.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.mygdx.game.game.player;

public class MyScreen implements Screen {

    private Stage stage;
    private com.mygdx.game.game.player player;
    private Texture backgroundImage;

    public MyScreen() {
        stage = new Stage(new ScreenViewport());
        player = new player();

        // Cargar la imagen de fondo
        backgroundImage = new Texture(Gdx.files.internal("fondo.png"));

        stage.addActor(player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {

        // Dibujar la imagen de fondo
        stage.getBatch().begin();
        stage.getBatch().draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();

        // Dibujar el escenario
        stage.act(delta);
        stage.draw();
    }

    // Otras implementaciones de la interfaz Screen
    // ...


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        // ...
    }

    @Override
    public void resume() {
        // ...
    }

    @Override
    public void hide() {
        // ...
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
