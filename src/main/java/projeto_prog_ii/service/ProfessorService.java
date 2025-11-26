package projeto_prog_ii.service;
import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.repository.ProfessorRepository;


@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public double CalcularMedia(double nota1, double nota2){

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

    public Professor EncontrarProfessor(String p) {

        for (int i = 0; i < professorRepository.getListaProfessores().size(); i++)
            if (p.equalsIgnoreCase(professorRepository.getListaProfessores().get(i).getNome())) {
                return professorRepository.getListaProfessores().get(i);
            }
        return  null;

    }
}