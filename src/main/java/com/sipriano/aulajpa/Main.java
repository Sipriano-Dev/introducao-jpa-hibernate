package com.sipriano.aulajpa;

import com.sipriano.aulajpa.dominio.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "Carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Silva", "Joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria SAntos", "Maria@gmail.com");

        EntityManager em = null;
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa")) {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Pronto!");

    }
}