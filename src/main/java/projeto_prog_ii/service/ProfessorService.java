package projeto_prog_ii.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Professor;
import java.util.ArrayList;
import java.util.List;
@Service
@Getter @Setter

public class ProfessorService {

    private List<Professor> listaProfessores = new ArrayList<>();

    //referente ao próprio professor
    public void adicionarProfessor(Professor p) {
        listaProfessores.add(p);
    }

    //referente a atribuição da nota dos alunos

    public double calcularMedia(double nota1, double nota2){

        return (nota1 + nota2) / 2;
    }
    public double CalcularMediaFinal(double media, double nota3){

        return (media + nota3) / 2;
    }
    public String situacao(double media, double mediaFinal){
        if(media >= 7) return "Aprovado";
        if(media < 3) return "Reprovado";
        if(mediaFinal >= 5) return "Aprovado na Final";
        return "Reprovado";
    }
}
