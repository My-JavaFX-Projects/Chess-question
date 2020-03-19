package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    private At at;
    public boolean hasAt(){
        return at!=null;
    }

    public At getAt() {

        return at;
    }

    public void setAt(At at) {
        this.at = at;
    }

    public Tile(boolean light, int x, int y){
        setWidth(Controller.TILE_SIZE);
        setHeight(Controller.TILE_SIZE);

        relocate(x*Controller.TILE_SIZE,y*Controller.TILE_SIZE);
        setFill(light ? Color.BROWN : Color.GRAY);

    }
}
