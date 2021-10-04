package DI_T1A1_431InnerClass;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class ButtonEvent implements EventHandler<ActionEvent> {
    //Atributos
    Button btnAgrandar;
    Button btnDisminuir;
    Circle circulo;
    
    //Constructor
    public ButtonEvent(Circle circulo, Button btnDisminuir, Button btnAgrandar)
    {
        this.btnAgrandar = btnAgrandar;
        this.btnDisminuir = btnDisminuir;
        this.circulo = circulo;
    }
    
    @Override
    public void handle(ActionEvent evento) {
        Object source = evento.getSource();
        if(source == btnAgrandar)
        {
            circulo.setRadius(circulo.getRadius()*2);
        }
        else if (source == btnDisminuir)
        {
            circulo.setRadius(circulo.getRadius()/2);
        }
        else
        {
            System.out.println("ERROR. Evento activado erroneamente");
        }
    }
    
}
