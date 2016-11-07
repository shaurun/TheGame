package engine;

import engine.enums.Direction;

import static org.lwjgl.opengl.GL11.*;

public abstract class GameObject {
    //object position
    protected float x; //0 is left side of the screen
    protected float y; //0 is bottom side of the screen
    //I can add redo it later, now I'll use Sprite instead
    //private Animation animation;
    protected Sprite sprite;

    protected boolean[] flags = new boolean[2];

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSizeX() {
        return sprite.getSizeX();
    }

    public void setSizeX(float sizeX) {
        sprite.setSizeX(sizeX);
    }

    public float getSizeY() {
        return sprite.getSizeY();
    }

    public void setSizeY(float sizeY) {
        sprite.setSizeY(sizeY);
    }

    public void update(){

    }

    public void render(){
        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            sprite.render();
        }
        glPopMatrix();
    }

    protected void init(float r, float g, float b, float x, float y, float sizeX, float sizeY){
        this.x = x;
        this.y = y;
        this.sprite = new Sprite(r, g, b, sizeX, sizeY);
    }

    public boolean getRemove(){
        return flags[0];
    }

    public boolean getSolid() { return flags[1]; }

    public void setSolid(boolean value){
        flags[1] = value;
    }

    public void remove(){
        flags[0] = true;
    }

    protected void onCollideWith(GameObject go, Direction from){
        switch (from){
            case UP: setY(go.getY()-getSizeY()-1); break;
            case DOWN: setY(go.getY()+go.getSizeY()+1); break;
            case RIGHT: setX(go.getX()-getSizeX()-1); break;
            case LEFT: setX(go.getX()+go.getSizeX()+1); break;
        }
    }
}
