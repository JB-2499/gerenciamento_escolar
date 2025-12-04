package projeto_prog_ii.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private boolean estado;
    private double media;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;
}