package projeto_prog_ii.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;

import java.util.Scanner;

@RestController
public class ProfessorController {

    @Autowired
    public ProfessorController(ProfessorService service){
        this.service = service; }
    private ProfessorService service;

    private Scanner sc = new Scanner(System.in);

    public void cadastrar(){
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite sua matéria:");
        String materia = sc.nextLine();

        Professor p = new Professor(nome, idade, materia);

        System.out.println("Professor cadastrado\n");
    }

    public void inserirNotas(){

        System.out.println("Digite o nome do aluno:");
        String nomeAluno = sc.nextLine();

        System.out.println("Digite a primeira nota:");
        double nota1 = sc.nextDouble();

        System.out.println("Digite a segunda nota:");
        double nota2 = sc.nextDouble();

        double media = service.calcularMedia(nota1, nota2);
        double mediaFinal = media;


        if(media < 7 && media >= 3){
            System.out.println("Digite a nota da final:");
            double nota3 = sc.nextDouble();
            mediaFinal = service.CalcularMediaFinal(media, nota3);
        }

        String situacao = service.situacao(media,mediaFinal);

        System.out.println("\nMédia final: " + mediaFinal);
        System.out.println("Situação: " + situacao);
        System.out.println(".");
        System.out.println("..");
        System.out.println("...");
        System.out.println("Dados do aluno cadastrados\n");


    }
}
