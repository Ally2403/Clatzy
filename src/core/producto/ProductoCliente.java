/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.producto;

import core.persona.Cliente;
import java.time.LocalDate;

/**
 *
 * @author Allison Ruiz
 */
public class ProductoCliente extends Producto{
    private boolean estadoAprobado;
    private int nivelAvance;
    private Cliente cliente;
    private Curso curso;

    public ProductoCliente(int nivelAvance, Cliente cliente, Curso curso, int id, String nombre, LocalDate fechaInicio, boolean estadoActivo, float valor) {
        super(id, nombre, fechaInicio, estadoActivo, valor);
        this.estadoAprobado = true;
        this.nivelAvance = nivelAvance;
        this.cliente = cliente;
        this.curso = curso;
        
        this.curso.addProductoCliente(this);
        this.cliente.addProductoCliente(this);
    }

    public Curso getCurso() {
        return curso;
    }

    public float getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }
    
}
