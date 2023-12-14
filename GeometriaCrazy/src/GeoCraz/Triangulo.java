/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeoCraz;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Triangulo {
    
    JLabel figura;
    Random posicion = new Random();
    Random estadofigura = new Random();
    String triangulo = "C:\\GeometryCrazy\\TrianguloAmarillo.png";
    int ancho = 40, alto = 40;
    int posX = posicion.nextInt(450), posY = 90;
    //int estado = posicion.nextInt(2);
                
    public Triangulo(){
        posX = posicion.nextInt(450);
        posY = 90;
        PintarTrian();
    }
    

    
    public void PintarTrian(){
        figura = new JLabel();
        ImageIcon imgtrian = new ImageIcon(triangulo);
        figura.setIcon(new ImageIcon(imgtrian.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        figura.setBounds(posX,posY,ancho,alto);
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
