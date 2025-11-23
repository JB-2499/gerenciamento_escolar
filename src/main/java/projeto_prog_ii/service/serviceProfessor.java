package projeto_prog_ii.service;
import org.springframework.stereotype.Service;
@Service
public class serviceProfessor {

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
}