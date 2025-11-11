package projeto_prog_ii.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome, turma, situacao;
    private int idade;
    private List<Double> notas;

    public Aluno() {

    }
}