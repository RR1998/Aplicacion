/*
 * Creando ventana A2 (ventana de TIENDA)
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
import java.util.List;
import static javax.swing.BorderFactory.createRaisedBevelBorder;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tienda.dao.BoosterDao;
import tienda.dao.CompraDao;
import tienda.dao.JugadorDao;
import tienda.entidades.Booster;
import tienda.entidades.Compra;
import tienda.entidades.Jugador;
import tienda.vista.Tienda;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class VentanaA2 extends JFrame {

    public Image imagenFondo;
    public URL fondoA;
    JLabel eti_Tienda;
    JButton Boton_SeleccionarPista, Boton_Inicio;

    private final int WIDTH = 100;
    private final int HEIGHT = 20;
    private JLabel[] labels;
    private JTextField cartera;
    private JLabel[] descripciones;
    private JButton comprarEst, comprarLlan, comprarComod;
    private Jugador jugador;
    private List<Booster> boosters;
    
    Container contenedor = getContentPane();
    
    public VentanaA2(Jugador jugador) { //Constructor ventana A2.
        //CREANDO ESPECIFICACIONES DE VENTANA A2.
        System.out.println("VENTANA A2");
        this.setSize(700, 500);//Estableciendo tamaño de la venta A2.
        this.setLocationRelativeTo(null);//Centrando ventana en la pantalla.
        this.setTitle("Tienda"); //Estableciendo titulo de la Venta A2.
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando cierre la ventana A2 automaticamente se terminara el programa.

        this.jugador = jugador;
        BoosterDao b = new BoosterDao();
        boosters = b.findAll();
        initComponents();
        eventos();
        //COLOCANDO IMAGEN DE FONDO EN VENTA A2.
        fondoA = this.getClass().getResource("charger.jpg");
        imagenFondo = new ImageIcon(fondoA).getImage();
        
        contenedor.add(panelA2);
        panelA2.setLayout(null);//Estamos desactivando el diseño del panel.

        //CREANDO ETIQUETA DE NOMBRE DE PANTALLA.
        eti_Tienda = new JLabel("Tienda");
        eti_Tienda.setBounds(300, 10, 300, 40);
        eti_Tienda.setForeground(Color.WHITE);
        eti_Tienda.setFont(new Font("Cooper Black", Font.BOLD, 40));
        panelA2.add(eti_Tienda);

        //CREANDO BOTONES DE VENTANA A2.
        Boton_SeleccionarPista = new JButton("Seleccionar pista");
        Boton_SeleccionarPista.setBounds(500, 60, 160, 50);//Colocando el boton en las cordenadas que yo deseo y el tamaño que lo deseo.
        Boton_SeleccionarPista.setBackground(Color.YELLOW);
        Boton_SeleccionarPista.setForeground(Color.BLACK);
        Boton_SeleccionarPista.setFont(new Font("Cooper black", 0, 16));
        Boton_SeleccionarPista.setBorder(createRaisedBevelBorder());
        panelA2.add(Boton_SeleccionarPista);

        Boton_Inicio = new JButton("Inicio");
        Boton_Inicio.setBounds(500, 400, 150, 50);
        Boton_Inicio.setBackground(Color.YELLOW);
        Boton_Inicio.setForeground(Color.BLACK);
        Boton_Inicio.setFont(new Font("Cooper black", 0, 16));
        Boton_Inicio.setBorder(createRaisedBevelBorder());
        panelA2.add(Boton_Inicio);

        //CREANDO EVENTOS DE BOTONES...........
        Boton_SeleccionarPista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaA3 nextVA3 = new VentanaA3();
                nextVA3.setVisible(true);
                VentanaA2.this.dispose();
            }

        });

        Boton_Inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaA nextVA = new VentanaA();
                nextVA.setVisible(true);
                VentanaA2.this.dispose();
            }

        });

    }


    private void initComponents() {
        
        labels = new JLabel[3];
        descripciones = new JLabel[3];
        
        comprarEst = new JButton("Comprar");
        
        comprarComod = new JButton("Comprar");
        comprarLlan = new JButton("Comprar");
        cartera = new JTextField();
        cartera.setEditable(false);
        cartera.setText(Integer.toString(jugador.getCartera()));

        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(boosters.get(i).getNombre() + ".png")));
            labels[i].setBounds(i * 150 + 20, 70, 100, 100);
            contenedor.add(labels[i]);

            descripciones[i] = new JLabel("<html>" + boosters.get(i).getNombre() + "<br>" + "precio: "
                    + boosters.get(i).getPrecio() + "</html>");
            descripciones[i].setBounds(i * 150 + 20, 180, WIDTH, 40);
            contenedor.add(descripciones[i]);
        }

        cartera.setBounds(470, 220, WIDTH, HEIGHT);
        comprarEst.setBounds(20, 220, WIDTH, HEIGHT);
        comprarComod.setBounds(170, 220, WIDTH, HEIGHT);
        comprarLlan.setBounds(310, 220, WIDTH, HEIGHT);
        contenedor.add(cartera);
        contenedor.add(comprarEst);
        contenedor.add(comprarComod);
        contenedor.add(comprarLlan);
    }

    private void eventos() {

        comprarEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio = 150;
                if (jugador.verificarFondos(precio)) {
                    CompraDao compraDao = new CompraDao();
                    JugadorDao jugadorDao = new JugadorDao();
                    compraDao.insert(new Compra(jugador.getIdJugador(), 1));
                    jugador.setCartera(jugador.pagar(precio));
                    cartera.setText(Integer.toString(jugador.getCartera()));
                    jugadorDao.update(jugador);
                }
            }
        });

        comprarComod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio = 300;
                if (jugador.verificarFondos(precio)) {
                    CompraDao compraDao = new CompraDao();
                    JugadorDao jugadorDao = new JugadorDao();
                    compraDao.insert(new Compra(jugador.getIdJugador(), 2));
                    jugador.setCartera(jugador.pagar(precio));
                    cartera.setText(Integer.toString(jugador.getCartera()));
                    jugadorDao.update(jugador);
                }
            }
        });

        comprarLlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio = 200;
                if (jugador.verificarFondos(precio)) {
                    CompraDao compraDao = new CompraDao();
                    JugadorDao jugadorDao = new JugadorDao();
                    compraDao.insert(new Compra(jugador.getIdJugador(), 3));
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
                Jugador jugador = new Jugador();
                new VentanaA2(jugador).setVisible(true);

            }
        });
    }
}
