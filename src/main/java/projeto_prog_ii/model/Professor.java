package projeto_prog_ii.model;
import java.util.ArrayList;
import java.util.Scanner;
import lombok.Setter;
import lombok.Getter;

public class Professor {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Professor> professor = new ArrayList<Professor>();
    private String nome, materia;
    private int idade;
    private double nota1, nota2, nota3;

    Professor(String nome, String materia, int idade) {
        this.nome = nome;
        this.materia = materia;
        this.idade = idade;
    }

    Professor p  = new Professor(nome,materia,idade);




}
