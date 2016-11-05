package engine.enums;

public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT,
    NONE;

    public Direction revert(){
        switch (this){
            case UP: return DOWN;
            case DOWN: return UP;
            case RIGHT: return LEFT;
            case LEFT: return RIGHT;
            default: return NONE;
        }
    }
}
