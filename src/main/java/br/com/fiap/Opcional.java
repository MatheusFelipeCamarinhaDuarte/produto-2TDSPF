package br.com.fiap;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_2TDSPF_OPCIONAL")
public class Opcional {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPCIONAL")
    @SequenceGenerator(name = "SQ_OPCIONAL", sequenceName = "SQ_OPCIONAL", initialValue = 1, allocationSize = 50)
    @Column(name = "ID_OPCIONAL")
    private Long id;
    @Column(name = "NM_OPCIONAL")
    private String nome;
    @Column(name = "PRECO")
    private double preco;

    public Opcional(){

    }

    public Opcional(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public Opcional setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Opcional setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public double getPreco() {
        return preco;
    }

    public Opcional setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    @Override
    public String toString() {
        return "Opcional{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
