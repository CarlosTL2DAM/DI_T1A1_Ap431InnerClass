package DI_T1A1_431InnerClass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class ControlCircle extends Application {

    Circle circulo;

    @Override
    public void start(Stage primaryStage) {
        //Creamos el nodo principal en este caso será un Pane
        Pane root = new Pane();
        //Creamos el circulo y lo ajustamos al centro, ponemos borde negro y color interno blanco
        circulo = new Circle();
        circulo.setRadius(25);
        circulo.centerXProperty().bind(root.widthProperty().divide(2));
        circulo.centerYProperty().bind(root.heightProperty().divide(2));
        circulo.setStroke(Color.BLACK);
        circulo.setFill(Color.WHITE);

        //Hacemos que el circulo se añada en el root (Pane)
        root.getChildren().add(circulo);

        //Creamos un boton que sirva para disminuir
        Button btnDisminuir = new Button("Shrink");
        btnDisminuir.setLayoutX(100);
        btnDisminuir.setLayoutY(250);
        btnDisminuir.setOnAction(new ButtonEventDisminuir());

        //Añadimos el botón
        root.getChildren().add(btnDisminuir);

        //Creamos un botoón que sirva para agrandar
        Button btnAgrandar = new Button("Enlarge");
        btnAgrandar.setLayoutX(250);
        btnAgrandar.setLayoutY(250);
        btnAgrandar.setOnAction(new ButtonEventAgrandar());

        //Añadimos el botón
        root.getChildren().add(btnAgrandar);

        //Creamos la escena, la enlazamos con primaryStage y añadimos titulo
        Scene scene1 = new Scene(root, 400, 300);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Ejercicio 4.3.1");

        //Mostramos la primaryStage
        primaryStage.show();
    }

    class ButtonEventAgrandar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent evento) {
            Agrandar(circulo);
        }
    }

    class ButtonEventDisminuir implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent evento) {
            Disminuir(circulo);
        }

    }

    //Metodo Agrandar
    public void Agrandar(Circle circulo) {
        circulo.setRadius(circulo.getRadius() * 2);
    }

    //Metodo Disminuir
    public void Disminuir(Circle circulo) {
        circulo.setRadius(circulo.getRadius() / 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
