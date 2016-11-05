import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import windows.Game;

import static org.lwjgl.opengl.GL11.*;

public class Main {

    public static void main(String[] args){
        //inits main window
        initDisplay(800, 600, "The Game");
        initGL();

        //init game
        Game.init();
        Game game = Game.getInstance();

        while(!Display.isCloseRequested()) {
            getInput();
            //render
            game.render();
            //display update
            Display.update();
            Display.sync(60); //synchronize display with 60 frames per second
            //game update
            game.update();

        }
        cleanUp();
    }

    /**
     * Initializes main window
     * @param width
     * @param height
     * @param title
     */
    private static void initDisplay(int width, int height, String title){
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle(title);
            Display.create();
            Keyboard.create();
            //Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes OpenGL canvas
     */
    private static void initGL(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);
        //glDisable(GL_DEPTH_TEST);
        //glClearColor(0, 0, 0, 0);
    }

    /**
     * Destroys all need to be destroyed. Frees resources.
     * Should be called when user exits game
     */
    private static void cleanUp(){
        Display.destroy();
    }

    private static void getInput(){
        Game.getInstance().getInput();
    }
}
