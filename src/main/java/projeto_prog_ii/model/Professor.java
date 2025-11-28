package projeto_prog_ii.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome, materia;
    private int idade;
    private double nota1, nota2, nota3;

    public Professor(String nome,int idade , String materia) {
        this.nome = nome;
        this.materia = materia;
        this.idade = idade;

    }

}
