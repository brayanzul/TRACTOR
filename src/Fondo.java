
import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class Fondo {
    
    //OBJETO SE LA CLASE JUEGO
    Juego jueguito;
    //VARIABLES DEL TAMAÑO DEL FONDO
    int anchoFondo=1300;
    int altoFondo=400;
    //COORDENADAS INICIALES PARA MOVER EL FONDO
    int x1=1300;
    int y1=0;
    //COORDENADAS AUXILIARES QUE MUEVE OTRO FONDO
    int x2=0;
    int y2=0;
    
    public Fondo(Juego jueguito){
        this.jueguito=jueguito;
    }
    
    public void mover(){
        x1-=2;
        x2-=2;
        if(x1==0 && x2==-1300){
            x1=1300;
            x2=0;
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/multimedia/fondo.jpg"));
        g.drawImage(imagenFondo.getImage(),x1,y1,anchoFondo,altoFondo,null);
        g.drawImage(imagenFondo.getImage(),x2,y2,anchoFondo,altoFondo,null);
    }
    
}
