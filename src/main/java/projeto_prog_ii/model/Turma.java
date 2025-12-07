package projeto_prog_ii.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O nome não pode estar vazio!")
    private String nome;

    @Min(value = 20, message = "A quantidade mínima é 20 alunos por turma.")
    @Max(value = 40, message = "A quantidade máxima é 40 alunos por turma.")
    private int quantiaAluno;

    //Tipo de relacionamento com a classe professor
    /*@ManyToMany
    @JoinTable(
            name = "turma_professor",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professores;*/
    //Tipo de relacionamento com a classe aluno
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Aluno> alunos = new ArrayList<>();
}