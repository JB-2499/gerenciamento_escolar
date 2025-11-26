package projeto_prog_ii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projeto_prog_ii.controller.Aluno_controller;
import projeto_prog_ii.model.Aluno;

import java.util.Scanner;

@Component
public class Menu {
    @Autowired
    private Aluno_controller aluno_controller;

    private final Scanner sc = new Scanner(System.in);

    public Aluno criarAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.println("Digite a turma do aluno: ");
        String turma = sc.nextLine();

        System.out.println("Digite a idade do aluno: ");
        int idade = sc.nextInt();

        System.out.println("Digite o estado do aluno: ");
        boolean estado = sc.nextBoolean();

        System.out.println("Digite a média do aluno: ");
        double media = sc.nextDouble();

        return new Aluno(nome, turma, idade, estado, media);
    }

    public void menu() {
        while (true) {
            System.out.println("\nBem-vindo ao menu de testes!!!");
            System.out.println("______________________ ______________________");
            System.out.println("|1 - Registrar aluno | |2 - Atualizar dados |");
            System.out.println("|3 -  Buscar aluno   | |4 -  Remover aluno  |");
            System.out.println("|5 -  Listar alunos  | |6 -      Sair       |");
            System.out.println("|--------------------| |--------------------|");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Aluno aluno = criarAluno();
                    aluno_controller.registerAluno(aluno);
                    System.out.println("Aluno registrado com sucesso!");
                    break;
            }
        }
    }
}