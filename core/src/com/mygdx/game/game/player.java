package com.mygdx.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class player extends Actor {
    private Texture circleTexture;
    private TextureRegion circleRegion;

    public player() {
        super();
        setSize(50, 50);
        circleTexture = new Texture(Gdx.files.internal("banana.png"));
        circleRegion = new TextureRegion(circleTexture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor());
        batch.draw(circleRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    @Override
    public void act(float delta) {
        // Obtener el estado actual del teclado
        boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        // Calcular la velocidad en función de las teclas presionadas
        float speed = 200; // ajusta la velocidad a tu gusto
        float deltaX = 0;
        float deltaY = 0;
        if (leftPressed) {
            deltaX -= speed * delta;
        }
        if (rightPressed) {
            deltaX += speed * delta;
        }
        if (upPressed) {
            deltaY += speed * delta;
        }
        if (downPressed) {
            deltaY -= speed * delta;
        }

        // Mover el actor en función de la velocidad calculada
        if (deltaX != 0 || deltaY != 0) {
            move(deltaX, deltaY);
        }
    }


    public void move(float deltaX, float deltaY) {
        setPosition(getX() + deltaX, getY() + deltaY);
    }
}

