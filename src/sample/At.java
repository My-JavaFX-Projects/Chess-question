package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import static sample.Controller.TILE_SIZE;

public class At extends StackPane {
    private static int counthorses;

    public int atX, atY;
    public int atOldX, atOldY;
       public At(int x, int  y) {
           Image at = new Image("at.png");
           ImageView imageView = new ImageView(at);
           imageView.setFitWidth(TILE_SIZE);
           imageView.setFitHeight(TILE_SIZE);
           relocate(x*TILE_SIZE,y*TILE_SIZE);
           getChildren().addAll(imageView);
           counthorses++;

           this.atX=x;
           this.atY=y;

           }
           public int getAtX(){
           return atX;
           }
           public void Atsany(){
               System.out.println("at sany"+counthorses);
           }

           public int getAtY(){
           return atY;
           }
}
