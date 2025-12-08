package projeto_prog_ii.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;
import projeto_prog_ii.repository.AlunoRepository;
import projeto_prog_ii.repository.ProfessorRepository;
import projeto_prog_ii.repository.TurmaRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    //Injeção de dependência
    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    //Verificação de existência
    private Turma readTurma(Long id){
        return turmaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Turma não encontrada!"));
    }

    //Criando turma
    public Turma createTurma(Turma turma){
        //Ajustes com o relacionamento
        if (turma.getAlunos() != null){
            turma.getAlunos().forEach(aluno -> aluno.setTurma(turma));
        }
        if (turma.getProfessor() != null){
            turma.getProfessor().getTurmas().add(turma);
            turma.setQuantidadeProfessor(1);
        }else{
            turma.setQuantidadeProfessor(0);
        }

        atualizarQuantidadeAlunos(turma);

        return turmaRepository.save(turma);
    }

    //Lista todas as turmas
    public List<Turma>listarTurmas(){
        return turmaRepository.findAll();
    }

    //Busca por id
    public Turma buscarTurma(Long id){
        return readTurma(id);
    }

    private void validarQuantidadeAluno(Turma turma) {
        int quanti = turma.getAlunos() == null ? 0: turma.getAlunos().size();
        if (quanti < 10 || quanti > 40){
            throw new IllegalArgumentException("Quantidade de alunos invalida!");
        }
    }

    public void atualizarQuantidadeAlunos(Turma turma){
        validarQuantidadeAluno(turma);
        turma.setQuantiaAluno(turma.getAlunos() == null ? 0 : turma.getAlunos().size());
    }

    @Transactional
    public Turma updateTurma(Long id, Turma turmaAtualizada){
        Turma turmaExistente = readTurma(id);

        turmaExistente.getAlunos().forEach(aluno -> aluno.setTurma(null));
        turmaExistente.getAlunos().clear();

        if(turmaAtualizada.getAlunos() != null){
            turmaAtualizada.getAlunos().forEach(aluno ->{
                aluno.setTurma(turmaExistente);
                turmaExistente.getAlunos().add(aluno);
            });
        }

        turmaExistente.setProfessor(turmaAtualizada.getProfessor());
        turmaExistente.setQuantidadeProfessor(turmaAtualizada.getProfessor() != null ? 1 : 0);

        //Calcula a quantidade
        atualizarQuantidadeAlunos(turmaExistente);

        return turmaRepository.save(turmaExistente);
    }

    //Salva turma
    @Transactional
    public void salvarTurma(Turma turma){
        turmaRepository.save(turma);
    }

    //Deletar turma
    @Transactional
    public void deleteTurma(Long id){
        Turma turma = readTurma(id);
        turmaRepository.delete(turma);
    }

    //Calcula média geral da turma
    public double calcularMediaTurma(Long turmaId) {
        Turma turma = readTurma(turmaId);
        List<Aluno> alunos = turma.getAlunos();

        if (alunos == null || alunos.isEmpty()) {
            return 0.0;
        }
        double soma = alunos.stream()
                .mapToDouble(Aluno::getMedia)
                .sum();
        return soma / alunos.size();
    }

    //Atualiza a quantidade de alunos
    @Transactional
    public void atualizarQuantiAluno(Long turmaId){
        Turma turma = readTurma(turmaId);
        int total = turma.getAlunos() == null ? 0 : turma.getAlunos().size();

        if (total < 20 || total > 40){
            throw new IllegalArgumentException("A turma deve ter entre 20 e 40 alunos.");
        }
        turma.setQuantiaAluno(total);
        turmaRepository.save(turma);
    }

    //Pesquisa aluno por id dentro da turma
    @Transactional
    public Aluno searchAlunoTurma(Long turmaId, Long alunoId){
        Turma turma = readTurma(turmaId);

        return turma.getAlunos().stream() //stream - fluxo de dados que é criado a partir de uma coleção
                .filter(aluno -> aluno.getId().equals(alunoId))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Aluno não identificado nesta turma!"));
    }

    public int contarAlunos(Long turmaId){
        Turma turma= readTurma(turmaId);
        return turma.getAlunos() == null ? 0 : turma.getAlunos().size();
    }

    public int contarProfessor(Long turmaId){
        Turma turma= readTurma(turmaId);
        return turma.getProfessor() != null ? 1 : 0;
    }

}