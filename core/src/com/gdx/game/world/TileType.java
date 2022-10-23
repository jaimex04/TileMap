package com.gdx.game.world;

import java.util.HashMap;

public enum TileType {

    WALL(1, true, "WALL"),
    Floor(1,false,"Floor");

    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;
    private float damage;

    private TileType (int id, boolean collidable, String name){

    }

    //private TileType (int id, boolean collidable, String name, float damage) {
    //    this(id, collidable, name, 0);

   // }

    private TileType (int id, boolean collidable, String name, float damage) {
        this.id = id;
        this.collidable = collidable;
        this.name = name;
        this.damage = damage;
        
    }

    TileType(int id, boolean collidable, String name, int i) {
    }

    public int getId() {
        return id;

    }

    public boolean isCollidable() {
        return collidable;

    }

    public String getName() {
        return name;

    }

    public float getDamage() {
        return damage;

    }

    private static HashMap<Integer, TileType> tileMap;

    static {
        for(TileType tileType : TileType.values()){
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById (int id) {
        return tileMap.get(id);
    }


}
