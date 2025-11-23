package projeto_prog_ii.repository;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import projeto_prog_ii.model.Professor;
@Getter
@Setter
@Repository

public class repositoryProfessor {

    private List<Professor> listaProfessores = new ArrayList<>();

}
