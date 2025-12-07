package projeto_prog_ii.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Data
@Entity
@Table(name = "Tb_Professor")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Professor {

   @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Turma> turmas;

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
