/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.vista;

import tienda.dao.CompraDao;
import tienda.dao.BoosterDao;
import tienda.dao.JugadorDao;
import tienda.entidades.Booster;
import tienda.entidades.Compra;
import tienda.entidades.Jugador;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author intel
 */
public class Tienda extends JFrame{
    
    private final int WIDTH=100;
    private final int HEIGHT=20;
    private JLabel[] labels;
    private JTextField cartera;
    private JLabel[] descripciones;
    private JButton comprarEst, comprarLlan, comprarComod;
    private Jugador jugador;
    private List<Booster> boosters;
    public Image imagenFondo;
    public URL fondoA;
    
    public Tienda(){
        super("Tienda");
        
        BoosterDao b = new BoosterDao();
        boosters = b.findAll();
        initComponents();
        eventos();
    }
    public Tienda(Jugador jugador){
        super("Tienda");
        this.jugador=jugador;
        BoosterDao b = new BoosterDao();
        boosters = b.findAll();
        initComponents();
        eventos();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        
        
        fondoA = this.getClass().getResource("camarozl1.jpg");
        imagenFondo = new ImageIcon(fondoA).getImage();
        
        container.add(panelA2);
        setLayout(null);
////        panelA2.setLayout(null);//Estamos desactivando el diseño del panel.
        
        labels = new JLabel[3];
        descripciones = new JLabel[3];
        comprarEst = new JButton("Comprar");
        comprarComod = new JButton("Comprar");
        comprarLlan = new JButton("Comprar");
        cartera= new JTextField();
        cartera.setEditable(false);
        cartera.setText(Integer.toString(jugador.getCartera()));
        
        
        for (int i=0; i<3;i++){
            labels[i]=new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(boosters.get(i).getNombre()+".png")));
            labels[i].setBounds(i*150+20,70, 100, 100);
            container.add(labels[i]);
            
            descripciones[i]=new JLabel("<html>"+boosters.get(i).getNombre()+"<br>"+"precio: "
                    +boosters.get(i).getPrecio()+"</html>");
            descripciones[i].setBounds(i*150+20, 180, WIDTH, 40);
            container.add(descripciones[i]);
        }
        
        cartera.setBounds(470, 10, WIDTH, HEIGHT);
        comprarEst.setBounds(20, 220, WIDTH, HEIGHT);
        comprarComod.setBounds(170, 220, WIDTH, HEIGHT);
        comprarLlan.setBounds(310, 220, WIDTH, HEIGHT);
        container.add(cartera);
        container.add(comprarEst);
        container.add(comprarComod);
        container.add(comprarLlan);
        setSize(600,400);
        setVisible(true);
    }

    
    private void eventos(){
    
        comprarEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio =150;
                if(jugador.verificarFondos(precio)){
                    CompraDao compraDao= new CompraDao();
                    JugadorDao jugadorDao= new JugadorDao();
                    compraDao.insert(new Compra(jugador.getIdJugador(),1));
                    jugador.setCartera(jugador.pagar(precio));
                    cartera.setText(Integer.toString(jugador.getCartera()));
                    jugadorDao.update(jugador);
                }
            }
        });
        
        comprarComod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio=300;
                if(jugador.verificarFondos(precio)){
                    CompraDao compraDao= new CompraDao();
                    JugadorDao jugadorDao= new JugadorDao();
                    compraDao.insert(new Compra(jugador.getIdJugador(),2));
                    jugador.setCartera(jugador.pagar(precio));
                    cartera.setText(Integer.toString(jugador.getCartera()));
                    jugadorDao.update(jugador);
                }
            }
        });

        comprarLlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio=200;
                if(jugador.verificarFondos(precio)){
                    CompraDao compraDao= new CompraDao();
                    JugadorDao jugadorDao= new JugadorDao();
                    compraDao.insert(new Compra(jugador.getIdJugador(),3));
                    jugador.setCartera(jugador.pagar(precio));
                    cartera.setText(Integer.toString(jugador.getCartera()));
                    jugadorDao.update(jugador);
                }
            }
        });
    }
    
    public JPanel panelA2 = new JPanel(){
        
        public void paintComponent(Graphics g){
            g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
        }
    };
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            new Tienda().setVisible(true);                
            
            }
        });
    }
}
