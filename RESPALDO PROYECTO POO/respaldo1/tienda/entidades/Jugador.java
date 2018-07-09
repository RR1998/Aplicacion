/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entidades;

import java.util.ArrayList;

/**
 *
 * @author intel
 */
public class Jugador {
    
    private int idJugador;
    private String nombre;
    private int cartera;
    private ArrayList<Booster> boosters;
    
    public Jugador(){}
    
    public Jugador(String nombre, int cartera){
        this.nombre=nombre;
        this.cartera=cartera;
    }
    
    public int getIdJugador(){return idJugador;}
    
    public void setIdJugadr(int idJugador){this.idJugador=idJugador;}
    
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getCartera() {return cartera;}

    public void setCartera(int cartera) {this.cartera = cartera;}
    
    public boolean verificarFondos(int precio){return (cartera>=precio);}
    
    public int pagar(int precio){
        if (cartera>=precio)
            cartera-=precio;
        return cartera;
    }
    
   
    
    
}
