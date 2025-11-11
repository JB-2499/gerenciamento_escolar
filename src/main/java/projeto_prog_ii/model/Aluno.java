package projeto_prog_ii.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome, turma, situacao;
    private int idade;
    private List<Double> notas;
}