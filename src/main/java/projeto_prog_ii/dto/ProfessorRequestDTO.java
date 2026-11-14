package projeto_prog_ii.dto;

import jakarta.validation.constraints.*;

public record ProfessorRequestDTO(
        @NotBlank(message = "O nome não pode estar vazio.")
        String nome,

        @NotBlank(message = "A matéria não pode estar vazia.")
        String materia,

        @Min(value = 20, message = "A idade mínima é 20.")
        @Max(value = 70, message = "A idade máxima é 70.")
        int idade) {}