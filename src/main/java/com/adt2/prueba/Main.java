package com.adt2.prueba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empresa esa = new Empresa("CESUR Cartuja 2025", "A12345678L");
        Metodos.crearESA(esa);
        List<Empleado> empleadosEmpresa = new ArrayList<Empleado>();
        empleadosEmpresa.add(null);
        Empresa esa2 = new Empresa("CESUR Cartuja 2025", "A12345678L", empleadosEmpresa);
        Metodos.crearESA(esa2);
        Direccion d1 = new Direccion("Patricio Saenz", 42993);
        Metodos.crearD(d1);
        LocalDate fechaProyecto = LocalDate.of(2025, 11, 11);
        Proyecto p1 = new Proyecto("AiMAI", fechaProyecto);
        Metodos.crearProyecto(p1);
        List<Proyecto> proyectos = new ArrayList<Proyecto>();
        proyectos.add(p1);
        Empleado e2 = new Empleado("María", 23, true, 2500.85, LocalDate.of(2002, 10, 15), null, d1, esa2, proyectos);
        Metodos.crearE(e2);
        // Metodos.leerE();
        //Metodos.eliminarE(e1);
        // Metodos.eliminarE(e2);
    }
}