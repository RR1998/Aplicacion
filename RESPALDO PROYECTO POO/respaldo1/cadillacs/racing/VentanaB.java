/*
 * Creando ventana de Instrucciones
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
public class VentanaB extends JFrame{
    public Image imagenFondo;
    public URL fondoA;
    
    JButton Boton_Inicio;
    
    public VentanaB (){ //Constructor ventana B.
        //CREANDO ESPECIFICACIONES DE VENTANA B.
        System.out.println("VENTANA B");
        this.setSize(700, 500);//Estableciendo tamaño de la venta B.
        this.setLocationRelativeTo(null);//Centrando ventana en la pantalla.
        this.setTitle("INSTRUCCIONES"); //Estableciendo titulo de la Venta B.
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando cierre la ventana B automaticamente se terminara el programa.
        
        //COLOCANDO IMAGEN DE FONDO EN VENTA B.
        fondoA = this.getClass().getResource("Instrucciones.jpg");
        imagenFondo = new ImageIcon(fondoA).getImage();
        Container contenedor = getContentPane();
        contenedor.add(panelB);
        panelB.setLayout(null);//Estamos desactivando el diseño del panel.
        
        //JBUTTON
        
        Boton_Inicio = new JButton ("Inicio");
        Boton_Inicio.setBounds(575, 425, 100, 25);
        Boton_Inicio.setBackground(Color.BLACK);
        Boton_Inicio.setForeground(Color.WHITE);
        Boton_Inicio.setFont(new Font("Cooper black",0,16));  
        Boton_Inicio.setBorder(createRaisedBevelBorder());
        panelB.add(Boton_Inicio);
        
        //CREANDO EVENTOS DE BOTONES...........
        Boton_Inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaA nextVA = new VentanaA();
                nextVA.setVisible(true);
                VentanaB.this.dispose();
            }
            
        });
        
        
    }
    
    public JPanel panelB = new JPanel(){
        
        public void paintComponent(Graphics g){
            g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
        }
    };
    
    
}
