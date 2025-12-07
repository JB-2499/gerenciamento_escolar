package projeto_prog_ii.model;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Tb_Professor")

public class Professor {

    @ManyToMany(mappedBy = "professores")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Turma> turmas = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "A matéria não pode estar vazia.")
    private String materia;

    @Min(value = 22, message = "A idade mínima é 22.")
    @Max(value = 99, message = "A idade máxima é 99.")
    private int idade;

}
