package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private static Texture texture;
    private TextureRegion region;
    private Vector2 position;
    private float speedX;
    private float speedY;

    static {
        texture = new Texture("asteroids64.png");
    }

    public Vector2 getPosition() {
        return position;
    }

    public Asteroid() {
        this.region = new TextureRegion(texture,MathUtils.random(0,3)*64,0,64,64);
        this.position = new Vector2(1280+32, MathUtils.random(0, 720));
        this.speedX = MathUtils.random(150.0f, 350.0f);
        this.speedY = (position.y < 360?-1:1) * MathUtils.random(0, 150.0f);
    }

    public void render(SpriteBatch batch) {
        batch.draw(region, position.x - 32.0f, position.y - 32.0f);
    }

    public void update(float dt) {
        position.x -= speedX * dt;
        position.y -= speedY * dt;
        if (position.x < -32 || position.y < -32 || position.y > 752) {
            position.x = 1280+32;
            position.y = MathUtils.random(0, 720);
            speedX = MathUtils.random(150.0f, 350.0f);
            speedY = (position.y < 360?1:-1) * MathUtils.random(0, 150.0f);
        }

    }
}
