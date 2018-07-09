/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadillacs.racing;

import java.applet.AudioClip;

/**
 *
 * @author Daniel Alejandro Orozco Orellana <00200617@uca.edu.sv>
 */
public class Sonido extends Thread {
   

    public Sonido() {
         
    }

    @Override
    public void run() {
        AudioClip audio;
        audio  = java.applet.Applet.newAudioClip(getClass().getResource("/cadillacs/racing/gta2.wav"));
        audio.loop();
     
    }

}
