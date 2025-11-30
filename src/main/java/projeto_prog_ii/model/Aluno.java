package projeto_prog_ii.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Aluno {
    @Id private long id;

    private String nome, turma;
    private int idade;
    private boolean estado;
    private double media;

    public Aluno() {}
}