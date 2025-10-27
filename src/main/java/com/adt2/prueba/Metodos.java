package com.adt2.prueba;



import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Metodos {
    public static Session getSession() {
		/*Usando addAnotatedClass(Usuario.class) ya estamos diciendole a Hibernate cual es la
		 * clase que tiene que mapear*/
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Empleado.class).addAnnotatedClass(Direccion.class).configure().buildSessionFactory();
 
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

        System.out.println("Empleado creado correctamente. ");
    }
}
