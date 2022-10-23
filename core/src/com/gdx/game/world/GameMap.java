package com.gdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameMap {



    public abstract void render(OrthographicCamera camera);

    public void update(float delta) {
    }

    public abstract void dispose();

    /**
     * Gets tile by pixel position withing game world
     *
     * @param layer
     * @param x
     * @param y
     * @return
     */
    public TileType getTileTypeByLocation(int layer, float x, float y){
        return this.getTileTypeByCoordinate(layer, (int) (x /TileType.TILE_SIZE),(int)(y /TileType.TILE_SIZE));
}




    /**
     *
     * @param layer
     * @param col
     * @param row
     * @return
     */
    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();

    public abstract int getMapWidth();
    public abstract int getMapHeight();
}