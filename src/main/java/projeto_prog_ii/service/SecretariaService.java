package projeto_prog_ii.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.model.Turma;

@Service
@RequiredArgsConstructor
public class SecretariaService {
    private final TurmaService turmaService;
    private final ProfessorService professorService;
    private final AlunoService alunoService;

    public Turma matricularAluno(long turmaId, long alunoId){
        Turma turma = turmaService.buscarTurma(turmaId);
        Aluno aluno = alunoService.readAluno(alunoId);

        if (turma.getAlunos().contains(aluno)){
            throw new IllegalArgumentException("Aluno já cadastrado nessa turma");
        }

        turma.getAlunos().add(aluno);
        aluno.setTurma(turma);

        turmaService.atualizarQuantiAluno(turmaId);
        turmaService.salvarTurma(turma);
        return turma;
    }

    public String transferirAluno(long alunoId, Long turmaOrigemId, long turmaDestinoId){
        Turma origem = turmaService.buscarTurma(turmaOrigemId);
        Turma destino = turmaService.buscarTurma(turmaDestinoId);
        Aluno aluno = alunoService.readAluno(alunoId);

        if (turmaOrigemId.equals(turmaDestinoId)){
            throw new IllegalArgumentException("Para transferir, a turma de origem não pode ser a mesma de destino");
        }

        if (!origem.getAlunos().remove(aluno)){
            throw new ResourceNotFoundException("Este aluno não estava na turma de origem");
        }

        destino.getAlunos().add(aluno);
        aluno.setTurma(destino);

        turmaService.updateTurma(origem.getId(), origem);
        turmaService.updateTurma(destino.getId(), destino);

        return "transferência do(a) aluno(a) realizada com sucesso";
    }

    public Turma atribuirProf(long turmaId, Long professorId){
        Turma turma = turmaService.buscarTurma(turmaId);
        Professor professor = professorService.readProfessores(professorId);

        if (turma.getProfessores().contains(professor)){
            throw new IllegalArgumentException("Esse professor já está inserido nessa turma");
        }

        turma.getProfessores().add(professor);
        professor.getTurmas().add(turma);
        turmaService.atualizarQuantidadeProfessores(turma);
        turmaService.salvarTurma(turma);

        return turma;

    }

    public Turma createTurma(Turma turma){
        return turmaService.createTurma(turma);
    }

    public void deleteTurma(Long id){
        turmaService.deleteTurma(id);
    }

    public int contarAlunosTurma(Long turmaId){
        return turmaService.contarAlunos(turmaId);
    }
}
