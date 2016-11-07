package go;

import engine.GameObject;
import engine.Sprite;
import engine.TexturedSprite;
import engine.enums.Direction;
import org.lwjgl.input.Keyboard;
import windows.Game;

import java.util.List;

import static engine.enums.Direction.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Shaurun on 05.11.2016.
 */
public class ActionButton extends GameObject {
    Sprite inactiveSprite;
    Sprite activeSprite;
    boolean isActive;

    public ActionButton(float x, float y, String actionName){
        super();
        init(x, y, 128, 32, "button_"+actionName+".png", "button_"+actionName+"_active.png");
    }

    protected void init(float x, float y, float sizeX, float sizeY, String inactiveSpriteFile, String activeSpriteFile){
        this.setX(x);
        this.setY(y);
        inactiveSprite = new TexturedSprite(sizeX, sizeY, inactiveSpriteFile);
        activeSprite = new TexturedSprite(sizeX, sizeY, activeSpriteFile);
        isActive = false;
        sprite = inactiveSprite;
    }

    @Override
    public void update(){
    }

    public void activate(){
        sprite = activeSprite;
        isActive = true;
    }

    public void deactivate(){
        sprite = inactiveSprite;
        isActive = false;
    }
}
