package go;

import engine.GameObject;
import engine.TexturedSprite;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import windows.Game;

import java.util.ArrayList;
import java.util.List;

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
        //this.sprite = new Sprite(r, g, b, sizeX, sizeY);
        sprite = new TexturedSprite(sizeX, sizeY, spriteFile);
    }

    @Override
    public void render(){
        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            sprite.render();
        }
        glPopMatrix();
    }

    @Override
    public void update(){
        float newX = x+moveAmountX;
        float newY = y+moveAmountY;

        moveAmountX = 0;
        moveAmountY = 0;

        //List<GameObject> objects = Game.rectangleCollide(newX, newY, newX + SIZE, newY + SIZE);

        boolean move = true;

        List<GameObject> objects = Game.rectangleCollide(newX, newY, newX + SIZE, newY + SIZE);

        for (GameObject go : objects){
            if (go.getSolid()){
                move = false;
            }
        }


        if (!move) {
            return;
        }

        x = newX;
        y = newY;
    }

    public void getInput(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            move(0, 1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            move(0, -1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            move(-1, 0);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            move(1, 0);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_A)){
            move(-1, 1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_D)){
            move(1, 1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_A)){
            move(-1, -1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_D)){
            move(1, -1);
        }
    }

    private void move(float magX, float magY){
       /* if ((int)magX == 0 && (int)magY == 1){
            facingDirection = Direction.FORWARD;
        }
        if ((int)magX == 0 && (int)magY == -1){
            facingDirection = Direction.BACKWARD;
        }
        if ((int)magX == -1 && (int)magY == 0){
            facingDirection = Direction.LEFT_SIDE;
        }
        if ((int)magX == 1 && (int)magY == 0){
            facingDirection = Direction.RIGHT_SIDE;
        }*/


        //TODO: add speed based scaling
        //x += 4f*magX * Time.getDelta(); //magnitude
        //y += 4f*magY * Time.getDelta();

        moveAmountX = 4f*magX /** Time.getDelta()*/;
        moveAmountY = 4f*magY /** Time.getDelta()*/;
    }

}
