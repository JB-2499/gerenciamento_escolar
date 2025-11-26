package projeto_prog_ii.repository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import projeto_prog_ii.model.Professor;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Repository

public class ProfessorRepository {

    private List<Professor> listaProfessores = new ArrayList<>();
    public void adicionar(Professor p) {
        listaProfessores.add(p);

    }

}
