package com.adt2.prueba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProyecto")
    private Long id;
    private String nombre;
    private LocalDate fechaEntrega;

    @ManyToMany(mappedBy = "proyectos")
    private List<Empleado> empleados = new ArrayList<Empleado>();

    public Proyecto(){}

    public Proyecto(String nombre, LocalDate fechaEntrega) {
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
    }

    public Proyecto(String nombre, LocalDate fechaEntrega, List<Empleado> empleados) {
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
        this.empleados = empleados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Proyecto [id=" + id + ", nombre=" + nombre + ", fechaEntrega=" + fechaEntrega + ", empleados="
                + empleados + "]";
    }
  
}
