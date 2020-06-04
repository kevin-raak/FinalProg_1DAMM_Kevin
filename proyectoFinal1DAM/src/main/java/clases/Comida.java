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

    /**
     * Crea un producto comestible.
     * @param caduca TRUE si tiene fecha de caducidad, FALSE si no.
     * @param fechaCaducidad Fecha de caducidad del producto. (FORMATO aaaa-mm-dd, ej.: 2020-12-31). String.
     * @param id ID del producto, un número.
     * @param nombre Nombre del producto, lo que iría en la etiqueta del precio. String
     * @param descripcion Breve descripción del producto. Máximo 150 caracteres.
     */
    public Comida(boolean caduca, String fechaCaducidad, int id, String nombre, String descripcion) {
        super(id, nombre, descripcion, fechaCaducidad);
        this.caduca = caduca;
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Getter de la variable caduca.
     * @return TRUE si tiene fecha de caducidad, FALSE si no.
     */
    public boolean isCaduca() {
        return caduca;
    }

    /**
     * Setter de la variable caduca.
     * @param caduca TRUE si tiene fecha de caducidad, FALSE si no.
     */
    public void setCaduca(boolean caduca) {
        this.caduca = caduca;
    }

    /**
     * Getter de la fecha de caducidad del producto.
     * @return la fecha de caducidad en un String.
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Setter de la fecha de caducidad.
     * @param fechaCaducidad Fecha de caducidad del producto. (FORMATO aaaa-mm-dd, ej.: 2020-12-31). String.
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
}
