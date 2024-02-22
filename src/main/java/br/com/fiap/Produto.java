package br.com.fiap;

import jakarta.persistence.*;

@Entity
@Table (name = "TB_2TDSPF_PROUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", initialValue = 1, allocationSize = 50)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO")
    private String nome;

    @Column(name = "PRECO")
    private double preco;

    @ManyToOne
    @JoinColumn(
            name = "SABOR",
            referencedColumnName = "ID_SABOR",
            foreignKey = @ForeignKey(name = "KF_SABOR_PRODUTO")
    )
    private Sabor sabor;


    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }


    public Produto() {
    }

    public Produto(Long id, String nome, double preco, Sabor sabor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public Produto setPreco(Double preco) {
        this.preco = preco;
        return this;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", sabor=" + sabor +
                '}';
    }
}

