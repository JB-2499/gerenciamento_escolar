package projeto_prog_ii.dto;

import jakarta.validation.constraints.*;

public record ProfessorRequestDTO(
        @NotBlank(message = "O nome não pode estar vazio.")
        String nome,

        @NotBlank(message = "A matéria não pode estar vazia.")
        String materia,

        @Min(value = 22, message = "A idade mínima é 22.")
        @Max(value = 99, message = "A idade máxima é 99.")
        int idade) {}