package com.adt2.prueba;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Empresa esa = new Empresa("CESUR Cartuja 2025", "A12345678L");
        
        Empleado e2 = new Empleado("María", 23, true, 2500.85, LocalDate.of(2002, 10, 15), null, null, esa);
        //Metodos.leerE();
        //Metodos.eliminarE(e1);
        Metodos.eliminarE(e2);
    }
}