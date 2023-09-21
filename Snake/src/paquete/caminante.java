/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class caminante implements Runnable{
    
    PanelSnake panel;
    boolean estado= true;

    public caminante(PanelSnake panel){
        this.panel=panel;
    }
    @Override
    public void run() {
        while(estado){
        panel.avanzar();
        panel.repaint();
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(caminante.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       }
       
    } 
    public void parar(){
           this.estado=false;
       }
    
}
