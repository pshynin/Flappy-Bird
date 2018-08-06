package com.flappybird.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Wall {

    class WallPair {
        Vector2 pos;
        Rectangle emptySpace;
        float speed;
        int offset;

        WallPair(Vector2 pos) {
            this.pos = pos;
            speed = 2;
            offset = new Random().nextInt(250);
            emptySpace = new Rectangle(this.pos.x, this.pos.y - offset + 300, 50, distY);
        }

        void update() {
            pos.x -= speed;
            if (pos.x < -50) {
                pos.x = 800;
                this.offset = new Random().nextInt(250);
            }
            emptySpace.x = pos.x;
        }
    }

    static WallPair[] walls;
    int distX;
    int distY;
    private Texture img;

    Wall() {
        img = new Texture("wall.png");
        walls = new WallPair[4];
        distX = 400; //how far from beginning the first wall starts
        distY = 250; //distance between walls vertical

/*        for (WallPair wp : walls) {
            wp = new WallPair(new Vector2(distX, 0));
            distX += 220;
        }*/
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new WallPair(new Vector2(distX, 0));
            distX += 220; //distance between next walls horizontal
        }
    }

    public void render(SpriteBatch batch) {
        for (WallPair wp : walls) {
            batch.draw(img, wp.pos.x, wp.pos.y - wp.offset);
            batch.draw(img, wp.pos.x, wp.pos.y + this.distY + img.getHeight() - wp.offset);
        }
    }

    public void update() {
        for (WallPair wp : walls) {
            wp.update();
        }
    }

    public void recreate() {
        int distX = 400;
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new WallPair(new Vector2(distX, 0));
            distX += 220; //distance between next walls horizontal
        }
    }
}
