/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author rau3
 */
public class TimeListener implements ActionListener, KeyListener{
    
    ModeloAutos mo;
    int velx=0;
    float vely=0;
    
    public TimeListener(ModeloAutos mo){
        this.mo = mo;
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        
        mo.moverCarroPropio(velx,vely);
        //mo.detectarChoque();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*int code = e.getKeyCode();
        if(code == KeyEvent.VK_E){
            mo.empezarPartida();
        }*/
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
                up();
                break;
            case KeyEvent.VK_DOWN:
                down();
                break;
            case KeyEvent.VK_LEFT:
                right();
                break;
            case KeyEvent.VK_RIGHT:
                left();
                break;
            case KeyEvent.VK_E:
                mo.empezarPartida();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP||code == KeyEvent.VK_DOWN || code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT ) {
            vely = 0;
            velx = 0;

        }
    }
    
    public void up() {
        this.vely = (float) -1;
    
    }
    
    public void down(){
        this.vely = (float) 1;
    }
    
    public void right(){
        this.velx = -1;
    }
    
    public void left(){
        this.velx = 1;
    }
    
}
