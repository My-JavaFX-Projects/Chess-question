package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Controller extends Application {
    public static final int TILE_SIZE=80;
    public static final int WIDTH=8;
    public static final int HEIGHT=8;
    int x=4;
    int y=4;
    private Group tileGroup=new Group();
    private Group atGroup=new Group();
    private int[][] atynKoordinatlary=new int[HEIGHT][WIDTH];
    Button button=new Button("Ileri Hamle");





    private Parent creatContent(){
        Pane root= new Pane();
        root.setPrefSize(WIDTH*TILE_SIZE+200,HEIGHT*TILE_SIZE);
        At at = atyGoy(4, 4);

        root.getChildren().addAll(tileGroup,at,atGroup);
        for (int y=0;  y<HEIGHT;y++){
            for (int x=0; x<WIDTH;x++){
                Tile tile=new Tile((x+y)%2==0,x,y);
                tileGroup.getChildren().add(tile);

            }
        }


        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane ui=new BorderPane();
        ui.setPrefSize(WIDTH*TILE_SIZE+200,HEIGHT*TILE_SIZE);
        ui.setRight(button);


        BorderPane.setAlignment(button, Pos.CENTER_LEFT);

        button.setOnAction(e->{
            //tile.setAt(at);
               At at = atyGoy(x, y);
               At at2 = atyGoy(x+2, y-1);
               At at3 = atyGoy(x+2, y+1);
               At at4 = atyGoy(x+1, y+2);
               At at5 = atyGoy(x+1, y-2);
               At at6 = atyGoy(x-2, y-1);
               At at7 = atyGoy(x-2, y+1);
               At at8 = atyGoy(x-1, y-2);
               At at9 = atyGoy(x-1, y+2);



               atGroup.getChildren().addAll(at,at2,at3,at4,at5,at6,at7,at8,at9);

               x=x+1;
               y=y-2;




        });



        ui.getChildren().addAll(creatContent());
        Scene scene = new Scene(ui);
        primaryStage.setTitle("At Satranc sorusu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private At atyGoy( int x,int y){
    At at=new At(x,y);

    return at;

    }

}
