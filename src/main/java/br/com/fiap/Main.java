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

        Produto produto = new Produto();
        produto.setNome("NoteBook HP").setPreco(50.99);

        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();


        factory.close();
        manager.close();


    }
}
