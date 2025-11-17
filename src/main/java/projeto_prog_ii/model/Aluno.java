package projeto_prog_ii.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Aluno {

    private String nome;
    private int idade;

    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    Scanner sc = new Scanner(System.in);

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;

    }

    //metodos da classe

    public void cadastrarAluno(){

        System.out.println("Digite o nome do aluno: ");
        nome = sc.nextLine();

        System.out.println("Digite a idade do aluno: ");
        idade = sc.nextInt();
        sc.nextLine();

        Aluno a = new Aluno(nome,idade);
        alunos.add(a);
    }
    public void DadosAlunos(){
        for (Aluno aluno : alunos){
            System.out.println(aluno);
        }
    }
    public void excluirAluno(){
        System.out.printf("Digite o aluno que deseja excluir: ");
        String excluir  = sc.nextLine();
    }


}

