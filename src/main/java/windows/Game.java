package windows;

import engine.GameObject;
import go.Wall;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaurun on 01.10.2016.
 */
public class Game {
    private static Game game;

    private List<GameObject> objects;
    private List<GameObject> remove;

    private Game(){
        objects = new ArrayList<GameObject>();
        remove = new ArrayList<GameObject>();

        objects.add(new Wall(Display.getWidth()/2-50, Display.getHeight()/2-50, 100, 1));
        objects.add(new Wall(Display.getWidth()/2-50, Display.getHeight()/2+50, 100, 1));
        objects.add(new Wall(Display.getWidth()/2-50, Display.getHeight()/2-50, 1, 100));
        objects.add(new Wall(Display.getWidth()/2+50, Display.getHeight()/2-50, 1, 100));
    }

    public static Game getInstance(){
        return game;
    }

    public static void init(){
        game = new Game();
    }

    public void update(){
        for (GameObject go : objects){
            if (!go.getRemove()) {
                go.update();
            } else {
                remove.add(go);
            }
        }

        for (GameObject go: remove){
            objects.remove(go);
        }

        remove.clear();
    }

    public void render(){
        for (GameObject go : objects){
            go.render();
        }
    }
}
