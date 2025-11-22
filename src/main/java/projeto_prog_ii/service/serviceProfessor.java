package projeto_prog_ii.service;
public class serviceProfessor {



    public void calcularMedia(double nota1, double nota2){

        double media;
        boolean situacao;

        media = (nota1 + nota2) / 2;

        if (media >= 3 && media <7) {
            situacao = false;
            if (media <5){
                situacao = false;}

            else {
                situacao = true;
            }
        }
        else if (media < 3) {
            situacao = false;
        }
        else {
            situacao = true;
        }


    }
}
