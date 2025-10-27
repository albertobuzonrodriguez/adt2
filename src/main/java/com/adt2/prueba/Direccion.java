
package com.adt2.prueba;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // <--- ¡Esto es lo que falta!
@Table(name = "direcciones") // Opcional, pero recomendado
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // <--- Debe tener una clave primaria

    private String calle;
    private String ciudad;
    // ... otros campos y métodos
}

