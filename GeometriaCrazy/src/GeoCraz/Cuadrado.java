package GeoCraz;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cuadrado {
    
    JLabel cuadrado1;
    Random posicion = new Random();
    String cuadrado = "C:\\GeometryCrazy\\CuadradoAzul.png";
    int ancho = 40, alto = 40;
    int posX = posicion.nextInt(450), posY = 130;
                
    public Cuadrado(){
        posX = posicion.nextInt(450);
        posY = 130;
        PintarCuad();
    }
    

    
    public void PintarCuad(){
        cuadrado1 = new JLabel();
        ImageIcon imgcirc = new ImageIcon(cuadrado);
        cuadrado1.setIcon(new ImageIcon(imgcirc.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        cuadrado1.setBounds(posX,posY,ancho,alto);
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
