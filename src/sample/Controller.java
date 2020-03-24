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


    private Group tileGroup=new Group();
    private Group atGroup=new Group();
    public int[] atynKoordinatlaryX=new int[HEIGHT*WIDTH];
    public int[] atynKoordinatlaryY=new int[HEIGHT*WIDTH];
    public int[] atynKoneKoordinatyX=new int[HEIGHT*WIDTH];
    public int[] atynKoneKoordinatyY=new int[HEIGHT*WIDTH];


    Button button=new Button("Ileri Hamle");
    Button button2= new Button("Aty Yerleshtir");






    private Parent creatContent(){
        Pane root= new Pane();
        root.setPrefSize(WIDTH*TILE_SIZE+200,HEIGHT*TILE_SIZE);

        root.getChildren().addAll(tileGroup,atGroup);
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
        HBox buttons=new HBox();
        buttons.getChildren().addAll(button2,button);
        ui.setRight(buttons);


        button2.setOnAction(e->{
            At at = atyGoy(0, 7);
            atynKoordinatlaryX[0]=at.getAtX();
            atynKoordinatlaryY[0]=at.getAtY();
            atGroup.getChildren().add(at);
            System.out.print(atynKoordinatlaryX[0]);
            System.out.print(",");
            System.out.println(atynKoordinatlaryY[0]);
        });


         int[] atXHereketi={1,1,2,2,-1,-1,-2,-2};
         int[] atYHereketi={2,-2,1,-1,2,-2,1,-1};

        button.setOnAction(e->{
            int m=0;
            for (int j=0; j<3; j++) {
                for (int i=0; i<8; i++){
                    int a=atynKoordinatlaryX[j];
                    int b=atynKoordinatlaryY[j];
                    if (a!=0 || b!=0) {
                        int x = atynKoordinatlaryX[j] + atXHereketi[i];
                        int y = atynKoordinatlaryY[j] + atYHereketi[i];
                        if (x < 8 && x >= 0 && y < 8 && y >= 0) {
                            At at = atyGoy(x, y);
                            atGroup.getChildren().add(at);
                            System.out.println(x+" "+y);
                            atynKoneKoordinatyX[m]=x;
                            atynKoneKoordinatyY[m]=y;
                            m++;

                        }
                    }

                   }
            }

            for (int j=0; j<3; j++) {
                atynKoordinatlaryX[j]=atynKoneKoordinatyX[j];
                atynKoordinatlaryY[j]=atynKoneKoordinatyY[j];

            }
            for (int j=0; j<3; j++){
                System.out.println(atynKoneKoordinatyX[j]+" "+atynKoneKoordinatyY[j]);
            }

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
