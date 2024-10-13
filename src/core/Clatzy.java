/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.persona.Cliente;
import core.persona.Instructor;
import core.producto.Curso;
import core.producto.Plan;
import core.producto.PlanCliente;
import core.producto.ProductoCliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Allison Ruiz
 */
public class Clatzy {
    private ArrayList<Cliente> clientes;
    private ArrayList<Instructor> instructores;
    private ArrayList<Curso> cursos;
    private ArrayList<Plan> planes;

    public Clatzy() {
        this.clientes = new ArrayList<>();
        this.instructores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.planes = new ArrayList<>();
    }
    
    public void listAll(){
        System.out.println("Lista de clientes con sus compras:");
        for(Cliente cliente : this.clientes){
            System.out.println("----------------------------------------");
            System.out.println(cliente.getNombre());
            System.out.println("Planes:");
            for(PlanCliente plan : cliente.getPlanes()){
                String booleanPlan;
                if(plan.isEstadoActivo()){
                    booleanPlan = "True";
                }else{
                    booleanPlan = "False";
                }
                System.out.println(plan.getPlan().getNombre()+" "+plan.getFechaInicio()+" "+String.format("%.1f", plan.getValor()).replace(",", ".")+" "+booleanPlan);
            }
            System.out.println("\nCursos:");
            for(ProductoCliente producto : cliente.getProductos()){
                String booleanProducto;
                if(producto.isEstadoActivo()){
                    booleanProducto = "True";
                }else{
                    booleanProducto = "False";
                }
                System.out.println(producto.getCurso().getNombre()+" "+producto.getFechaInicio()+" "+String.format("%.1f", producto.getValor()).replace(",", ".")+" "+booleanProducto);
            }
        }
    }
    
    public String getClienteMayorIngreso(){
        Map<Cliente, Integer> counts = new LinkedHashMap<>();
        
        for(Cliente cliente : this.clientes){
            counts.put(cliente,0);
            for(ProductoCliente producto : cliente.getProductos()){
                if(producto.getValor() != 0){
                    counts.put(cliente, counts.get(cliente) + 1);
                }
            }
        }
        int countsMax = Collections.max(counts.values());
        for(Cliente cliente : counts.keySet()){
            if(counts.get(cliente) == countsMax){
                return cliente.getNombre();
            }
        }
        return "";
    }
    
    //No pasan valor porque se supone que se compra con el plan
    public void comprarCurso(Cliente cliente, Curso curso, LocalDate date){
        if(cliente.getProductoCliente(curso)){
            System.out.println("El cliente "+cliente.getNombre()+" ya habia registrado el curso "+curso.getNombre());
        }else{
            if(cliente.hasPlanActivo()){
                if(cliente.getPlanActivo().getPlan().getValorMaximoCurso() >= curso.getValor()){
                    //el plan cubre el curso
                    ProductoCliente productoCliente = new ProductoCliente(0, cliente, curso, 0, "", date, true, 0);
                    System.out.println("El cliente "+cliente.getNombre()+" registro exitosamente el curso "+curso.getNombre());
                }else{
                    System.out.println("El plan del cliente "+cliente.getNombre()+" no cubre el curso "+curso.getNombre());
                }
            }
        }
    }
    
    //Pasan valor porque van a realizar la compra en efectivo
    public void comprarCurso(Cliente cliente, Curso curso, LocalDate date, float valor){
        if(cliente.getProductoCliente(curso)){
            System.out.println("El cliente "+cliente.getNombre()+" ya habia comprado el curso "+curso.getNombre());
        }else{
            //si el cliente tiene plan
            if(cliente.hasPlanActivo()){
                //si el plan cubre el curso
                if(cliente.getPlanActivo().getPlan().getValorMaximoCurso() >= curso.getValor()){
                    ProductoCliente productoCliente = new ProductoCliente(0, cliente, curso, 0, "", date, true, 0);
                    System.out.println("El curso esta incluido en el plan del cliente "+cliente.getNombre()+", por lo tanto no debe pagar. Se procede a registrar el curso "+curso.getNombre()+" con costo $0");
                }else{
                    //si el plan no cubre el curso lo compra por efectivo
                    ProductoCliente productoCliente = new ProductoCliente(0, cliente, curso, 0, "", date, true, valor);
                    System.out.println("El cliente "+cliente.getNombre()+" compro exitosamente el curso "+curso.getNombre());
                }
            }else{
                //si el cliente no tiene plan
                if(curso.getValor() != valor){
                    System.out.println("El cliente "+cliente.getNombre()+" no pago el valor correcto por el curso "+curso.getNombre());
                }else{
                    //compra por efectivo sin plan
                    ProductoCliente productoCliente = new ProductoCliente(0, cliente, curso, 0, "", date, true, valor);
                    System.out.println("El cliente "+cliente.getNombre()+" compro exitosamente el curso "+curso.getNombre());
                }
            }
        }
    }
    
    public Cliente getCliente(int index){
        return this.clientes.get(index);
    }
    
    public Plan getPlan(int index){
        return this.planes.get(index);
    }
    
    public Curso getCurso(int index){
        return this.cursos.get(index);
    }
    
    public void comprarPlan(Cliente cliente, Plan plan, LocalDate date){
        if(cliente.hasPlanActivo()){
            System.out.println("El cliente "+ cliente.getNombre() +" ya tiene un plan activo");
        }else{
            PlanCliente planCliente = new PlanCliente(cliente, plan, 0, "", date, true, plan.getValor());
            System.out.println("El cliente " + planCliente.getCliente().getNombre() + " compro exitosamente un plan " + planCliente.getPlan().getNombre());
        }
    }
    
    public void addPlan(String nombre, LocalDate fechaInicio, float valor, float valorMaximoCurso){
        Plan plan = new Plan(valorMaximoCurso, 0, nombre, fechaInicio, true, valor);
        if(!this.planes.contains(plan)){
            this.planes.add(plan);
        }
    }
    
    public void addCurso(int id, String nombre, LocalDate fechaInicio, float valor, Instructor instructor){
        Curso curso = new Curso(id, nombre, fechaInicio, true, valor, instructor);
        if(!this.cursos.contains(curso)){
            this.cursos.add(curso);
        }
    }
    
    public Instructor getInstructor(int index){
        return this.instructores.get(index);
    }
    
    public void addCliente(String nombre, String cedula, String telefono, String email){
        Cliente cliente = new Cliente(nombre, cedula, telefono, email);
        if(!this.clientes.contains(cliente)){
            this.clientes.add(cliente);
        }
    }
    
    public void addInstructor(String nombre, String cedula, String telefono, String email){
        Instructor instructor = new Instructor(nombre, cedula, telefono, email);
        if(!this.instructores.contains(instructor)){
            this.instructores.add(instructor);
        }
    }
}
