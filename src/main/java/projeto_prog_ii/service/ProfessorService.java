package projeto_prog_ii.service;
import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.repository.ProfessorRepository;
import java.util.List;

@Service
public class ProfessorService {
private final ProfessorRepository professorRepository;
public ProfessorService(ProfessorRepository professorRepository) {

    this.professorRepository = professorRepository;
}
//create
public Professor save(Professor professor){

        return professorRepository.save(professor);
    }
//read
public List<Professor> getProfessores() {

    return professorRepository.findAll();
}
//delete
public void delete(Long id){

    professorRepository.deleteById(id);
}

}