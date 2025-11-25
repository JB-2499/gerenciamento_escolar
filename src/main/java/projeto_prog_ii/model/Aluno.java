package projeto_prog_ii.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @Getter @Setter private String nome, turma;
    @Getter @Setter private int idade;
    @Getter @Setter private boolean estado;
    @Getter @Setter private double media;
}