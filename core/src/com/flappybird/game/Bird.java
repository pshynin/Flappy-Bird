package com.flappybird.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Vector2 pos;
    private Texture img;
    private float vecY;
    private float gravity;

    Bird() {
        this.img = new Texture("bird.png");
        this.pos = new Vector2(100, 380);
        vecY = 0;
        gravity = -0.7f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(img, pos.x, pos.y);
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            vecY = 10;
        }
        vecY += gravity;
        pos.y += vecY;
    }

    public void recreate() {
        this.pos = new Vector2(100, 380);
        vecY = 0;
    }
}
