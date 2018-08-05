package com.flappybird.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBirdGame extends ApplicationAdapter {
    SpriteBatch batch;
    Background bg;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Background();
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        bg.render(batch);
        batch.end();
    }

    private void update() {
        bg.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
