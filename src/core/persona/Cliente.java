/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.persona;

import core.producto.Curso;
import core.producto.PlanCliente;
import core.producto.ProductoCliente;
import java.util.ArrayList;

/**
 *
 * @author Allison Ruiz
 */
public class Cliente extends Persona{
    private ArrayList<PlanCliente> planes;
    private ArrayList<ProductoCliente> productos;

    public Cliente(String nombre, String cedula, String telefono, String email) {
        super(nombre, cedula, telefono, email);
        this.planes = new ArrayList<>();
        this.productos = new ArrayList<>();
    }
    
    public PlanCliente getPlan(int index){
        return this.planes.get(index);
    }

    public ArrayList<PlanCliente> getPlanes() {
        return planes;
    }

    public ArrayList<ProductoCliente> getProductos() {
        return productos;
    }

    public boolean getProductoCliente(Curso curso){
        for(ProductoCliente producto : this.productos){
            if(producto.getCurso() == curso){
                return true;
            }
        }
        return false;
    }
    
    public PlanCliente getPlanActivo(){
        for(PlanCliente plan : this.planes){
            if(plan.isEstadoActivo()){
                return plan;
            }
        }
        return null;
    }
    
    public boolean hasPlanActivo(){
        for(PlanCliente plan : this.planes){
            if(plan.isEstadoActivo()){
                return true;
            }
        }
        return false;
    }
    
    public void addProductoCliente(ProductoCliente productoCliente){
        if(!this.productos.contains(productoCliente)){
            this.productos.add(productoCliente);
        }
    }
    
    public void addPlan(PlanCliente planCliente){
        if(!this.planes.contains(planCliente)){
            this.planes.add(planCliente);
        }
    }

    public String getNombre() {
        return nombre;
    }
}
