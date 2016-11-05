package go;

import engine.GameObject;

public class Wall extends GameObject {
    public Wall(float x, float y, float sizeX, float sizeY){
        super();
        init(1.0f, 1.0f, 1.0f, x, y, sizeX, sizeY);
        setSolid(true);
    }
}
