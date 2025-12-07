package projeto_prog_ii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto_prog_ii.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}