package go;

import engine.GameObject;
import org.lwjgl.input.Keyboard;

/**
 * Created by Shaurun on 07.11.2016.
 */
public class ButtonStrip extends GameObject{
    private ActionButton[] buttons;
    private float sizeX;
    private float sizeY;
    int activePosition;

    public ButtonStrip(int x, int y){
        this.x = x;
        this.y = y;
        setSizeX(128*4+4);
        setSizeY(32);
        buttons = new ActionButton[] {
                new ActionButton(getX(), getY(), "fight"),
                new ActionButton(getX() + 0.25f * getSizeX(), getY(), "act"),
                new ActionButton(getX() + 0.50f * getSizeX(), getY(), "item"),
                new ActionButton(getX() + 0.75f * getSizeX(), getY(), "mercy")
        };
    }

    @Override
    public void setSizeX(float sizeX){
        this.sizeX = sizeX;
    }

    @Override
    public void setSizeY(float sizeY){
        this.sizeY = sizeY;
    }

    @Override
    public float getSizeX(){
        return sizeX;
    }

    @Override
    public float getSizeY(){
        return sizeY;
    }

    @Override
    public void render(){
        for(ActionButton button : buttons){
            button.render();
        }
    }

    @Override
    public void update(){
        for(ActionButton button : buttons){
            button.deactivate();
        }
        if(activePosition != -1){
            buttons[activePosition].activate();
        }
    }

    public void getInput(){
        while(Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
                if(Keyboard.getEventKeyState()) { //key is pressed
                next();
                }
            }

            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
                if (Keyboard.getEventKeyState()) { //key is pressed
                    previous();
                }
            }
        }
    }

    private void activate(){
        activePosition = 0;
    }

    private void deactivate(){
        activePosition = -1;
    }

    private void next(){
        if (activePosition == -1){
            return;
        }

        if(++activePosition == buttons.length){
            activePosition = 0;
        }
    }

    private void previous(){
        if (activePosition == -1){
            return;
        }

        if(--activePosition == -1){
            activePosition = buttons.length-1;
        }
    }
}
