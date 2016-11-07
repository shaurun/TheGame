package go;

import engine.GameObject;
import engine.TexturedSprite;
import engine.enums.Direction;
import org.lwjgl.input.Keyboard;
import windows.Game;

import java.util.Arrays;
import java.util.List;

import static engine.enums.Direction.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * Created by Shaurun on 05.11.2016.
 */
public class Player extends GameObject {
    public static final float SIZE = 15;
    private float moveAmountX;
    private float moveAmountY;

    public Player(int x, int y){
        super();
        init(x, y, SIZE, SIZE, "heart.png");
    }

    protected void init(float x, float y, float sizeX, float sizeY, String spriteFile){
        this.setX(x);
        this.setY(y);
        sprite = new TexturedSprite(sizeX, sizeY, spriteFile);
    }


    @Override
    public void update(){
        //TODO: somehow update movement here, not in getInput
    }

    public void getInput(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W) && !Keyboard.isKeyDown(Keyboard.KEY_S)){
            move(UP);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S) && !Keyboard.isKeyDown(Keyboard.KEY_W)) {
            move(DOWN);
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_A) && !Keyboard.isKeyDown(Keyboard.KEY_D)){
            move(LEFT);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D) && !Keyboard.isKeyDown(Keyboard.KEY_A)){
            move(RIGHT);
        }
    }

    //TODO: moving with pixel independent speed
    private void move(Direction direction){
        float newX = getX();
        float newY = getY();
        float acceleration = 1f;
        float step = 4f;

        switch (direction){
            case UP: newY+=step*acceleration; break;
            case DOWN: newY-=step*acceleration; break;
            case RIGHT: newX+=step*acceleration; break;
            case LEFT: newX-=step*acceleration; break;
        }

        List<GameObject> objects = Game.rectangleCollide(newX, newY, newX + SIZE, newY + SIZE);
        for (GameObject go : objects){
            if (go.getSolid()){
                onCollideWith(go, direction);
                return;
            }
        }

        setX(newX);
        setY(newY);
    }
}
