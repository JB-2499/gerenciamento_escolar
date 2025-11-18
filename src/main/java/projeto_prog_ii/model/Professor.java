package projeto_prog_ii.model;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void CadastroProfessor(){
        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.println("Digite seu materia: ");
        materia = sc.nextLine();
        System.out.println("Digite sua idade: ");
        idade = sc.nextInt();
        professor.add(new Professor( nome,  materia, idade));

    }
    public void removerProfessor(Professor p){
        professor.remove(p);
    }


}
