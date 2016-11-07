package go;

import engine.Animation;
import engine.GameObject;

/**
 * Created by Shaurun on 07.11.2016.
 */
public class Monster extends GameObject {
    public Monster(int x, int y){
        super();
        init(x, y, 100, 100, "monster.png");
    }

    protected void init(float x, float y, float sizeX, float sizeY, String spriteFile){
        this.setX(x);
        this.setY(y);
        sprite = new Animation(sizeX, sizeY, spriteFile, 2, 1000);
    }
}
