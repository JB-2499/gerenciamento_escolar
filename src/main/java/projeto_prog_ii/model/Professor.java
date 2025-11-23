package projeto_prog_ii.model;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

@Getter @Setter
public class Professor {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Professor> professor = new ArrayList<Professor>();
    String nome, materia;
    private int idade;
    private double nota1, nota2, nota3;

    public Professor() {}

    Professor(String nome, String materia, int idade) {
        this.nome = nome;
        this.materia = materia;
        this.idade = idade;
    }

}
