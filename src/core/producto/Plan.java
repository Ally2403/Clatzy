/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.producto;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Allison Ruiz
 */
public class Plan extends Producto{
    private float valorMaximoCurso;
    private ArrayList<PlanCliente> planes;

    public Plan(float valorMaximoCurso, int id, String nombre, LocalDate fechaInicio, boolean estadoActivo, float valor) {
        super(id, nombre, fechaInicio, estadoActivo, valor);
        this.valorMaximoCurso = valorMaximoCurso;
        this.planes = new ArrayList<>();
    }

    public float getValorMaximoCurso() {
        return valorMaximoCurso;
    }
    

    public float getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void addPlan(PlanCliente planCliente){
        if(!this.planes.contains(planCliente)){
            this.planes.add(planCliente);
        }
    }
}
