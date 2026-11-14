package projeto_prog_ii.matricula;

import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;

public abstract class MatriculaHandler {

    private MatriculaHandler proximo;

    public MatriculaHandler setProximo(MatriculaHandler proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public void validar(Aluno aluno, Turma turma) {
        verificar(aluno, turma);
        if (proximo != null) {
            proximo.validar(aluno, turma);
        }
    }

    protected abstract void verificar(Aluno aluno, Turma turma);
}