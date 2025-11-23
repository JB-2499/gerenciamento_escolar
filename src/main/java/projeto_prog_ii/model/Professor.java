package projeto_prog_ii.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Professor {

    String nome, materia;
    private int idade;
    private double nota1, nota2, nota3;

    public Professor(String nome,int idade , String materia) {
        this.nome = nome;
        this.materia = materia;
        this.idade = idade;
    }

}
