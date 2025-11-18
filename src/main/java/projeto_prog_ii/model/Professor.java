package projeto_prog_ii.model;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor {
    Scanner sc = new Scanner(System.in);
    ArrayList<Professor> professor = new ArrayList<Professor>();
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

    public void CadastarNotas(String nomeAluno){

        System.out.println("Digite a primeira nota: ");
        nota1 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a segunda nota: ");
        nota2 = sc.nextDouble();
        sc.nextLine();

        double media = (nota1 + nota2) / 2;

        if (media >= 7){
             String situacao = "Aprovado";
            Alunos.add(situacao,);
            Alunos.add(media);
        }
        else if (media<7 || media>3) {

            System.out.println("Digite a nota da final: ");
            nota3 = sc.nextDouble();
            sc.nextLine();

            media = ( media + nota3 ) / 2 ;

            if(media < 5){
                String situacao = "Reprovado"
                Alunos.add(situacao,);
                Alunos.add(media);
            }
            else{
                String situacao = "Aprovado";
                Alunos.add(situacao,);
                Alunos.add(media);
            }

        }
        else{
            String situacao = "Reprovado";
            Alunos.add(situacao,);
            Alunos.add(media);
        }



    }
}
