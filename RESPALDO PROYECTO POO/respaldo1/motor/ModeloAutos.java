package motor;


import java.applet.AudioClip;
import java.awt.Graphics;
import java.util.Random;
import static motor.Carro.getStop;

/**
 * Clase que maneja la logica del juego y del computador
 */
public class ModeloAutos {

    private int lineasSeparadoras=0;
    private Random r= new Random();
    private int mostrarCoche=0;
    private int nCoche=1;
    private boolean Jugando;
    private Carro  coches []= new Carro[7];

    //REPRESENTACIONES EN STRING DE e.getKeyCode()

    private boolean teclas[]=new boolean[4];

    private  int nPuntos=0;

    public ModeloAutos(){
        crearCarros();
        empezarPartida();
    }

    public int getLineaSeparadora(){
        return lineasSeparadoras;
    }

    private void avanzarLineaSeparadora(){
        lineasSeparadoras+=4;
        if(lineasSeparadoras>0)
            lineasSeparadoras-=40;
    }
    
    private void sonidoCarrera(boolean a){
        AudioClip audio;
        audio  = java.applet.Applet.newAudioClip(getClass().getResource("/motor/coche_2.wav"));
        if (a==true){
            audio.play();
        }
        else if(a==false){
            audio.stop();
        }
    }
    /**
     * Metodo encargado del movimiento de las lineas separadoras
     */
    public void Mover() {
        if (Jugando) {

            for (int n = 1; n < coches.length; n++) {
                coches[n].moverComputador();
                if(coches[n].getY()==100){
                    aumentarPuntaje();
                }
            }
            
            avanzarLineaSeparadora();
            mostrarNuevoCarro();
            detectarChoque();
        }
    }
    
    public void moverCarroPropio(int a, float b) {
        if (Jugando) {
            coches[0].mover(a, b);
            
            detectarChoque();
        }
    }

    private void mostrarNuevoCarro(){
        mostrarCoche++;
        if(mostrarCoche==14){
            mostrarCoche=0;
            int red=r.nextInt(255);
            int green=r.nextInt(255);
            int blue=r.nextInt(255);
            int nColor = red+(green*0x100)+(blue*0x10000);
            System.out.println(nColor);
            coches[nCoche].mostrarCarro(nColor);
            coches[nCoche].setDy(r.nextInt(2)+1);
            nCoche++;
            if(nCoche==coches.length){
                nCoche=1;
            }
            
        }
    }
    
    public void aumentarPuntaje(){
        nPuntos++;
    }

    private void crearCarros(){
        for(int i=0 ;i < coches.length;i++){
            if(i==0){
                coches[i]= new Carro(false,r);                
            }
            else{
                coches[i]= new Carro(true,r);
            }
        }
    }

    public void eventoTecla(int nTecla, boolean bEstado){

        teclas[nTecla]=bEstado;
    }

    public Carro [] getCarros(){
        return coches;
    }

    public void empezarPartida(){
        System.out.println("Empezo la partida");
        AudioCarrera aud = new AudioCarrera();
        coches[0].mostrarCarro(0xff0000);
        coches[0].setXY(45,70);
        for(int i =1;i<coches.length;i++){
            //coches[i].mostrarCarro(0xFF0000);
            coches[i].ocultarCarro();
            
            //Mover();
            
        }
        nPuntos=0;
        Jugando=true;
        aud.start();
        if(getStop()){
            aud.stop();
        }
    }

    public void detectarChoque(){
        int x=coches[0].getX();
        int y=coches[0].getY();
        for (int n=1;n<coches.length;n++)
            if (coches[n].getVisible() && coches[n].hayChoque(x,y)){
                Jugando=false;
            }
        
                
    }

    public int getPuntos(){
        return nPuntos;
    }

}
