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

        EntityManager em;
        Pessoa p;
        //Instanciando no try with resource
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa")) {

            em = emf.createEntityManager();
            //Quando vai usar o banco sem ser consulta, usa-se transação, tipo inserir ou deletar
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.getTransaction().commit();

            //Consulta não precisa de transação
            p = em.find(Pessoa.class, 2);

            em.getTransaction().begin();
            em.remove(p3);//Pra remover tem que estar monitorado, acabou de inserir (como é o caso) ou buscou no banco
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(p);
        System.out.println("Pronto!");

        em.close();

    }
}