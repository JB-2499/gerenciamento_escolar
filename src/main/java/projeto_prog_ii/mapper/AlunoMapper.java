package projeto_prog_ii.mapper;

import org.springframework.stereotype.Component;
import projeto_prog_ii.dto.AlunoRequestDTO;
import projeto_prog_ii.dto.AlunoResponseDTO;
import projeto_prog_ii.model.Aluno;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setIdade(dto.idade());
        aluno.setEstado(dto.estado());
        aluno.setMedia(dto.media());
        return aluno;
    }

    public AlunoResponseDTO toResponse(Aluno aluno) {
        Long turmaId = aluno.getTurma() != null ? aluno.getTurma().getId() : null;
        return new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getIdade(),
                aluno.isEstado(), aluno.getMedia(), turmaId);
    }
}