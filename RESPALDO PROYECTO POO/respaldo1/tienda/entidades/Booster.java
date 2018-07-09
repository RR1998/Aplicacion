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
public class Booster {
    
    private int idBooster;
    private String nombre;
    private String descripcion; 
    private int precio;

    public int getId(){return idBooster;}
    
    public void setId(int id) {this.idBooster=id;}
    
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}
    
    
    
}
