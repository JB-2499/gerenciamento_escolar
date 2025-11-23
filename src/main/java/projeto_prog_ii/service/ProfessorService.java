package projeto_prog_ii.service;
import org.springframework.stereotype.Service;
@Service
public class ProfessorService {
    @Autowired


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
