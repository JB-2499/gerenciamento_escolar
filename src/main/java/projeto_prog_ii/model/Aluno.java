package projeto_prog_ii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Aluno {
    private long id;

    private String nome, turma;
    private int idade;
    private boolean estado;
    private double media;
}