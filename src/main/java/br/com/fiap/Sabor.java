package br.com.fiap;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_2TDSPF_SABOR")
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SABOR")
    @SequenceGenerator(name = "SQ_SABOR", sequenceName = "SQ_SABOR", initialValue = 1, allocationSize = 50)
    @Column(name = "ID_SABOR")
    private Long id;
    @Column(name = "NM_SABOR")
    private String nome; // frango com caipira
    @Column(name = "DS_SABOR")
    private String descricao; // o delicioso tempero que usamos na pizza de frango com catupiry é sem igual e etc.


    public Sabor() {
    }

    public Sabor(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public Sabor setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Sabor setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public String toString() {
        return "Sabor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
