/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.producto;

import core.persona.Instructor;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Allison Ruiz
 */
public class Curso extends Producto{
    private ArrayList<Instructor> instructores;
    private ArrayList<ProductoCliente> productosCliente;

    public Curso(int id, String nombre, LocalDate fechaInicio, boolean estadoActivo, float valor, Instructor instructor) {
        super(id, nombre, fechaInicio, estadoActivo, valor);
        this.instructores = new ArrayList<>();
        this.productosCliente = new ArrayList<>();
        
        this.instructores.add(instructor);
        this.instructores.get(0).addCurso(this);
    }

    public float getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void addProductoCliente(ProductoCliente productoCliente){
        if(!this.productosCliente.contains(productoCliente)){
            this.productosCliente.add(productoCliente);
        }
    }
}
