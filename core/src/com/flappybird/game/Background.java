package com.flappybird.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class BGPicture {
        Vector2 pos;
        private Texture tx;

        BGPicture(Vector2 pos) {
            this.tx = new Texture("back.png");
            this.pos = pos;
        }
    }

    private int speed;
    private BGPicture[] backs;

    Background() {
        speed = 4;
        backs = new BGPicture[2];
        backs[0] = new BGPicture(new Vector2(0, 0));
        backs[1] = new BGPicture(new Vector2(800, 0));
    }

    public void render(SpriteBatch batch) {
        for (BGPicture pic : backs) {
            batch.draw(pic.tx, pic.pos.x, pic.pos.y);
        }
    }

    public void update() {
        for (BGPicture pic : backs) {
            pic.pos.x -= speed;
        }

        if (backs[0].pos.x < -800) {
            backs[0].pos.x = 0;
            backs[1].pos.x = 800;
        }
    }
}
