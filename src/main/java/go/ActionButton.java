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

    public ActionButton(int x, int y){
        super();
        init(x, y, 128, 32, "button_fight.png", "button_fight_active.png");
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
        //TODO: somehow update movement here, not in getInput
    }

    public void getInput(){
        if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
            if(isActive){
                deactivate();
            }else{
                activate();
            }
        }
    }

    //TODO: moving with pixel independent speed
    private void activate(){
        sprite = activeSprite;
        isActive = true;
    }

    private void deactivate(){
        sprite = inactiveSprite;
        isActive = false;
    }
}
