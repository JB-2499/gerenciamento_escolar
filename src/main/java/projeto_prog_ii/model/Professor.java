package projeto_prog_ii.model;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Professor {

    Scanner sc = new Scanner(System.in);
    ArrayList<Professor> professores = new ArrayList<>();

    private String nome, materia;
    private int idade;
    private double nota1, nota2, nota3;
    private boolean situacao;
    //Metodos

    public void CadastroProfessor(){

    }

    public void cadastrarNotas(){
        System.out.printf("Digite o nome do aluno: ");
        nome = sc.nextLine();

        System.out.printf("Digite o materia do aluno: ");
        materia = sc.nextLine();

        System.out.printf("Digite a nota da primeira avaliação do aluno: ");
        nota1 = sc.nextDouble();
        sc.nextLine();

        System.out.printf("Digite a nota do aluno: ");
        nota2 = sc.nextDouble();

        if ((nota1+nota2)/2<7 || nota1+nota2/2>3){

            System.out.println("Digite a nota da final do aluno");
            nota3 = sc.nextDouble();
            sc.nextLine();

            if((nota3+((nota1+nota2)/2)/2)>5){
                situacao = true;
            }
            else{
                situacao = false;
            }
            }
        else if ((nota1+nota2)/2>=7) {
            situacao = true;
        }
        else{
            situacao = false;
        }
    }
}
