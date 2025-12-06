package projeto_prog_ii.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;
import projeto_prog_ii.repository.AlunoRepository;
import projeto_prog_ii.repository.TurmaRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {
    //Injeção de dependência
    private final TurmaRepository turmaRepository;
    //private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    //Vericação de existência
    private Turma verificarTurma(Long id){
        return turmaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Turma não encontrada!"));
    }
    //Criando turma
    public Turma criarTurma(Turma turma){
        return turmaRepository.save(turma);
    }
    //Lista todas as turmas
    public List<Turma>listarTurmas(){
        return turmaRepository.findAll();
    }
    //Busca por id
    public Turma buscarTurma(Long id){
        return verificarTurma(id);
    }
    @Transactional
    public Turma atualizarTurma(Long id, Turma turmaAtualizada){
        Turma turmaExistente = verificarTurma(id);
        turmaExistente.setNome(turmaAtualizada.getNome());
        turmaExistente.setAlunos(turmaAtualizada.getAlunos());
        return turmaRepository.save(turmaExistente);
    }
    //Deletar turma
    @Transactional
    public void deletarTurma(Long id){
        Turma turma = verificarTurma(id);
        turmaRepository.delete(turma);
    }
    //Calcula média geral da turma
    public double calcularMediaTurma(Long turmaId) {
        Turma turma = verificarTurma(turmaId);
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
    public void atualizarQuantiAluno(Turma turma){
        int total = turma.getAlunos() == null ? 0 : turma.getAlunos().size();

        if (total < 20 || total > 40){
            throw new IllegalArgumentException("A turma deve ter entre 20 e 40 alunos.");
        }
        turma.setQuantiaAluno(total);
        turmaRepository.save(turma);
    }
    //Pesquisa aluno por id dentro da turma
    @Transactional
    public Aluno pesquisarAlunoTurma(Long turmaId, Long alunoId){
        Turma turma = verificarTurma(turmaId);

        return turma.getAlunos().stream() //stream - fluxo de dados que é criado a partir de uma coleção
                .filter(aluno -> aluno.getId().equals(alunoId))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Aluno não identificado nesta turma!"));
    }
    public int contarAlunos(Long turmaId_){
        Turma turma= verificarTurma(turmaId_);
        return turma.getAlunos() == null ? 0 : turma.getAlunos().size();
    }
    /*
    //Pesquisa professor por id dentro da turma
    @Transactional
    public Professor pesquisarProfessorTurma(Long turmaId, Long professorId){
        Turma turma = verificarTurma(turmaId);
        //Se atentar ao relacionamento - corrigir para professores ápos o merge com Felipe
        return turma.getProfessor().stream() //stream - fluxo de dados que é criado a partir de uma coleção
                .filter(professor -> professor.getId().equals(professorId))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Professor não identificado nesta turma!"));
    }*/
}