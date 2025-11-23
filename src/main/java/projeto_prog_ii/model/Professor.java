package projeto_prog_ii.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor //aqui cria automaticameente os constructos sem os parametros
@AllArgsConstructor //aqui cria automaticameente os constructos com os parametros
@Getter @Setter

public class Professor {

    String nome, materia;
    private int idade;
    private double nota1, nota2, nota3;

}
