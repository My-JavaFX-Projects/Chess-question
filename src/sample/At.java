package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import static sample.Controller.TILE_SIZE;

public class At extends StackPane {


       public At(int x, int  y) {
           Image at = new Image("https://i.pinimg.com/originals/9a/54/09/9a5409d567eaf1a3020d8116a36f0984.jpg");
           ImageView imageView = new ImageView(at);
           imageView.setFitWidth(TILE_SIZE);
           imageView.setFitHeight(TILE_SIZE);
           relocate(x*TILE_SIZE,y*TILE_SIZE);
           getChildren().addAll(imageView);

           }
}
