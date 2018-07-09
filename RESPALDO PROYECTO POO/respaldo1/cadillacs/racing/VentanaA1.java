/*
 * Creando ventana A1 (ventana MI JUEGO)
 */
package cadillacs.racing;

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
import static javax.swing.BorderFactory.createRaisedBevelBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class VentanaA1 extends JFrame{
    public Image imagenFondo;
    public URL fondoA;
    JLabel eti_MiJuego;
    JButton Boton_Tienda, Boton_SeleccionPista, Boton_Inicio;
    
    public VentanaA1 (){ //Constructor ventana A1.
        //CREANDO ESPECIFICACIONES DE VENTANA A1.
        System.out.println("VENTANA A1");
        this.setSize(700, 500);//Estableciendo tamaño de la venta A1.
        this.setLocationRelativeTo(null);//Centrando ventana en la pantalla.
        this.setTitle("MI JUEGO"); //Estableciendo titulo de la Venta A1.
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando cierre la ventana A1 automaticamente se terminara el programa.
        
        //COLOCANDO IMAGEN DE FONDO EN VENTA A1.
        fondoA = this.getClass().getResource("camarozl2.jpg");
        imagenFondo = new ImageIcon(fondoA).getImage();
        Container contenedor = getContentPane();
        contenedor.add(panelA1);
        panelA1.setLayout(null);//Estamos desactivando el diseño del panel.
        
        //CREANDO ETIQUETA DE NOMBRE DE LA PANTALLA.
        eti_MiJuego= new JLabel("Mi juego");
        eti_MiJuego.setBounds(280, 10, 300, 40);
        eti_MiJuego.setForeground(Color.WHITE);
        eti_MiJuego.setFont( new Font( "Cooper Black", Font.BOLD, 40 ) );
        panelA1.add(eti_MiJuego);
        
        //CREANDO BOTONES DE VENTANA A1.
        Boton_Tienda = new JButton ("Tienda");
        Boton_Tienda.setBounds(40, 60, 150, 50);//Colocando el boton en las cordenadas que yo deseo y el tamaño que lo deseo.
        Boton_Tienda.setBackground(Color.ORANGE);
        Boton_Tienda.setForeground(Color.BLACK);
        Boton_Tienda.setFont(new Font("Cooper black",0,16));  
        Boton_Tienda.setBorder(createRaisedBevelBorder());
        panelA1.add(Boton_Tienda);
        
        Boton_SeleccionPista = new JButton ("Seleccionar pista");
        Boton_SeleccionPista.setBounds(500, 60, 150, 50);
        Boton_SeleccionPista.setBackground(Color.ORANGE);
        Boton_SeleccionPista.setForeground(Color.BLACK);
        Boton_SeleccionPista.setFont(new Font("Cooper black",0,16));  
        Boton_SeleccionPista.setBorder(createRaisedBevelBorder());
        panelA1.add(Boton_SeleccionPista);
        
        Boton_Inicio = new JButton ("Inicio");
        Boton_Inicio.setBounds(500, 400, 150, 50);
        Boton_Inicio.setBackground(Color.ORANGE);
        Boton_Inicio.setForeground(Color.BLACK);
        Boton_Inicio.setFont(new Font("Cooper black",0,16));  
        Boton_Inicio.setBorder(createRaisedBevelBorder());      
        panelA1.add(Boton_Inicio);
        
        //CREANDO EVENTOS DE BOTONES...........
        Boton_Tienda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaA2 nextVA2 = new VentanaA2();
                nextVA2.setVisible(true);
                VentanaA1.this.dispose();
            }
            
        });
        
        Boton_SeleccionPista.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaA3 nextVA3 = new VentanaA3();
                nextVA3.setVisible(true);
                VentanaA1.this.dispose();
            }
            
        });
        
        Boton_Inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaA nextVA = new VentanaA();
                nextVA.setVisible(true);
                VentanaA1.this.dispose();
            }
            
        });
    }
    
    public JPanel panelA1 = new JPanel(){
        
        public void paintComponent(Graphics g){
            g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
        }
    };
    
}

    

