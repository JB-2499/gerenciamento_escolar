package projeto_prog_ii.mapper;

import org.springframework.stereotype.Component;
import projeto_prog_ii.dto.ProfessorRequestDTO;
import projeto_prog_ii.dto.ProfessorResponseDTO;
import projeto_prog_ii.model.Professor;

@Component
public class ProfessorMapper {

    public Professor toEntity(ProfessorRequestDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setMateria(dto.materia());
        professor.setIdade(dto.idade());
        return professor;
    }

    public ProfessorResponseDTO toResponse(Professor professor) {
        return new ProfessorResponseDTO(professor.getId(), professor.getNome(),
                professor.getMateria(), professor.getIdade());
    }
}