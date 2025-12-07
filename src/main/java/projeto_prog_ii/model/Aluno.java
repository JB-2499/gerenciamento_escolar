package projeto_prog_ii.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Tb_Aluno")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    private String nome;

    @Min(value = 10, message = "A idade mínima é 10.")
    @Max(value = 18, message = "A idade máxima é 18.")
    private int idade;

    private boolean estado;

    @DecimalMin(value = "0.0", message = "A média mínima é 0.")
    @DecimalMax(value = "10.0", message = "A média máxima é 10.")
    private double media;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id")
    private Turma turma;
}