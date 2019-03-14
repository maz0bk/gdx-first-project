package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Background background;
    Hero hero;
    Asteroid asteroid;

    // Разобраться с кодом
    // Не давать кораблю вылетать за лвую и правую сторону экрана
    // Верхнюю и нижнюю сторону экрана корабль должен пролетать насквозь
    // * Добавить астероид, который летает по экрану по типу звезд
    // и проверять столкновение этого астероида с кораблем, при столкновении
    // "пересоздавать" астероид

    // Варианты игры: Гонки, Герои 3, Марио, RTS, tower defence, косм. стрелялка вид (сбоку/сверху)
    // worms, battle toads

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Background();
        hero = new Hero();
        asteroid = new Asteroid();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        hero.render(batch);
        asteroid.render(batch);
        batch.end();
    }

    public void update(float dt) {
        background.update(dt);
        hero.update(dt);
        asteroid.update(dt);
        Vector2 posHero = hero.getPosition();
        Vector2 posAsteroid = asteroid.getPosition();
        if (posHero.dst(posAsteroid) < 64){
            asteroid = new Asteroid();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
