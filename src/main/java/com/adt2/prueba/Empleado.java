package com.adt2.prueba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "empleados")

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Long id;

    private String nombre;
    private Integer edad;
    private Boolean casado;
    private Double salario;
    private LocalDate fechaNacimiento;

    @ElementCollection
    private List<String> email = new ArrayList<String>();

    @OneToOne
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "id_empresa_fk", foreignKey = @ForeignKey(name = "fk_empleado_empresa"))
    private Empresa empresa;
    
    @ManyToMany
    @JoinTable(name="empleado_proyecto", 
            joinColumns= @JoinColumn(name= "id_Empleado", referencedColumnName= "idEmpleado"),
            inverseJoinColumns = @JoinColumn(name = "id_proyecto", referencedColumnName = "idProyecto"))
            
    private List<Proyecto> proyectos = new ArrayList<Proyecto>();
    public Empleado (){
        
    }
    
    public Empleado(String nombre, Integer edad, Boolean casado, Double salario, LocalDate fechaNacimiento,
            List<String> email, Direccion direccion, Empresa empresa, List<Proyecto> proyectos) {
        this.nombre = nombre;
        this.edad = edad;
        this.casado = casado;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.direccion = direccion;
        this.empresa = empresa;
        this.proyectos = proyectos;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getCasado() {
        return casado;
    }

    public void setCasado(Boolean casado) {
        this.casado = casado;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", casado=" + casado + ", salario="
                + salario + ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", direccion=" + direccion
                + ", empresa=" + empresa + "]";
    }

    
    
}
