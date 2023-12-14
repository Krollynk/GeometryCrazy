
package GeoCraz;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ventana extends JFrame implements ActionListener
{
    
    JPanel panel;
    JLabel fondo;
    JLabel barra;
    JLabel estadistica;
    JLabel corazon1;
    JLabel corazon2;
    JLabel corazon3;
    int ancho =500, alto = 750;
    int arribajo = (alto-95);
    int izqder = (ancho/2)-50;
    int op = 1, contador =0, contador2 = 0, contador3=0;
    int estadoBarra=2,estadoFigura = 2;
    int punto = 0, nivel = 1;
    int circulos = 0, cuadrados = 0, triangulos = 0;
    String BRoja = "C:\\GeometryCrazy\\BarraRoja.png";
    String BAzul = "C:\\GeometryCrazy\\BarraAzul.png";
    String BAmarilla = "C:\\GeometryCrazy\\BarraAmarilla.png";
    String cora1 = "C:\\GeometryCrazy\\vidas.png";
    String cora2 = "C:\\GeometryCrazy\\vidas.png";
    String cora3 = "C:\\GeometryCrazy\\vidas.png";
    //String barra4 = "C:\\Users\\usuario\\Desktop\\Videojuego Java\\barra4.png";
    Timer timer = new Timer(1,this);
    Circulo circ = new Circulo();
    Cuadrado cuad = new Cuadrado();
    Triangulo trian = new Triangulo();
                
    public ventana(){
        setSize(ancho,alto);
        setTitle("Juego Qliao");
        setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciandocomponentes();
        timer.start();
    }
    
    public void Panel()
    {
        panel = new JPanel();
        //panel.setBackground(Color.red);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    public void ImagenDeFondo()
    {
        fondo = new JLabel();
        ImageIcon fondopanel = new ImageIcon("C:\\GeometryCrazy\\Fondo1.jpg");
        fondo.setBounds(0,60,ancho,alto-100);
        fondo.setIcon(new ImageIcon(fondopanel.getImage().getScaledInstance(ancho, alto-100, Image.SCALE_SMOOTH)));
    }
    
    public void Barras()
    {
        barra = new JLabel();
        barra.setIcon(new ImageIcon(BRoja));
        barra.setBounds(izqder, arribajo, 150, 50);
        
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
    }
    
    public void Estadisticas()
    {

        estadistica = new JLabel();
        estadistica.setText("Puntos: " +punto+   "   Circulos: " + circulos + "   Cuadrados: " +cuadrados+ "     Triangulos: " + triangulos + "       Nivel: " +  nivel);
        estadistica.setBounds(0,0,500,60);
        estadistica.setForeground(Color.CYAN);
        estadistica.setBackground(Color.BLACK);
        estadistica.setOpaque(true);
    }
    
    public void Niveles()
    {
        if(punto>=3)
        {
            nivel+=1;
            punto = 0;
            estadistica.setText("Puntos: " +punto+   "   Circulos: " + circulos + "   Cuadrados: " +cuadrados + "     Triangulos: " + triangulos + "   Nivel: " +  nivel);
        }
    }
    
    public void corazones()
    {
        
    }
    
    public void iniciandocomponentes(){
        
        Panel();
        ImagenDeFondo();
        Niveles();
        Barras();
        Estadisticas();
        corazones();
        panel.add(cuad.cuadrado1);
        panel.add(trian.figura);
        panel.add(circ.circulo1);
        panel.add(estadistica);
        panel.add(barra);
        panel.add(fondo);
    }
    
    private void formKeyPressed(KeyEvent evt)
    {
        
        
        if (evt.getKeyChar() == 'q')
        {
            barra.setIcon(new ImageIcon(BRoja));
            estadoBarra = 2;
        }else
        if (evt.getKeyChar() == 'w')
        {
            barra.setIcon(new ImageIcon(BAmarilla));
            estadoBarra = 1;
        }else
        if (evt.getKeyChar() == 'e')
        {
            barra.setIcon(new ImageIcon(BAzul));
            estadoBarra = 0;
        }
        
        
        
        if (evt.getKeyChar() == 'a' && izqder >= 0)
        {
            izqder = izqder - 10;
            barra.setLocation(izqder, arribajo);
        }else
        if (evt.getKeyChar() == 'd' && izqder <= 332)
        {
            izqder = izqder +10;
            barra.setLocation(izqder, arribajo);
        }
    }
    
   
    public void actionPerformed(ActionEvent e)
    {
        
        if(trian.DevolverY()<=alto+100 && cuad.DevolverY()<=alto+100 && circ.DevolverY()<=alto+100)
        {
            //movimiento triangulo
            //Estadisticas();
            if(trian.DevolverY()==arribajo-40 && trian.DevolverX()>=izqder-50 && trian.DevolverX()<=izqder+150)
            {
                trian.figura.setVisible(false);
                trian.RecibirValores(-trian.DevolverX(), -trian.DevolverY());
                trian.RecibirValores((int)(Math.random()*450), 60);
                estadoFigura=1;
                Niveles();
                if(estadoBarra==estadoFigura)
                {
                    estadistica.setVisible(false);
                    punto= punto +1;
                    triangulos= triangulos+1;
                    estadistica.setText("Puntos: " +punto+   "     Circulos: " + circulos + "     Cuadrados: " +cuadrados + "     Triangulos: " + triangulos + "       Nivel: " +  nivel);
                    estadistica.setVisible(true);
                    
                }
                trian.figura.setVisible(true);
            }
            if(trian.DevolverY()==arribajo && trian.DevolverX()!=izqder)
            {
                trian.figura.setVisible(false);
                trian.RecibirValores(-trian.DevolverX(), -trian.DevolverY());
                trian.RecibirValores((int)(Math.random()*450), 60);
                trian.figura.setVisible(true);
            }
            else{
                contador++;
                if(contador==13)
                {
                    trian.RecibirValores(0, 5);
                    trian.figura.setLocation(trian.DevolverX(),trian.DevolverY());
                    contador=0;
                }
                
            }
            
            //movimiento cuadrado
            
            if(cuad.DevolverY()==arribajo-40 && cuad.DevolverX()>=izqder-50 && cuad.DevolverX()<=izqder+150)
            {
                
                cuad.cuadrado1.setVisible(false);
                cuad.RecibirValores(-cuad.DevolverX(), -cuad.DevolverY());
                cuad.RecibirValores((int)(Math.random()*450), 60);
                estadoFigura=0;
                Niveles();
                if(estadoBarra==estadoFigura)
                {
                    estadistica.setVisible(false);
                    punto = punto +1;
                    cuadrados = cuadrados + 1;
                    estadistica.setText("Puntos: " +punto+   "     Circulos: " + circulos + "     Cuadrados: " +cuadrados + "     Triangulos: " + triangulos + "       Nivel: " +  nivel);
                    estadistica.setVisible(true);
                    //Estadisticas();
                }
                cuad.cuadrado1.setVisible(true);
            }
            if(cuad.DevolverY()==arribajo && cuad.DevolverX()!=izqder)
            {
                cuad.cuadrado1.setVisible(false);
                cuad.RecibirValores(-cuad.DevolverX(), -cuad.DevolverY());
                cuad.RecibirValores((int)(Math.random()*450), 60);
                
                cuad.cuadrado1.setVisible(true);
            }
            else{
                contador2++;
                if(contador2==20)
                {
                    cuad.RecibirValores(0, 5);
                    cuad.cuadrado1.setLocation(cuad.DevolverX(),cuad.DevolverY());
                    contador2=0;
                }
                
            }
            
            
            //movimiento circulo
            
            if(circ.DevolverY()==arribajo-40 && circ.DevolverX()>=izqder-50 && circ.DevolverX()<=izqder+150)
            {
                circ.circulo1.setVisible(false);
                circ.RecibirValores(-circ.DevolverX(), -circ.DevolverY());
                circ.RecibirValores((int)(Math.random()*450), 60);
                estadoFigura = 2;
                Niveles();
                if(estadoBarra==estadoFigura)
                {
                    estadistica.setVisible(false);
                    punto = punto + 1;
                    circulos++;
                    estadistica.setText("Puntos: " +punto+   "     Circulos: " + circulos + "     Cuadrados: " +cuadrados + "     Triangulos: " + triangulos + "       Nivel: " +  nivel);
                    estadistica.setVisible(true);
                    //Estadisticas();
                }else
                {
                    
                }
                circ.circulo1.setVisible(true);
            }
            if(circ.DevolverY()==arribajo && circ.DevolverX()!=izqder)
            {
                circ.circulo1.setVisible(false);
                circ.RecibirValores(-circ.DevolverX(), -circ.DevolverY());
                circ.RecibirValores((int)(Math.random()*450), 60);
                circ.circulo1.setVisible(true);
            }
            else{
                contador3++;
                if(contador3==10)
                {
                    circ.RecibirValores(0, 5);
                    circ.circulo1.setLocation(circ.DevolverX(),circ.DevolverY());
                    contador3=0;
                }
                
            }
            
            
            
        }
    }
    
    
}
