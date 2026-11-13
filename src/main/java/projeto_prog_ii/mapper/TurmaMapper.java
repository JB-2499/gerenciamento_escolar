package projeto_prog_ii.mapper;

import org.springframework.stereotype.Component;
import projeto_prog_ii.dto.*;
import projeto_prog_ii.model.Turma;

import java.util.List;

@Component
public class TurmaMapper {

    public Turma toEntity(TurmaRequestDTO dto) {
        Turma turma = new Turma();
        turma.setNome(dto.nome());
        return turma;
    }

    public TurmaResponseDTO toResponse(Turma turma) {
        ProfessorResumoDTO professor = turma.getProfessor() == null ? null
                : new ProfessorResumoDTO(turma.getProfessor().getId(), turma.getProfessor().getNome());
        List<AlunoResumoDTO> alunos = turma.getAlunos().stream()
                .map(a -> new AlunoResumoDTO(a.getId(), a.getNome()))
                .toList();
        return new TurmaResponseDTO(turma.getId(), turma.getNome(), professor,
                turma.getQuantidadeAlunos(), alunos);
    }
}