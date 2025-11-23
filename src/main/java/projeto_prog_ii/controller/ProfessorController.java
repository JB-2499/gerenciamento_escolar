package projeto_prog_ii.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;

import java.util.Scanner;

@Controller
@Getter @Setter
public class ProfessorController {

    @Autowired
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
        service.adicionarProfessor(p);

        System.out.println("Professor cadastrado\n");
    }

    public void inserirNotas(){

        System.out.println("Digite o nome do aluno:");
        String nomeAluno = sc.nextLine();

        System.out.println("Digite a primeira nota:");
        double n1 = sc.nextDouble();

        System.out.println("Digite a segunda nota:");
        double n2 = sc.nextDouble();

        double media = service.calcularMedia(n1, n2);

        double mediaFinal = media;

        if(media < 7 && media >= 3){
            System.out.println("Digite a nota da final:");
            double n3 = sc.nextDouble();

            mediaFinal = service.CalcularMediaFinal(media, n3);
        }

        String situacao = service.situacao(media, mediaFinal);

        System.out.println("\nMédia final: " + mediaFinal);
        System.out.println("Situação: " + situacao);
    }
}
