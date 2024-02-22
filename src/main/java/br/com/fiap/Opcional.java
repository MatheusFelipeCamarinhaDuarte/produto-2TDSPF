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

}
