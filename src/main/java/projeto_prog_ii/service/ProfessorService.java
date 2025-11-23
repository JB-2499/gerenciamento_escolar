package projeto_prog_ii.service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Professor;

import java.util.ArrayList;

@Getter @Setter @Service @AllArgsConstructor @NoArgsConstructor
public class ProfessorService {

    public String situacaoAluno(double media, double mediaFinal){
    String situacao;

    if(media>=7){
        situacao="Aprovado";
    }
    else if(media < 3){
        situacao="Reprovado";
    }
    else{
        if (mediaFinal<5){
            situacao="Reprovado";
        }
        else{
            situacao="Aprovado";
        }
    }
    return situacao;
}
    public double calcularMedia(double nota1, double nota2) {
        return (nota1 + nota2) / 2;

    }
    public double calcularMediaFinal(double media, double nota3) {

    if (media < 3 || media >= 7) {
            return media;
        }
    double mediaFinal=(media + nota3) / 2;

    return mediaFinal;
    }

    private ArrayList<Professor> ListaProfessor = new ArrayList<Professor>();
}