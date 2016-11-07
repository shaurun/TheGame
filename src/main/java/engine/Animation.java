package engine;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glDisable;

/**
 * Created by Shaurun on 20.02.2016.
 */
public class Animation extends TexturedSprite {
    //private List<Frame> frames;
    private float curFrame;
    private float timing;
    private float framecount;
    private long previousTime = System.nanoTime();

    public Animation(float sizeX, float sizeY, String resourceFile, int frameCount, float timing) {
        super(sizeX, sizeY, resourceFile);
        curFrame = 0;
        this.framecount = frameCount;
        this.timing = timing;
    }

    @Override
    public void render(){
        glEnable(GL_TEXTURE_2D);
        texture.bind();
        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, curFrame/framecount); // top left 0/2
            glVertex2f(0, getSizeY());

            glTexCoord2f(0, (curFrame+1)/framecount); // bottom left 1/2
            glVertex2f(0, 0);

            glTexCoord2f(1, (curFrame+1)/framecount); // bottom right 1/2
            glVertex2f(getSizeX(), 0);

            glTexCoord2f(1, curFrame/framecount); // top right 0/2
            glVertex2f(getSizeX(), getSizeY());
        }
        glEnd();
        glDisable(GL_TEXTURE_2D);

        //TODO save logif independant
        if((System.nanoTime()-previousTime)/1000000 > timing){
            if(++curFrame == framecount){
                curFrame = 0;
            }
            previousTime = System.nanoTime();
        }
    }
}
