package engine;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Shaurun on 22.02.2016.
 */
public class TexturedSprite extends Sprite{
    protected Texture texture;

    public TexturedSprite(float sizeX, float sizeY, String resourceFile) {
        super(0, 0, 0, sizeX, sizeY);
        try {
            texture = TextureLoader.getTexture("jpg", ResourceLoader.getResourceAsStream(resourceFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);}
        catch (IOException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }

    public void render(){
        Color.white.bind();
        glEnable(GL_BLEND);
        glEnable(GL_ALPHA_TEST);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glEnable(GL_TEXTURE_2D);
        texture.bind();

        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, 0); // top left
            glVertex2f(0, getSizeX());

            glTexCoord2f(0, 1); // bottom left
            glVertex2f(0, 0);

            glTexCoord2f(1, 1); // bottom right
            glVertex2f(getSizeX(), 0);

            glTexCoord2f(1, 0); // top right
            glVertex2f(getSizeX(), getSizeY());
        }
        glEnd();
        glDisable(GL_BLEND);
        glDisable(GL_ALPHA_TEST);
        glDisable(GL_TEXTURE_2D);
    }

}
