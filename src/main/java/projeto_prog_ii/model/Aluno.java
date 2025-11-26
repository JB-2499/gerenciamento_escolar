package projeto_prog_ii.model;

import lombok.Getter;
import lombok.Setter;

public class Aluno {
    @Getter @Setter private long id;

    @Getter @Setter private String nome, turma;
    @Getter @Setter private int idade;
    @Getter @Setter private boolean estado;
    @Getter @Setter private double media;

    public Aluno(String nome, String turma, int idade, boolean estado, double media) {
        this.nome = nome;
        this.turma = turma;
        this.idade = idade;
        this.estado = estado;
        this.media = media;
    }
}