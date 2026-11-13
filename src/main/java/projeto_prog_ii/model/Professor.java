package projeto_prog_ii.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "professores")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    private String nome;

    private String materia;

    @Min(value = 20, message = "A idade mínima é 20.")
    @Max(value = 70, message = "A idade máxima é 70.")
    private int idade;

    @OneToMany(mappedBy = "professor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Turma> turmas = new ArrayList<>();
}