package projeto_prog_ii.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "Tb_Turma")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O nome não pode estar vazio!")
    private String nome;

    @Min(value = 20, message = "A quantidade mínima é 20 alunos por turma.")
    @Max(value = 40, message = "A quantidade máxima é 40 alunos por turma.")
    private int quantiaAluno;
    private int quantidadeProfessor;

    //Tipo de relacionamento com a classe professor
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")

    private Professor professor;

    //Tipo de relacionamento com a classe aluno
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private List<Aluno> alunos = new ArrayList<>();
}