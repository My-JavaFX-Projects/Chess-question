package sample;
//Solved Betiiiiiyehuuuu
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;


public class Controller extends Application {
    public static final int TILE_SIZE=80;
    public static final int WIDTH=8;
    public static final int HEIGHT=8;


    private Group tileGroup=new Group();
    private Group atGroup=new Group();
    ArrayList<int[]> atynKordinatlary=new ArrayList<>();
    ArrayList<int[]> atynKoneKord=new ArrayList<>();
    Tile[][] board=new Tile[WIDTH][HEIGHT];



    Button button=new Button("Ileri Hamle");
    Button button2= new Button("Aty Yerleshtir");

    private Parent creatContent(){
        Pane root= new Pane();
        root.setPrefSize(WIDTH*TILE_SIZE+200,HEIGHT*TILE_SIZE);

        root.getChildren().addAll(tileGroup,atGroup);
        for (int y=0;  y<HEIGHT;y++){
            for (int x=0; x<WIDTH;x++){
                Tile tile=new Tile((x+y)%2==0,x,y);
                board[y][x]=tile;
                tileGroup.getChildren().add(tile);

            }
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane ui=new BorderPane();
        ui.setPrefSize(WIDTH*TILE_SIZE+200,HEIGHT*TILE_SIZE);
        HBox buttons=new HBox();
        buttons.getChildren().addAll(button2,button);
        ui.setRight(buttons);


        button2.setOnAction(e->{
            At at = atyGoy(0, 7);
            int[] atK={at.getAtX(),at.getAtY()};
            System.out.println(Arrays.toString(atK));
            atynKordinatlary.add(atK);
            atGroup.getChildren().add(at);
        }
        );

         int[] atXHereketi={1,1,2,2,-1,-1,-2,-2};
         int[] atYHereketi={2,-2,1,-1,2,-2,1,-1};

        button.setOnAction(e->{
            atGroup.getChildren().clear();

            for (int[] arrays:atynKordinatlary){
                allow:
                for (int i=0; i<atXHereketi.length; ++i){
                    int x= arrays[0]+atXHereketi[i];
                   int y=arrays[1]+atYHereketi[i];
                    int[] koneKordiant={x,y};

                     if (x<WIDTH&&x>=0&&y<HEIGHT&&y>=0) {
                         if (board[x][y].hasAt()) {
                             continue allow;
                         } else {

                             At at = atyGoy(x, y);
                             Tile tile = new Tile((x + y) % 2 == 0, x, y);
                             tile.setAt(at);
                             board[x][y] = tile;

                             atGroup.getChildren().add(at);
                             atynKoneKord.add(koneKordiant);
                         }
                     }
                   }
                }
                    for (int i=0; i<WIDTH;++i){
                        for (int j=0; j<HEIGHT; ++j){
                            board[i][j].setAt(null);
                        }
                    }
            System.out.println(atynKoneKord.size());
            atynKordinatlary.clear();
                atynKordinatlary.addAll(atynKoneKord);
                atynKoneKord.clear();



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
