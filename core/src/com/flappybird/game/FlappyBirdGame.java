package com.flappybird.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.flappybird.game.Wall.walls;

public class FlappyBirdGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Background back;
    private Bird bird;
    private Wall wall;
    boolean gameOver;
    Texture restart;

    @Override
    public void create() {
        batch = new SpriteBatch();
        back = new Background();
        bird = new Bird();
        wall = new Wall();
        gameOver = false;
        restart = new Texture("restart.png");
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        back.render(batch);
        bird.render(batch);
        wall.render(batch);
        if (!gameOver) {
            bird.render(batch);
        } else {
            batch.draw(restart, 200, 200);
        }
        batch.end();
    }

    private void update() {
        back.update();
        bird.update();
        wall.update();
        for (Wall.WallPair wp : walls) {
            if (bird.pos.x > wp.pos.x && bird.pos.x < wp.pos.x + 50) {
                if (!wp.emptySpace.contains(bird.pos)) {
                    gameOver = true;
                }
            }
        }
        if (bird.pos.y < 0 || bird.pos.y > 600) {
            gameOver = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
            recreate();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void recreate() {
        bird.recreate();
        wall.recreate();
        gameOver = false;
    }
}
