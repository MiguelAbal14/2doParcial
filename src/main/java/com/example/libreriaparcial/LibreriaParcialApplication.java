package com.example.libreriaparcial;

import com.example.libreriaparcial.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

@SpringBootApplication
public class LibreriaParcialApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibreriaParcialApplication.class, args);
    }

    {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaAppPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Autor autor = Autor.builder()
                    .nombre("Dale")
                    .apellido("Carneggie")
                    .biografia("cualquiera padre")
                    .build();

            Libro libro = Libro.builder()
                    .fecha(0)
                    .genero("Humanidades")
                    .paginas(186)
                    .titulo("Como hacer amigos e influenciar en las personsa")
                    .build();

            Localidad localidad = Localidad.builder()
                    .denominacion("consectetur")
                    .build();

            Domicilio domicilio = Domicilio.builder()
                    .calle("Francisco Villagra 2613")
                    .numero(123)
                    .localidad(localidad)
                    .build();

            Persona persona = Persona.builder()
                    .apellido("Miguel")
                    .nombre("Abal")
                    .dni(39137447)
                    .domicilio(domicilio)
                    .build();

            libro.getAutores().add(autor);
            persona.getLibros().add(libro);

            em.persist(autor);
            em.persist(libro);
            em.persist(localidad);
            em.persist(domicilio);
            em.persist(persona);
            em.flush();
            em.getTransaction().commit();

        } catch (
                Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showConfirmDialog(null, e);
        }
        em.close();
        emf.close();


    }
}
