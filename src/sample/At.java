package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import static sample.Controller.TILE_SIZE;

public class At extends StackPane {
    private static int counthorses;

    public   int atX, atY;
    public int atOldX, atOldY;
       public At(int atX, int  atY) {
           Image at = new Image("knightb.gif",TILE_SIZE,TILE_SIZE,false,false);
           ImageView imageView = new ImageView(at);


           relocate(atX*TILE_SIZE,atY*TILE_SIZE);
           getChildren().addAll(imageView);
           counthorses++;

           this.atX=atX;
           this.atY=atY;

           }
           public  int getAtX(){
           return atX;
           }
           public int getAtY(){
           return atY;
           }
}
