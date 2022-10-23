package com.gdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledGameMap extends GameMap {

    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;
    TiledMapTileLayer mainLayer;

    private int tileSize;

    public TiledGameMap () {
        tiledMap = new TmxMapLoader().load("Caves.tmx");
        mainLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        this.tileSize = mainLayer.getTileWidth();
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

//    private int getMapWidth() {
//        return mainLayer.getWidth() * tileSize;
//    }
//
//    private int getMapHeight() {
//        return mainLayer.getHeight() * tileSize;
//    }

    @Override
    public int getMapWidth() {
        return mainLayer.getWidth() * tileSize;
    }


    @Override
    public int getMapHeight() {
        return mainLayer.getHeight() * tileSize;
    }


    @Override
    public void render(OrthographicCamera camera) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

    }

    @Override
    public void update(float delta) {
        super.update(delta);

    }

    @Override
    public void dispose() {
        tiledMap.dispose();

    }

    @Override
    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return null;
    }

    @Override
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getLayers() {
        return 0;
    }
}
