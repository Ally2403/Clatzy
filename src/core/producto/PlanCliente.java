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
public class PlanCliente extends Producto{
    private Cliente cliente;
    private Plan plan;

    public PlanCliente(Cliente cliente, Plan plan, int id, String nombre, LocalDate fechaInicio, boolean estadoActivo, float valor) {
        super(id, nombre, fechaInicio, estadoActivo, valor);
        this.cliente = cliente;
        this.plan = plan;
        
        this.plan.addPlan(this);
        this.cliente.addPlan(this);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public float getValor() {
        return valor;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Plan getPlan() {
        return plan;
    }
    
}
