package motor;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Autopista extends JFrame implements Runnable {

    public  AudioClip audio;
    public static final int RIGHT=0;
    public static final int LEFT=1;
    public static final int DOWN=2;
    public static final int UP=3;
    public static final int ENTER=4;
    
    
    private Container container;
    JButton MenuPrincipal;
    private int lineasSeparadoras=0;
    private ModeloAutos modeloAutos = new ModeloAutos();;
    private int  codTecla;
    public  Thread hilo = new Thread(this);
   
   // public Thread audio = new Thread(new Sonido(true));





    public int getCodTecla() {
        return codTecla;
    }

    public void setCodTecla(int codTecla) {
        this.codTecla = codTecla;
    }

    public Autopista(){
        super("Autopista");
        hilo.start();
        
        initialComponents();
        
       
        setVisible(true);
        //EventoTeclado teclado = new EventoTeclado();
        //addKeyListener(teclado);
    }

    public void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,20);
        //setLayout(null);//Desde código,decimos DONDE  va cada botón, en qué posición va y qué tamaño ocupa en la ventana
        setResizable(true);// Sirve para habilitar o no, que se modifique el tamanio de la ventana
        setSize(500, 700);
        
//        MenuPrincipal = new JButton("Menu");
//        MenuPrincipal.setBounds(70, 50, 150, 30);
//        container = getContentPane();
//        container.add(MenuPrincipal);
    }
    

    /**
     *
     * @param x
     * @return Coordenadas de el tamanio de la pantalla para reajustarse
     */
    public int getX(int x){
        return (x*getWidth())/100;
    }

    public int getY(int y){
        return (y*getHeight())/100;
    }

    public void pintarFondo(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(getX(0),getY(0),getX(20),getY(100));
        g.fillRect(getX(80),getY(0),getX(20),getY(100));
        g.setColor(Color.GRAY);
        g.fillRect(getX(20),getY(0),getX(60),getY(100));
        g.setColor(Color.WHITE);
        g.fillRect(getX(20),getY(0),getX(1),getY(100));
        g.fillRect(getX(79),getY(0),getX(1),getY(100));
    }

    public void lineasSeparadoras(Graphics g){
        int iD=modeloAutos.getLineaSeparadora();
        g.setColor(Color.WHITE);

        for (int n=iD;n<100;n+=40){
            g.fillRect(getX(40),getY(n),getX(2),getY(20));
            g.fillRect(getX(60),getY(n),getX(2),getY(20));
        }
    }

    /**
     *
     * @param  g
     * @return Clase padre paint, sobreescrita
     *
     */

    public void paint(Graphics g) {
        
        //super.paint(g);
        pintarFondo(g);
        lineasSeparadoras(g);
        Carro coches[] = modeloAutos.getCarros();
        //g.drawImage(coches[0].getImagen(), getX(coches[0].getX()), getY(coches[0].getY()),getX(9),getY(15), null);
        for (int n = 1; n < coches.length; n++) {
           
            if (coches[n].getVisible()) {
                pintarCoche(g, coches[n].getX(),
                        coches[n].getY(),
                        coches[n].getColor());
            }
        }
        g.drawImage(coches[0].getImagen(), getX(coches[0].getX()), getY(coches[0].getY()),getX(9),getY(15), null);
        pintarPuntos(g);
        
    }
    
    

    private void pintarCoche(Graphics g, int x, int y, int nColorBase){
        
        g.setColor(Color.getColor(String.valueOf(nColorBase)));
        g.fillRoundRect(getX(x), getY(y), getX(9), getY(15), 15, 8);
        g.setColor(Color.black);
        g.drawRoundRect(getX(x), getY(y),getX(9), getY(15), 15, 8);
        g.drawRect(getX(x), getY(y+2), getX(9), getY(10));
        g.drawRect(getX(x), getY(y+5), getX(9), getY(7));
        g.setColor(Color.blue);
        g.fillRect(getX(x+1), getY(y+4), getX(6), getY(1));
        g.fillRect(getX(x+1), getY(y+10), getX(6), getY(1));
    }

    /*private void eventoTecla(int tecla, boolean estado){

        switch(tecla){
            case 0:
                modeloAutos.eventoTecla(Autopista.RIGHT,estado);
                break;
            case 1:
                modeloAutos.eventoTecla(Autopista.LEFT,estado);
                break;
            case 2:
                modeloAutos.eventoTecla(Autopista.DOWN,estado);
                break;
            case 3:
                modeloAutos.eventoTecla(Autopista.UP,estado);
                break;
        }
    }*/

    private void pintarPuntos(Graphics g){
        g.setColor(Color.BLACK);
        g.drawString("Score: " + modeloAutos.getPuntos()+ " :v", getX(8), getY(25));
    }

    @Override
    public void run (){
        while (true){
            try{
                retardo();
                modeloAutos.Mover();
                repaint();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void retardo(){
        try{
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ModeloAutos getModeloAutos() {
        return modeloAutos;
    }
    
    



    /**
     * CLASE QUE SIRVE PARA OBTENER LOS CODIGOS NUMERICOS DE LAS TECLAS PRESIONADAS
     */
    /*class EventoTeclado implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
           // Autopista autopista=new Autopista();
            setCodTecla(e.getKeyCode());

            switch(getCodTecla()){
                case 37:
                    eventoTecla(1,true);
                    break;

                case 38:
                    eventoTecla(3,true);
                    break;
                case 39:
                    eventoTecla(0,true);
                    break;
                case 40:

                    eventoTecla(2,true);
                    break;
                case 10:
                    modeloAutos.empezarPartida();
                    break;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            //Autopista autopista=new Autopista();
            setCodTecla(e.getKeyCode());

            switch (getCodTecla()){
                case 37:
                    eventoTecla(0,false);
                case 38:
                    eventoTecla(1,false);
                case 39:
                    eventoTecla(2,false);

                case 40:
                    eventoTecla(3,false);
                    break;
            }
        }
    }*/
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                            
                Autopista au = new Autopista();
                ActionListener listener = new TimeListener(au.getModeloAutos());
                au.addKeyListener((KeyListener) listener );
                Timer timer = new Timer(25,listener);
                timer.start();
                
            }
        });
    }
    
}
