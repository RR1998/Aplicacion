/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadillacs.racing;

import java.applet.AudioClip;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class CadillacsRacing {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        Logo logo = new Logo();
        Sonido au = new Sonido();
        au.start();
        logo.setVisible(true);
        
       
        
    }
       
}
