
package com.adt2.prueba;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // <--- ¡Esto es lo que falta!
@Table(name = "direcciones") // Opcional, pero recomendado
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // <--- Debe tener una clave primaria
    private String calle;
    private Integer cp;
    
    @OneToOne(mappedBy = "direccion", fetch= FetchType.LAZY)
    private Empleado empleado;

    public Direccion(){}


    public Direccion(String calle, Integer cp, Empleado empleado) {
        this.calle = calle;
        this.cp = cp;
        this.empleado = empleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
}

