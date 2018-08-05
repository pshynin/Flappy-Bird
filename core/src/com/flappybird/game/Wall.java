package com.flappybird.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Wall {

    class WallPair {
        Vector2 pos;
        float speed;
        int offset;

        WallPair(Vector2 pos) {
            this.pos = pos;
            this.speed = 2;
            this.offset = new Random().nextInt(250);
        }

        void update() {
            pos.x -= speed;
            if (pos.x < -50) {
                pos.x = 800;
                offset = new Random().nextInt(250);
            }
        }
    }

    private Texture img;
    private WallPair[] walls;
    private int wallDist;

    Wall() {
        this.img = new Texture("wall.png");
        this.walls = new WallPair[4];
        int startX = 400;
        wallDist = 250;

        for (int i = 0; i < walls.length; i++) {
            walls[i] = new WallPair(new Vector2(startX, 0));
            startX += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (WallPair wp : walls) {
            batch.draw(img, wp.pos.x, wp.pos.y);
            //TODO fix walls height !!!
            batch.draw(img, wp.pos.x, wp.pos.y + wallDist + img.getHeight() - wp.offset);
        }
    }

    public void update() {
        for (WallPair wp : walls) {
            wp.update();
        }
    }
}
