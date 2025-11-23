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
    private List<Professor> listaProfessores =  new ArrayList<>();

    public void adicionarProfessor(Professor p) {
        listaProfessores.add(p);
    }

    public void situacaoAluno(double media, double mediaFinal){
        String situacao;

    if(media>=7 || mediaFinal>=5){
        situacao="Aprovado";
    }
    else {
        situacao = "Reprovado";
    }
}
    public double calcularMedia(double nota1, double nota2) {

        return (nota1 + nota2) / 2;
    }
    
    public double calcularMediaFinal(double media, double nota3) {
    return (media + nota3) / 2;
    }

}