package projeto_prog_ii.controller;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.internal.NativeEnumDdlTypeImpl;
import org.springframework.stereotype.Controller;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;

import java.util.Scanner;

@Controller @Getter @Setter
public class ProfessorController extends Professor {

    Scanner sc = new Scanner(System.in);

    public void cadastroProfessor(){
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite sua materia:");
        String materia = sc.nextLine();



    }
    public void cadastrarProfessor(String nome,int idade, String materia){
        setListaProfessor(ListaProfessor().add(nome));
    }
    public void inserirNotas(){
        System.out.println("Digite a primeira nota do aluno");
        double nota1 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a segunda nota do aluno");
        double nota2 = sc.nextDouble();
        if((nota1+nota2)<7 && (nota1+nota2)/2>=3){
            System.out.println("Digite a nota da final do aluno");
            double nota3 = sc.nextDouble();
        }



    }
    public void inserirNotas(double nota1, double nota2, double nota3){

    }



}
