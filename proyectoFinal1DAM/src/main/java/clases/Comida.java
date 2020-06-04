/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Kraze
 */
public class Comida extends Producto{
    private boolean caduca; //TRUE si tiene fecha de caducidad, FALSE si no
    private String fechaCaducidad; //Fecha de caducidad (FORMATO: yyyy-mm-dd)(EJ: 2020-12-31)

    public Comida(boolean caduca, String fechaCaducidad, int id, String nombre, String descripcion) {
        super(id, nombre, descripcion, fechaCaducidad);
        this.caduca = caduca;
        this.fechaCaducidad = fechaCaducidad;
    }

    
}
