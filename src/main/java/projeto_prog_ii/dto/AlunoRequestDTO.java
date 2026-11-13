package projeto_prog_ii.dto;

import jakarta.validation.constraints.*;

public record AlunoRequestDTO(
        @NotBlank(message = "O nome não pode estar vazio.")
        String nome,

        @Min(value = 10, message = "A idade mínima é 10.")
        @Max(value = 18, message = "A idade máxima é 18.")
        int idade,

        boolean estado,

        @DecimalMin(value = "0.0", message = "A média mínima é 0.")
        @DecimalMax(value = "10.0", message = "A média máxima é 10.")
        double media) {}