
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class Auto {
    //objeto de la clase juego
    Juego juguito;
    //variables que nos ayuda a saber si el auto salta
    static boolean saltando=false;
    boolean sube=false;
    boolean baja=false;
    //VARIABLES QUE DELIMITAN EL AREA DEL OBJETO
    Area llantaDelantera, llantaTrasera, carroceria, tractor;
    //VARIABLES DE TAMAÑO DEL PERSONAJE
    int anchoPersonaje=112;
    int altoPersonaje=78;
    //COORDENADAS INICIALES DE PERSONAJE
    static int x_inicial=50;
    static int y_inicial=270;
    //COORDENADAS PARA MANIPULAR DE PERSONAJE
    int x_auxiliar=0;
    int y_auxiliar=0;
    
    
    public Auto(Juego jueguito){
        this.juguito=jueguito;
    }
    
    public void mover(){
        if(x_inicial+x_auxiliar>0 && x_inicial+x_auxiliar<juguito.getWidth()-anchoPersonaje){
            x_inicial+=x_auxiliar;
        }
        if(saltando){
            if(y_inicial==270){//SI EL AUTO ESTA EN EL SUELO
                sube=true;
                y_auxiliar=-2;
                baja=false;
            }
            if(y_inicial==150){//SI EL AUTOLLEGO AL LIMITE DEL SALTO
                baja=true;
                y_auxiliar=2;
                sube=false;
            }
            
            if(sube){
               y_inicial+=y_auxiliar; 
            }
            if(baja){
               y_inicial+=y_auxiliar;
               if(y_inicial==270){//SI EL AUTO LLEGO AL SUELO
                   saltando=false;
               }
            }
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon auto=new ImageIcon(getClass().getResource("/multimedia/tractor.png"));
        g.drawImage(auto.getImage(), x_inicial,y_inicial,anchoPersonaje,altoPersonaje,null);
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            saltando=true;
        }
    }
    
    public Area getBounds(){
        Rectangle forma1=new Rectangle(x_inicial,y_inicial,95,62);
        carroceria=new Area(forma1);
        
        Ellipse2D forma2=new Ellipse2D.Double(x_inicial,y_inicial+28,48,48);
        llantaTrasera=new Area(forma2);
        
        Ellipse2D forma3=new Ellipse2D.Double(x_inicial+73,y_inicial+39,38,38); 
        llantaDelantera=new Area(forma3);
        
        tractor=carroceria;
        tractor.add(carroceria);
        tractor.add(llantaTrasera);
        tractor.add(llantaDelantera);
        
        return tractor;
    }
    
}
