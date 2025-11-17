package projeto_prog_ii.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Aluno {

    private String nome;
    private int idade,matricula;
    private double nota;

    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    Scanner sc = new Scanner(System.in);

    public void Cadastro(){
        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.println("Digite sua idade: ");
        idade = sc.nextInt();


    }



}

