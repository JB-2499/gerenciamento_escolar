package projeto_prog_ii.matricula;

import org.junit.jupiter.api.Test;
import projeto_prog_ii.exception.BusinessRuleException;
import projeto_prog_ii.exception.ConflictException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;

import static org.junit.jupiter.api.Assertions.*;

class RegrasMatriculaTest {

    private final RegrasMatricula regras = new RegrasMatricula();

    private Turma turma(long id, int quantidadeAlunos) {
        Turma turma = new Turma();
        turma.setId(id);
        for (int i = 0; i < quantidadeAlunos; i++) {
            turma.getAlunos().add(new Aluno());
        }
        return turma;
    }

    @Test
    void alunoLivreETurmaComVaga_passa() {
        assertDoesNotThrow(() -> regras.validarMatricula(new Aluno(), turma(1, 5)));
    }

    @Test
    void alunoJaNaMesmaTurma_lancaConflito() {
        Turma turma = turma(1, 5);
        Aluno aluno = new Aluno();
        aluno.setTurma(turma);

        ConflictException erro = assertThrows(ConflictException.class,
                () -> regras.validarMatricula(aluno, turma));
        assertTrue(erro.getMessage().contains("nessa turma"));
    }

    @Test
    void alunoEmOutraTurma_lancaConflito() {
        Aluno aluno = new Aluno();
        aluno.setTurma(turma(2, 0));

        ConflictException erro = assertThrows(ConflictException.class,
                () -> regras.validarMatricula(aluno, turma(1, 5)));
        assertTrue(erro.getMessage().contains("outra turma"));
    }

    @Test
    void turmaLotada_lancaRegraDeNegocio() {
        assertThrows(BusinessRuleException.class,
                () -> regras.validarMatricula(new Aluno(), turma(1, 40)));
    }

    @Test
    void turmaComUmaVaga_passa() {
        assertDoesNotThrow(() -> regras.validarMatricula(new Aluno(), turma(1, 39)));
    }

    @Test
    void transferencia_aceitaAlunoComTurma_maBarraDestinoLotado() {
        Aluno aluno = new Aluno();
        aluno.setTurma(turma(2, 3));

        assertDoesNotThrow(() -> regras.validarTransferencia(aluno, turma(1, 10)));
        assertThrows(BusinessRuleException.class,
                () -> regras.validarTransferencia(aluno, turma(1, 40)));
    }
}