/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelSnake  extends JPanel {
    //variables para el color 
    Color colosnake=Color.blue;
    Color colorcomida=Color.red;
    int tammax,tam,can,res;
    List<int[]> snake=new ArrayList<>();//lista
    int[] comida=new int[2];//arreglo
    String direccion="de";
    String dirreccionproxima="de";
 //se crea un nuevo hilo 
    
    Thread hilo;
    caminante camino;
     
    //crea constructor 
    public PanelSnake(int tammax, int can){
 
        this.tammax=tammax;
        this.can=can;
        this.tam=tammax/can;
        this.res=tammax%can;
        //serpiente base
        int[] a={can/2-1,can/2-1};
        int[] b={can/2,can/2-1};
         snake.add(a);
         snake.add(b);
         generarComida();
         
   
         camino=new caminante(this);
         hilo= new Thread(camino);
         hilo.start();
    }
   
 
  
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);//la imagen va cambiando
        pintor.setColor(colosnake);
       
        
        for (int i=0; i < snake.size(); i++){
            pintor.fillRect(res/2+snake.get(i)[0]*tam,res/2+snake.get(i)[1]*tam, tam-1, tam-1); 
        }
     
         //pinta serpiente
        for(int[] par:snake){
              pintor.fillRect(res/2+par[0]*tam,res/2+par[1]*tam, tam-1, tam-1); 
        }
        
        //pinta comida
        pintor.setColor(colorcomida);
        pintor.fillRect(res/2+comida[0]*tam,res/2+comida[1]*tam, tam-1, tam-1); ;
        
        
    }
    
    public void avanzar(){
        igualdir();
        int[] ultimo = snake.get(snake.size()-1);
        int agregarx=0;
        int agregary=0;
        switch(direccion){
             case"de":agregarx=1;break;
            //derecha
             case"iz":agregarx=-1;break;
            //izquierda
             case"ar":agregary=-1;break;
            //arriba
             case"ab":agregary=1;break;
            //abajo
                    
        }
        //cuadro ordenado para que no siga derecho la culebra 
        int[] nuevo= {Math.floorMod(ultimo[0]+agregarx,can) , //numero positivos la  funcion math
            Math.floorMod(ultimo[1]+agregary,can)};
        boolean existe= false;
        for(int i = 0; i < snake.size(); i++){  
          if(nuevo[0]==snake.get(i)[0]&&nuevo[1]==snake.get(i)[1]){
           existe= true;
           break;
          }
        }
        if(existe){
        JOptionPane.showMessageDialog(this,"has perdido");
        }else{
            // que haya o que no haya comida
            if(nuevo[0]==comida[0]&&nuevo[1]==comida[1]){
            snake.add(nuevo);  
            generarComida();
            }else{
                 //se agrega a la lista
             snake.add(nuevo);
             snake.remove(0);
            }
        }
       
    }

    public void generarComida(){
        boolean existe=false;
        int a =(int)(Math.random()*can);//el valor se puede convertir a entero multiplicandolo  y se castea entre 0 hasta el 9.9 CAN
        int b =(int)(Math.random()*can);
        for(int[] par:snake){   //condicional
            if(par[0]== a&&par[1]==b){
                existe = true;
                generarComida();
                break;
            }
         }
        if(!existe){
            this.comida[0]=a;
            this.comida[1]=b;
        }  
    }

  public void cambiardireccion(String dir){
      if((this.direccion.equals("de")|| this.direccion.equals("iz"))&&(dir.equals("ar")||dir.equals("ab"))){
           this.dirreccionproxima=dir;   
      }
       if((this.direccion.equals("ar")|| this.direccion.equals("ab"))&&(dir.equals("iz")||dir.equals("de"))){
           this.dirreccionproxima=dir;   
      }
      
  }
   public void igualdir(){
     this.direccion=this.dirreccionproxima;
    
    }

  }
