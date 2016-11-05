package engine.phisics;

import engine.GameObject;

import java.awt.*;

/**
 * Created by Shaurun on 20.02.2016.
 */
public class Phisics {

    /**
     * Returns true if two objects are colliding, false otherwise
     * @param go1
     * @param go2
     * @return
     */
    /*public static boolean checkCollision(GameObject go1, GameObject go2){
        Rectangle r1 = new Rectangle((int)go1.getX(), (int)go1.getY(), (int)go1.getSizeX(), (int)go1.getSizeY());
        Rectangle r2 = new Rectangle((int)go2.getX(), (int)go2.getY(), (int)go2.getSizeX(), (int)go2.getSizeY());

        return r1.intersects(r2);
    }*/

    public static GameObject checkCollision(GameObject go1, GameObject go2){
        Rectangle r = new Rectangle((int)go1.getX(), (int)go1.getY(), (int)go1.getSizeX(), (int)go1.getSizeY());

        return checkCollision(r, go2);
    }

    public static GameObject checkCollision(Rectangle r, GameObject go){
        Rectangle r2 = new Rectangle((int)go.getX(), (int)go.getY(), (int)go.getSizeX(), (int)go.getSizeY());

        return r.intersects(r2) ? go : null;
    }
}
