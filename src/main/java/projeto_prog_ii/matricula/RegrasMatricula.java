package projeto_prog_ii.matricula;

import org.springframework.stereotype.Component;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;

@Component
public class RegrasMatricula {

    private final MatriculaHandler cadeiaMatricula;
    private final MatriculaHandler cadeiaTransferencia;

    public RegrasMatricula() {
        // matrícula: aluno livre -> turma com vaga
        MatriculaHandler matricula = new AlunoSemTurmaHandler();
        matricula.setProximo(new TurmaComVagaHandler());
        this.cadeiaMatricula = matricula;

        // transferência: o aluno já tem turma, então só vale a regra da vaga (reuso do elo)
        this.cadeiaTransferencia = new TurmaComVagaHandler();
    }

    public void validarMatricula(Aluno aluno, Turma turma) {
        cadeiaMatricula.validar(aluno, turma);
    }

    public void validarTransferencia(Aluno aluno, Turma destino) {
        cadeiaTransferencia.validar(aluno, destino);
    }
}