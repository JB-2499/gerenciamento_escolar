package projeto_prog_ii.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.repository.ProfessorRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    private Professor buscarPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado (id " + id + ")."));
    }

    public Professor createProfessores(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor getProfessor(Long id) {
        return buscarPorId(id);
    }

    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    public Professor updateProfessores(Long id, Professor professorAtualizado) {
        Professor existente = buscarPorId(id);
        existente.setNome(professorAtualizado.getNome());
        existente.setMateria(professorAtualizado.getMateria());
        existente.setIdade(professorAtualizado.getIdade());
        return professorRepository.save(existente);
    }

    @Transactional
    public void delete(Long id) {
        Professor professor = buscarPorId(id);
        professor.getTurmas().forEach(turma -> turma.setProfessor(null));
        professorRepository.delete(professor);
    }
}