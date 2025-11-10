package com.adt2.prueba;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEmpresa")
    private Long id;
    private String nombre;
    private String cif;

    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleados = new ArrayList<Empleado>();

    public Empresa(){}

    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;

    }

    public Empresa(String nombre, String cif, List<Empleado> empleados) {
        this.nombre = nombre;
        this.cif = cif;
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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", nombre=" + nombre + ", cif=" + cif + "]";
    }

    
}
