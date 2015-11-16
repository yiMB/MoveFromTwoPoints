package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class AISprite extends Sprite {

    Vector2 velocity = new Vector2();
    float speed = 200;
    Array<Vector2> path;
    int waypointIndex = 0;
    Sprite sprite;

    public AISprite(Sprite sprite, Array<Vector2> path) {
        super(sprite);
        this.path = path;
        this.sprite = sprite;
    }

    public void draw(SpriteBatch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta){
        if(Gdx.input.justTouched() || Gdx.input.isTouched()){
            this.path = generatePath();
        }
        float angle = (float) Math.atan2(path.get(waypointIndex).y - getY(), path.get(waypointIndex).x - getX());
        velocity.set((float) Math.cos(angle) * speed, (float) Math.sin(angle) * speed);

        setPosition(getX() + velocity.x * delta, getY() + velocity.y * delta);
    }

    public Array<Vector2> generatePath() {
        Array<Vector2> path = new Array<Vector2>();
        Vector2 tmpV = new Vector2(Gdx.input.getX() - sprite.getWidth()/2, Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
        path.clear();
        path.add(tmpV);
        return path;
    }
}
