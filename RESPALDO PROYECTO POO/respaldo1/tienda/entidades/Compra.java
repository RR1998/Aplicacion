/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entidades;

/**
 *
 * @author intel
 */
public class Compra {
    
    private int idCompra;
    private int idJugador;
    private int idBooster;
    
    public Compra(){}
    
    public Compra(int idJugador, int idBooster){
        this.idJugador=idJugador;
        this.idBooster=idBooster;
    } 

    public int getIdCompra() {return idCompra;}

    public void setIdCompra(int idCompra) {this.idCompra = idCompra;}

    public int getIdJugador() {return idJugador;}

    public void setIdJugador(int idJugador) {this.idJugador = idJugador;}

    public int getIdBooster() {return idBooster;}

    public void setIdBooster(int idBooster) {this.idBooster = idBooster;}
    
    
    
}
