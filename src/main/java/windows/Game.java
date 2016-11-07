package windows;

import engine.GameObject;
import engine.phisics.Phisics;
import go.ActionButton;
import go.Player;
import go.Wall;
import org.lwjgl.opengl.Display;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaurun on 01.10.2016.
 */
public class Game {
    private static Game game;
    private Player player;
    private ActionButton fight;

    private List<GameObject> objects;
    private List<GameObject> remove;

    private Game(){
        objects = new ArrayList<GameObject>();
        remove = new ArrayList<GameObject>();

        player = new Player(Display.getWidth()/2, Display.getHeight()/2);
        objects.add(player);

        fight = new ActionButton(100, 100);
        objects.add(fight);

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

    public void getInput(){
        player.getInput();
        fight.getInput();
    }

    public static List<GameObject> rectangleCollide(float x1, float y1, float x2, float y2) {
        ArrayList<GameObject> result = new ArrayList<GameObject>();

        float sizeX = Math.abs(x1 - x2);
        float sizeY = Math.abs(y1 - y2);

        Rectangle collider = new Rectangle((int)x1, (int)y1, (int)sizeX, (int)sizeY);

        for (GameObject go : game.getObjects()){
            if(Phisics.checkCollision(collider, go) != null){
                result.add(go);
            }
        }

        return result;
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}
