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

        Professor p  = new Professor( nome,  materia, idade);
        professor.add(p);

    }
    public void removerProfessor(Professor p){
        professor.remove(p);
    }
    public void alterarProfessor(Professor p){


        System.out.println("Digite o nome do professor que deseja alterar: ");
        String P =  sc.nextLine();

        System.out.println("digite qual dado voce deseja alterar:\n[1] Nome\n[2] Materia\n[3] Idade");
        String escolha =  sc.nextLine().toLowerCase();

        switch (escolha){

            case "1" , "nome":
                professor.set(0, p);
                break;

            case "2" , "materia":
                professor.set(1, p);
                break;

            case "3" , "idade":
                professor.set(2, p);
                break;

            default:
                    System.out.println("Ops! opção invalida");
        }

    }


}
