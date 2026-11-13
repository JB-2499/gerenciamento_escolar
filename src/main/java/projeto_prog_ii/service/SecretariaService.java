package projeto_prog_ii.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto_prog_ii.exception.BusinessRuleException;
import projeto_prog_ii.exception.ConflictException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.model.Turma;

@Service
@Transactional
@RequiredArgsConstructor
public class SecretariaService {

    private static final int CAPACIDADE_MAXIMA = 40;

    private final TurmaService turmaService;
    private final ProfessorService professorService;
    private final AlunoService alunoService;

    public Turma matricularAluno(long turmaId, long alunoId) {
        Turma turma = turmaService.buscarTurma(turmaId);
        Aluno aluno = alunoService.getAluno(alunoId);

        if (aluno.getTurma() != null) {
            if (aluno.getTurma().getId().equals(turmaId)) {
                throw new ConflictException("O aluno já está matriculado nessa turma.");
            }
            throw new ConflictException(
                    "O aluno já está matriculado em outra turma. Use a transferência.");
        }
        if (turma.getQuantidadeAlunos() >= CAPACIDADE_MAXIMA) {
            throw new BusinessRuleException(
                    "A turma está lotada (máximo de " + CAPACIDADE_MAXIMA + " alunos).");
        }

        aluno.setTurma(turma);          // lado dono: é isso que grava no banco
        turma.getAlunos().add(aluno);   // mantém a lista em memória coerente para a resposta
        return turma;
    }

    public String transferirAluno(long alunoId, long turmaOrigemId, long turmaDestinoId) {
        if (turmaOrigemId == turmaDestinoId) {
            throw new BusinessRuleException(
                    "A turma de origem não pode ser a mesma de destino.");
        }

        Turma origem = turmaService.buscarTurma(turmaOrigemId);
        Turma destino = turmaService.buscarTurma(turmaDestinoId);
        Aluno aluno = alunoService.getAluno(alunoId);

        if (aluno.getTurma() == null || !aluno.getTurma().getId().equals(turmaOrigemId)) {
            throw new BusinessRuleException("Este aluno não está na turma de origem.");
        }
        if (destino.getQuantidadeAlunos() >= CAPACIDADE_MAXIMA) {
            throw new BusinessRuleException(
                    "A turma de destino está lotada (máximo de " + CAPACIDADE_MAXIMA + " alunos).");
        }

        aluno.setTurma(destino);
        origem.getAlunos().removeIf(a -> a.getId().equals(alunoId));
        destino.getAlunos().add(aluno);

        return "Transferência do(a) aluno(a) realizada com sucesso.";
    }

    public Turma atribuirProf(long turmaId, long professorId) {
        Turma turma = turmaService.buscarTurma(turmaId);
        Professor professor = professorService.getProfessor(professorId);

        if (turma.getProfessor() != null) {
            throw new ConflictException(
                    "A turma já possui um professor. Use a troca de professor.");
        }

        turma.setProfessor(professor);
        return turma;
    }

    public Turma trocarProfessor(long turmaId, long novoProfessorId) {
        Turma turma = turmaService.buscarTurma(turmaId);
        Professor novo = professorService.getProfessor(novoProfessorId);

        Professor atual = turma.getProfessor();
        if (atual != null && atual.getId().equals(novoProfessorId)) {
            throw new ConflictException("O novo professor já é o professor da turma.");
        }

        turma.setProfessor(novo);
        return turma;
    }

    public Turma removerProf(long turmaId) {
        Turma turma = turmaService.buscarTurma(turmaId);
        turma.setProfessor(null);
        return turma;
    }
}