package com.flappybird.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBirdGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Background bg;
    private Bird bird;
    private Wall wall;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Background();
        bird = new Bird();
        wall = new Wall();
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        bg.render(batch);
        bird.render(batch);
        wall.render(batch);
        batch.end();
    }

    private void update() {
        bg.update();
        bird.update();
        wall.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
