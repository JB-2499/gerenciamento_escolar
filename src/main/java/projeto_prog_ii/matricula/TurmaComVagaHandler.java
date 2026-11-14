package projeto_prog_ii.matricula;

import projeto_prog_ii.exception.BusinessRuleException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;

public class TurmaComVagaHandler extends MatriculaHandler {

    public static final int CAPACIDADE_MAXIMA = 40;

    @Override
    protected void verificar(Aluno aluno, Turma turma) {
        if (turma.getQuantidadeAlunos() >= CAPACIDADE_MAXIMA) {
            throw new BusinessRuleException(
                    "A turma está lotada (máximo de " + CAPACIDADE_MAXIMA + " alunos).");
        }
    }
}