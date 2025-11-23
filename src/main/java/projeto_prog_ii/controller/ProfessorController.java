package projeto_prog_ii.controller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;

import java.util.Scanner;

@Controller @Getter @Setter @AllArgsConstructor @NoArgsConstructor


public class ProfessorController {

    Scanner sc = new Scanner(System.in);
    private ProfessorService service;

    public void Cadastrar(){
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite sua materia:");
        String materia = sc.nextLine();

        Professor p = new Professor(nome, idade, materia);
        service.adicionarProfessor(p);
    }
    public void inserirNotas(double media, double mediaFinal){
        System.out.println("Digite a primeira nota do aluno");
        double nota1 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a segunda nota do aluno");
        double nota2 = sc.nextDouble();

        if(media <7 && media >=3){
            System.out.println("Digite a nota da final do aluno");
            double nota3 = sc.nextDouble();

        }

    }



}
