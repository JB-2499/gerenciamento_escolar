package projeto_prog_ii.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Alunos")
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

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;
}