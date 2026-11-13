package projeto_prog_ii.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto_prog_ii.exception.ConflictException;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;
import projeto_prog_ii.repository.TurmaRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorService professorService;

    private Turma buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada (id " + id + ")."));
    }

    public Turma createTurma(Turma turma, Long professorId) {
        turma.setProfessor(professorId != null ? professorService.getProfessor(professorId) : null);
        return turmaRepository.save(turma);
    }

    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    public Turma buscarTurma(Long id) {
        return buscarPorId(id);
    }

    public Turma updateTurma(Long id, Turma dados, Long professorId) {
        Turma turma = buscarPorId(id);
        turma.setNome(dados.getNome());
        turma.setProfessor(professorId != null ? professorService.getProfessor(professorId) : null);
        return turmaRepository.save(turma);
    }

    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deleteTurma(Long id) {
        Turma turma = buscarPorId(id);
        if (!turma.getAlunos().isEmpty()) {
            throw new ConflictException(
                    "A turma possui alunos matriculados. Transfira ou remova os alunos antes de excluí-la.");
        }
        turmaRepository.delete(turma);
    }

    public double calcularMediaTurma(Long turmaId) {
        return buscarPorId(turmaId).getAlunos().stream()
                .mapToDouble(Aluno::getMedia)
                .average()
                .orElse(0.0);
    }

    public Aluno searchAlunoTurma(Long turmaId, Long alunoId) {
        return buscarPorId(turmaId).getAlunos().stream()
                .filter(aluno -> aluno.getId().equals(alunoId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Aluno não encontrado nesta turma (id " + alunoId + ")."));
    }
}