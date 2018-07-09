/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import java.applet.AudioClip;
import static motor.Carro.getStop;

/**
 *
 * @author Daniel Alejandro Orozco Orellana <00200617@uca.edu.sv>
 */
public class AudioCarrera extends Thread{
    private boolean play;

    public boolean getPlay() {
        return play;
    }

    public void setPlay(boolean a) {
        this.play = play;
    }
    
    
    public AudioCarrera() {
         
    }

    @Override
    public void run() {
        AudioClip audio;
        audio  = java.applet.Applet.newAudioClip(getClass().getResource("/cadillacs/racing/coche_2.wav"));
        audio.loop();
        if(Carro.getStop()==true){
            System.out.println("se detuvo el audio");
            audio.stop();
        }
     
    }
}
