package engine;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {
    private float r;
    private float g;
    private float b;

    private float sizeX;
    private float sizeY;

    public Sprite(float r, float g, float b, float sizeX, float sizeY){
        this.r = r;
        this.g = g;
        this.b = b;
        setSizeX(sizeX);
        setSizeY(sizeY);
    }

    public float getSizeX() {
        return sizeX;
    }

    public void setSizeX(float sizeX) {
        this.sizeX = sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }

    public void setSizeY(float sizeY) {
        this.sizeY = sizeY;
    }

    public void render(){
        glBegin(GL_QUADS);
        {
            glColor3f(r, g, b);
            glVertex2f(0,0);
            glVertex2f(0, sizeY);
            glVertex2f(sizeX, sizeY);
            glVertex2f(sizeX, 0);
        }
        glEnd();
    }
}
