package projeto_prog_ii.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto_prog_ii.model.Professor;
import java.util.ArrayList;
import java.util.List;
@Repository

public interface ProfessorRepository extends JpaRepository <Professor, Long>{
    List<Professor> listaProfessores = new ArrayList<>();



}
