package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gdx.game.world.GameMap;
import com.gdx.game.world.TiledGameMap;

public class MyGdxGame extends ApplicationAdapter {

	OrthographicCamera cam;
	SpriteBatch batch;
	Texture img;
	TiledMap map;
	GameMap gameMap;


	@Override
	public void create () {
		gameMap = new TiledGameMap();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, gameMap.getMapWidth(), gameMap.getMapHeight());
		cam.update();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClearColor(1,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameMap.render(cam);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
