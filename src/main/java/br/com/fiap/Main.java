package br.com.fiap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String dia = LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY) ? "fiap" : "casa";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(dia);
        EntityManager manager = factory.createEntityManager();

        Sabor s1 = new Sabor();
        s1.setNome("Manjericão").setDescricao("Ótimo");

        Produto p1 = new Produto();
        p1.setNome("Pizza").setPreco(59.99);
        p1.setSabor( s1 );

        Sabor s2 = new Sabor();
        s2.setNome("Calabreso").setDescricao("Gostoso");

        Produto p2 = new Produto();
        p2.setNome("Coxinha").setPreco(5.99);
        p2.setSabor( s2 );

        manager.getTransaction().begin();
        manager.persist(s1);
        manager.persist(s2);
        manager.persist(p1);
        manager.persist(p2);
        manager.getTransaction().commit();


        factory.close();
        manager.close();


    }
}
