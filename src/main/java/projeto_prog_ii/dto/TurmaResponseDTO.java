package projeto_prog_ii.dto;


import java.util.List;

public record TurmaResponseDTO(
        Long id,
        String nome,
        ProfessorResumoDTO professor,
        int quantidadeAlunos,
        List<AlunoResumoDTO> alunos) {}