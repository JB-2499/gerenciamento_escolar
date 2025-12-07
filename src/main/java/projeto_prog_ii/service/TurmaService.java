package projeto_prog_ii.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Professor;
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
        if (turma.getProfessores() != null){
            turma.getProfessores().forEach(professor -> professor.getTurmas().add(turma));
        }

        atualizarQuantidadeAlunos(turma);
        atualizarQuantidadeProfessores(turma);

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
        if (quanti < 20 || quanti > 40){
            throw new IllegalArgumentException("Quantidade invalida!");
        }
    }
    private void validarQuantidadeProfessores(Turma turma) {
        int total = turma.getProfessores() == null ? 0 : turma.getProfessores().size();
        if (total < 1 || total > 4){
            throw new IllegalArgumentException("Quantidade de Professores invalida!");
        }
    }

    private <G> int contar (List<G> lista){
        return lista == null? 0: lista.size();
    }

    public void atualizarQuantidadeProfessores(Turma turma){
        validarQuantidadeProfessores(turma);
        turma.setQuantidadeProfessor(contar(turma.getProfessores()));
    }

    public void atualizarQuantidadeAlunos(Turma turma){
        validarQuantidadeAluno(turma);
        turma.setQuantiaAluno(contar(turma.getAlunos()));
    }

    public void limparRelacoesBiderecionais(Turma turma){
        turma.getAlunos().forEach(aluno -> aluno.setTurma(null));
        turma.getAlunos().clear();

        turma.getProfessores().forEach(prof -> prof.getTurmas().remove(turma));
        turma.getProfessores().clear();
    }

    @Transactional
    public Turma updateTurma(Long id, Turma turmaAtualizada){
        Turma turmaExistente = readTurma(id);

        limparRelacoesBiderecionais(turmaExistente);

        if(turmaAtualizada.getAlunos() != null){
            turmaAtualizada.getAlunos().forEach(aluno ->{
                aluno.setTurma(turmaExistente);
                turmaExistente.getAlunos().add(aluno);
            });
        }
        if(turmaAtualizada.getProfessores()!= null){
            turmaAtualizada.getProfessores().forEach(prof ->{
                turmaExistente.getProfessores().add(prof);
                prof.getTurmas().add(turmaExistente);
            });
        }

        //Calcula a quantidade
        atualizarQuantidadeAlunos(turmaExistente);
        atualizarQuantidadeProfessores(turmaExistente);

        return turmaRepository.save(turmaExistente);
    }

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

    //Pesquisa professor por id dentro da turma
    @Transactional
    public Professor pesquisarProfessorTurma(Long turmaId, Long professorId){
        Turma turma = readTurma(turmaId);
        return turma.getProfessores().stream() //stream - fluxo de dados que é criado a partir de uma coleção
                .filter(professor -> professor.getId() == professorId)
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Professor não encontrado nesta turma!"));
    }

}