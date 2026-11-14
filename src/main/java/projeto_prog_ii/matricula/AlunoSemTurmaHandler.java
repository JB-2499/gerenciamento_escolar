package projeto_prog_ii.matricula;

import projeto_prog_ii.exception.ConflictException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;

public class AlunoSemTurmaHandler extends MatriculaHandler {

    @Override
    protected void verificar(Aluno aluno, Turma turma) {
        Turma atual = aluno.getTurma();
        if (atual == null) {
            return;
        }
        if (atual.getId().equals(turma.getId())) {
            throw new ConflictException("O aluno já está matriculado nessa turma.");
        }
        throw new ConflictException("O aluno já está matriculado em outra turma. Use a transferência.");
    }
}