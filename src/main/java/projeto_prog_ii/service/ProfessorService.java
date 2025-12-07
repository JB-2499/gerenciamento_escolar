package projeto_prog_ii.service;

import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.repository.ProfessorRepository;
import java.util.List;

@Service
public class ProfessorService {

    //Injeção e Construtores
    private final ProfessorRepository professorRepository;
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor createProfessores(Professor professor){
        return professorRepository.save(professor);
    }
    //Owerload
    public Professor readProfessores(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }
    public List<Professor> readProfessores() {
        return professorRepository.findAll();
    }

    public Professor updateProfessores(Long id, Professor professorAtualizado) {
        Professor existente = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        existente.setNome(professorAtualizado.getNome());
        existente.setMateria(professorAtualizado.getMateria());
        existente.setIdade(professorAtualizado.getIdade());

        return professorRepository.save(existente);
    }

    public void delete(Long id){
        professorRepository.deleteById(id);
    }
}
