/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package paquete;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PanelFondo extends JPanel {
    //variables para el color 
    Color colofondo=Color.gray;
    //numeros enteneros lo que midel el pnale
    int tammax,tam,can,res;
     
    //crea constructor 
    public PanelFondo(int tammax, int can){
  
        this.tammax=tammax;
        this.can=can;
        //tamaño de los cuadros 
        this.tam=tammax/can;
        this.res=tammax%can;
    }
    //funcion paint lo que hace es que grafica 
 
  
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);//la imagen va cambiando se va rea gricando 
        pintor.setColor(colofondo);
        //Se dibujan los cuadros en y / x BUCLE anidado
        for( int i = 0; i < can; i++){
            for(int j = 0; j < can; j++){
                pintor.fillRect(res/2+i*tam,res/2+j*tam, tam-1, tam-1);
            }
        }
         
    }

 
}
