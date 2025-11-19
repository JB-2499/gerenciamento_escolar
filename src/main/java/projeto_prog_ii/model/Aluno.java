package projeto_prog_ii.model;

import lombok.Getter;
import lombok.Setter;

public class Aluno {
    @Getter @Setter private String nome, turma;
    @Getter @ Setter private int idade;
    @Getter @ Setter private double media;
    @Getter @ Setter private boolean situacao;

    public Aluno(String nome, String turma, int idade, double media, boolean situacao) {
        this.nome = nome;
        this.turma = turma;
        this.idade = idade;
        this.media = media;
        this.situacao = situacao;
    }

    public String situacao() {
        String situacao = "";
        if (this.situacao) {
            situacao = "Aprovado";
        } else {
            situacao = "Reprovado";
        }
        return "Média do aluno: " + this.media + "\nSituação do aluno: " + situacao;
    }
}