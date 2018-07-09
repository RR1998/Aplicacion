/*
 * Creando ventana A3 ()
 */
package cadillacs.racing;

import motor.AudioCarrera;
import java.applet.AudioClip;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import motor.Autopista;
import motor.TimeListener;

//IMPORTS PARA REPRODUCIR ARCHIVOS .MP3
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import motor.Carro;
import tienda.entidades.Jugador;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class VentanaA3 extends JFrame {

    public Image imagenFondo;
    public URL fondoA;
    JLabel eti_SeleccionPista;
    JButton Boton_Jugar, Boton_Tienda;

    public VentanaA3() { //Constructor ventana A3.
        //CREANDO ESPECIFICACIONES DE VENTANA A3.
        System.out.println("VENTANA A3");
        this.setSize(700, 500);//Estableciendo tamaño de la venta A3.
        this.setLocationRelativeTo(null);//Centrando ventana en la pantalla.
        this.setTitle("SELECCIONAR PISTA DE CARRERA"); //Estableciendo titulo de la Venta A3.
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando cierre la ventana A2 automaticamente se terminara el programa.

        //COLOCANDO IMAGEN DE FONDO EN VENTA A3.
        fondoA = this.getClass().getResource("cadillac.jpg");
        imagenFondo = new ImageIcon(fondoA).getImage();
        Container contenedor = getContentPane();
        contenedor.add(panelA3);
        panelA3.setLayout(null);//Estamos desactivando el diseño del panel.

        //CREANDO ETIQUETA DE NOMBRE DE PANTALLA.
        eti_SeleccionPista = new JLabel("Seleccionar Pista de Carrea");
        eti_SeleccionPista.setBounds(160, 10, 400, 34);
        eti_SeleccionPista.setForeground(Color.WHITE);
        eti_SeleccionPista.setFont(new Font("Bookman old style", Font.BOLD, 26));
        panelA3.add(eti_SeleccionPista);

        //CREANDO BOTONES DE VENTANA A3.
        Boton_Jugar = new JButton("JUGAR");
        Boton_Jugar.setBounds(40, 60, 150, 50);//Colocando el boton en las cordenadas que yo deseo y el tamaño que lo deseo.
        panelA3.add(Boton_Jugar);

        Boton_Tienda = new JButton("TIENDA");
        Boton_Tienda.setBounds(500, 400, 150, 50);//Colocando el boton en las cordenadas que yo deseo y el tamaño que lo deseo.
        panelA3.add(Boton_Tienda);

        //CREANDO EVENTOS DE BOTONES...........
        Boton_Jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Autopista juego = new Autopista();
                juego.setVisible(true);
                ActionListener listener = new TimeListener(juego.getModeloAutos());
                juego.addKeyListener((KeyListener) listener);
                AudioCarrera aud = new AudioCarrera();
                Timer timer = new Timer(25, listener);
                timer.start();
                if(Carro.getStop()){
                    System.out.println("el auto se detuvo");
                    aud.stop();
                }
                aud.start();
                                
            }

        });

        Boton_Tienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugador = new Jugador();
                VentanaA2 nextVA2 = new VentanaA2(jugador);
                nextVA2.setVisible(true);
                VentanaA3.this.dispose();
            }

        });

    }

    public JPanel panelA3 = new JPanel() {

        public void paintComponent(Graphics g) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    };

}
