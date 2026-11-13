package projeto_prog_ii.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.repository.AlunoRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    private Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado (id " + id + ")."));
    }

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno getAluno(Long id) {
        return buscarPorId(id);
    }

    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno updateAluno(Long id, Aluno novosDados) {
        Aluno aluno = buscarPorId(id);

        aluno.setNome(novosDados.getNome());
        aluno.setIdade(novosDados.getIdade());
        aluno.setMedia(novosDados.getMedia());
        aluno.setEstado(novosDados.getEstado());

        return alunoRepository.save(aluno);
    }

    public void deleteAluno(Long id) {
        alunoRepository.delete(buscarPorId(id));
    }
}