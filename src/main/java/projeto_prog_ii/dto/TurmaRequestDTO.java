package projeto_prog_ii.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record TurmaRequestDTO(
        @NotBlank(message = "O nome não pode estar vazio.")
        String nome,
        Long professorId) {}