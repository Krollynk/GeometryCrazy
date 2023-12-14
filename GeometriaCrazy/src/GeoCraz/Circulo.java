package GeoCraz;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Circulo {
    JLabel circulo1;
    Random posicion = new Random();
    int ancho = 40, alto = 40;
    int posX = posicion.nextInt(450), posY = 60;
    int mov = 0;
                
    public Circulo(){
        posX = posicion.nextInt(450);
        posY = 60;
        PintarCirc();
    }
    
    public void PintarCirc(){
        circulo1 = new JLabel();
        ImageIcon imgcirc = new ImageIcon("C:\\GeometryCrazy\\CirculoRojo.png");
        circulo1.setIcon(new ImageIcon(imgcirc.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        circulo1.setBounds(posX,posY,ancho,alto);
    }
    
    public void RecibirValores(int x, int y){
        posX+=x;
        posY+=y;
    }
    public int DevolverX(){
        return posX;
    }
    public int DevolverY(){
        return posY;
    }
}
