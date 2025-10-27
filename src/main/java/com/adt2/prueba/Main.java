package com.adt2.prueba;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Empleado e = new Empleado("Alberto", 28, true, 1900.0, LocalDate.of(2000, 5, 22), null, null);
        Metodos.crearE(e);
    }
}