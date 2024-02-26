package br.com.fiap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String dia = LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY) ? "fiap" : "casa";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(dia);
        EntityManager manager = factory.createEntityManager();

        Sabor s1 = new Sabor();
        s1.setNome("Manjericão").setDescricao("Ótimo");


        Opcional bordaDeCatuaba = new Opcional(null, "Borda de catuaba", 99.99);
        Opcional bordaDeCatupiri = new Opcional(null, "Borda de catupiri", 9.99);
        Opcional cocaCola = new Opcional(null, "Coca Cola", 19.99);
        Opcional cocaina = new Opcional(null, "Cocaína", 19.99);


        Set<Opcional> opcionais = Stream.of(cocaCola, bordaDeCatuaba, bordaDeCatupiri).collect(Collectors.toSet());

        Produto p1 = new Produto();
        p1.setNome("Pizza");
        p1.setPreco(59.99);
        p1.setSabor( s1 );



        Sabor s2 = new Sabor();
        s2.setNome("Calabreso").setDescricao("Gostoso");

        Produto p2 = new Produto();
        p2.setNome("Coxinha");
        p2.setPreco(5.99);
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
