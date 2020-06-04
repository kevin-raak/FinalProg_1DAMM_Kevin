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
public class OtrosProductos extends Producto{

    /**
     * Crea un producto no comestible.
     * @param id ID del producto, es un número.
     * @param nombre Nombre del producto, lo que iría en la etiqueta del precio.
     * @param descripcion Breve descripción del producto. Máximo 150 caracteres.
     */
    public OtrosProductos(int id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }
}
