package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class MoveFromTwoPoints extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	Array<AISprite> aiSprites;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setSize(50, 50);
		sprite.setOrigin(0, 0);
		sprite.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());

		aiSprites = new Array<AISprite>();
		aiSprites.add(new AISprite(sprite, generatePath()));
	}

	public Array<Vector2> generatePath() {
		Array<Vector2> path = new Array<Vector2>();
		Vector2 tmpV = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		path.add(tmpV);
		return path;
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		sprite.getTexture().dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for(AISprite aiSprite : aiSprites){
			aiSprite.draw(batch);
		}
		batch.end();
	}
}
