package projeto_prog_ii.controller;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;
import projeto_prog_ii.repository.repositoryProfessor;

import java.util.Scanner;
@RestController

@Getter
@Setter
public class controlerProfessor {

    Scanner sc = new Scanner(System.in);
    public  void inserirNotas(double nota1, double nota2, double nota3){

        System.out.println("Digite a primeira nota do aluno");
        nota1 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a segunda nota do aluno");
        nota2 = sc.nextDouble();



    }


}
