package projeto_prog_ii.controller;

public class controlerProfessor {

    //  escolha o nome do aluno que quer cadastrar a nota, o nome da lista colocada para se adicionar foi para alunos
    public void CadastrarNotas(String nomeAluno){

        System.out.println("Digite a primeira nota: ");
        nota1 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a segunda nota: ");
        nota2 = sc.nextDouble();
        sc.nextLine();

        double media = (nota1 + nota2) / 2;

        if (media >= 7){
            String situacao = "Aprovado";
            Alunos.add(situacao,);
            Alunos.add(media);
        }
        else if (media<7 && media>3) {

            System.out.println("Digite a nota da final: ");
            nota3 = sc.nextDouble();
            sc.nextLine();

            media = ( media + nota3 ) / 2 ;

            if(media < 5){
                String situacao = "Reprovado"
                Alunos.add(situacao,);
                Alunos.add(media);
            }
            else{
                String situacao = "Aprovado";
                Alunos.add(situacao,);
                Alunos.add(media);
            }

        }
        else{
            String situacao = "Reprovado";
            Alunos.add(situacao);
            Alunos.add(media);
        }



    }
}
