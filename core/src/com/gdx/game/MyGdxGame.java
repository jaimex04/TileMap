package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gdx.game.world.GameMap;
import com.gdx.game.world.TiledGameMap;

public class MyGdxGame extends ApplicationAdapter {


	GameMap gameMap;
	OrthographicCamera cam;
	SpriteBatch batch;
	ShapeRenderer visualHitbox;
	Texture player;
	Rectangle playerHitBox;

	// player position and speed variables
	private float positionX = 200f, prevX;
	private float positionY = 200f, prevY;

	// player hitbox information
	private float hitboxWidth = 13f; // Right Y
	private float hitBoxHeight = 15f; // Top X
	private float hitBoxX = 12f; // Left Y
	private float hitboxY = 7f; // Moves Bottom X up

	// Handles the players movement. (WASD)
	void playerMovement() {

		float playerSpeed = 100f;
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			// System.out.println("Player is moving up");
			prevY = positionY;
			positionY += Gdx.graphics.getDeltaTime() * playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			// System.out.println("Player is moving left");
			prevX = positionX;
			positionX -= Gdx.graphics.getDeltaTime()  * playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			// System.out.println("Player is moving down");
			prevY = positionY;
			positionY -= Gdx.graphics.getDeltaTime()  * playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			// System.out.println("Player is moving right");
			prevX = positionX;
			positionX += Gdx.graphics.getDeltaTime()  * playerSpeed;
		}
	}

	@Override
	public void create () {
		player = new Texture("idle.png");
		playerHitBox = new Rectangle(positionX + hitBoxX,positionY + hitboxY,hitboxWidth,hitBoxHeight);
		batch = new SpriteBatch();
		visualHitbox = new ShapeRenderer();
		gameMap = new TiledGameMap();
		cam = new OrthographicCamera();

		cam.setToOrtho(false, gameMap.getMapWidth(), gameMap.getMapHeight());
		cam.update();

		prevX = 200;
		prevY = 120;

	}

	boolean isCollidedWithRectangles() {

		// iterating through all the rectangles on the "Wall" layer and checking for collision between the player and the rectangles
		for( RectangleMapObject wall : gameMap.getWallObject().getByType(RectangleMapObject.class)) {

			Rectangle r = wall.getRectangle();

			// when player collides with any rectangle on the "Wall" layer
			if(Intersector.overlaps(r,playerHitBox)) {
				return true;
			}

		}

		return false;
	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClearColor(1,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// renders map of the game
		gameMap.render(cam);

		batch.begin();
		batch.draw(player,positionX,positionY, 40,40);

		// checks for collision between the player and the invisible rectangles from tilemap
		if(isCollidedWithRectangles()) {
			positionX = prevX;
			positionY = prevY;
		}

		// handles player movement
		playerMovement();

		// redraws hitbox
		playerHitBox = new Rectangle(positionX + hitBoxX,positionY + hitboxY,hitboxWidth,hitBoxHeight);

		batch.end();

		// draws hitbox
		visualHitbox.begin(ShapeRenderer.ShapeType.Line);
		visualHitbox.rect(positionX + hitBoxX,positionY + hitboxY,hitboxWidth,hitBoxHeight);
		visualHitbox.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		visualHitbox.dispose();
		player.dispose();
		gameMap.dispose();

	}
}
