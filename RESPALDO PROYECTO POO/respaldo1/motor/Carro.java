package motor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carro {
    private int x,y;
    private int nColor;
    private boolean bVisible;
    private int dx,dy;
    private boolean bObstaculo;
    private static boolean stop;
    private Random r;
    private JLabel imagen = new JLabel();
    private BufferedImage imagen1;

    public static boolean getStop() {
        return stop;
    }

    public static void setStop(boolean stop) {
        Carro.stop = stop;
    }
    
    

    public Carro (boolean obstaculo, Random r){
        
        
        if(!this.bObstaculo){
            try {
                
                imagen1 = ImageIO.read(getClass().getResourceAsStream("carrocaro.png"));
               
            } catch (IOException ex) {
                Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.bObstaculo=obstaculo;
        this.r=r;
    }

    public Image getImagen() {
        return imagen1;
    }
    
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return nColor;
    }

    public boolean getVisible() {
        return bVisible;
    }

    public void mostrarCarro(int color){
        bVisible=true;
        nColor=color;
        y=-20;
        x=6+((r.nextInt(3)+1)*20);
    }

    public void ocultarCarro(){
        bVisible=false;
    }

    public void moverComputador(){
        if(bVisible){
            mover(dx,1);
            if(y>100){
                ocultarCarro();
                

            }
        }
    }

    public void setXY(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void mover(int dx, float dy) {
        
        y += dy;
       
        if (!bObstaculo) {
            
            y += dy;
            x += dx;
            
            //LIMITACION DE MOVIMIENTO DEL VEHICULO PROPIO
            if (y < 10) {
                y = 10;
            }
            if (y > 70) {
                y = 70;
            }
            
            if (x < 20) {
                x = 20;
            }

            if (x > 70) {
                x = 70;
            }
        } else {
            x += dx;
            if (x < 20) {
                x = 20;
                this.dx = -this.dx;
            }

            if (x > 70) {
                x = 70;
                this.dx = -this.dx;
            }

            y += this.dy;
        }
    }

    public boolean hayChoque(int x2, int y2){
        
        if (x+1>x2+10) return false;
        if (x2+1>x+10) return false;
        if (y+1>y2+16) return false;
        if (y2+1>y+16) return false;
        System.out.println("Choco!");
        Carro.setStop(true);
        return true;
    }
        
    
    
    /*public void moverAutoPropio(){
        if(!bObstaculo){
            //LIMITACION DE MOVIMIENTO DEL VEHICULO PROPIO
            if(y<10){
                y=10;
            }
            if(y>70){
                y=70;
            }
        }
    }*/

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setbVisible(boolean bVisible) {
        this.bVisible = bVisible;
    }
    
    

}
