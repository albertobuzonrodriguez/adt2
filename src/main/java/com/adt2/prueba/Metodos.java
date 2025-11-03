package com.adt2.prueba;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Metodos {
    public static Session getSession() {
		/*Usando addAnotatedClass(Usuario.class) ya estamos diciendole a Hibernate cual es la
		 * clase que tiene que mapear*/
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Empleado.class).addAnnotatedClass(Direccion.class).addAnnotatedClass(Empresa.class).configure().buildSessionFactory();
 
		/*Sin addAnotatedClass(Usuario.class) le tenemos que decir a Hibernate el paquete
		 * donde esta la clase que tiene que mapear, en el fichero de configuracion.*/
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

    public static void crearE(Empleado e){
        
        Session sessionObj = getSession();
        
        Transaction tx = sessionObj.beginTransaction();
        
        sessionObj.persist(e);

        tx.commit();
        
        sessionObj.close();

        System.out.println("Empleado con ID: " + e.getId() + " - nombre: " + e.getNombre() + " - edad: " + e.getEdad() + " - casado: " + e.getCasado() + " - salario: " + e.getSalario()+
            " y fecha de nacimiento: " + e.getFechaNacimiento() + " - email: " + e.getEmail() + " y empresa: " + e.getEmpresa().getNombre() + " creado CORRECTAMENTE");
    }


    public static void crearD(Direccion d) {
        
        Session sessionObj = getSession();
        
        Transaction tx = sessionObj.beginTransaction();
        
        sessionObj.persist(d);
        
        tx.commit();
        
        sessionObj.close();
        
        System.out.println("ID: " + d.getId() + " - calle: " + d.getCalle() + " - C.P.: " + d.getCp());
    }

    public static void crearESA(Empresa esa) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.persist(esa);
        tx.commit();
        session.close();
        System.out.println("Empresa con id: " + esa.getId() + " creada correctamente. ");
    }

    public static List<Empleado> leerE() {
        String consulta = "FROM " + Empleado.class.getName();
        Session sessionObj = getSession();
        List<Empleado> listaResultado = sessionObj.createQuery(consulta,
        Empleado.class).list();
        for (Empleado e : listaResultado) {
            System.out.println("Usuario con ID: " + e.getId() + " - nombre: " +e.getNombre() + " - edad: " + e.getEdad() +" - casado: " + e.getCasado() + " - salario: " +
            e.getSalario() +" años - y fecha de nacimiento: " +e.getFechaNacimiento() +" - email: " + e.getEmail() + " direccion: "+e.getDireccion());
        }
        sessionObj.close();
        return listaResultado;
    }

    public static List<Direccion> leerD() {
        String consulta = "FROM " + Direccion.class.getName();
        Session ss = getSession();
        List<Direccion> listaResultado = ss.createQuery(consulta,
        Direccion.class).list();
        for (Direccion d : listaResultado) {
            System.out.println(
            "ID: " + d.getId() + " - calle: " + d.getCalle() + " - C.P.: " + d.getCp());
        }
        ss.close();
        return listaResultado;
    }

    public static Empleado getE(int id) {
        Session session = getSession();
        Empleado e = session.find(Empleado.class, id);
        session.close();
        return e;
    }

    public static Direccion getD(int id){
        Session session = getSession();
        Direccion d = session.find(Direccion.class, id);
        session.close();
        return d;
    }

    public static void actualizarE(Empleado e){
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        /*Datos que queremos actualziar en el Empleado:*/
        e.setNombre("María José");
        List<String> emails = new ArrayList<String>();
        emails.add("nuevoEmail@cesur.com");
        e.setEmail(emails);
        /* Actualizamos el objeto */
        session.merge(e);
        tx.commit();
        session.close();
        System.out.println("Actualizado correctamente el usuario de id: " + e.getId());
    }

    public static void actualizarD(Direccion d){
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        /*Datos que queremos actualziar en la direccion:*/
        d.setCalle("Patricio Saenz");
        d.setCp(39222);;
        /* Actualizamos el objeto */
        session.merge(d);
        tx.commit();
        session.close();
        System.out.println("Actualizado correctamente la dirección de id: " + d.getId());
    }

    public static void eliminarE(Empleado e){
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.remove(e);
        tx.commit();
        session.close();
        System.out.println("El empleado de id: " + e.getId() + " ha sido eliminado correctamente. ");
    }

    public static void eliminarD(Direccion d){
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.remove(d);
        tx.commit();
        session.close();
        System.out.println("La dirección de id: " + d.getId() + " ha sido eliminada correctamente. ");
    }


}
