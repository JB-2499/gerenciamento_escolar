package projeto_prog_ii.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projeto_prog_ii.exception.ResourceNotFoundException;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.repository.AlunoRepository;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno createAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void updateAluno(Long id, Aluno novosDados) {
            Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mensagem padrão"));

            aluno.setNome(novosDados.getNome());
            aluno.setIdade(novosDados.getIdade());
            aluno.setMedia(novosDados.getMedia());
            aluno.setEstado(novosDados.isEstado());

            alunoRepository.save(aluno);
    }

    public Aluno readAluno(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mensagem interna, não visível ao usuário."));
    }

    public List<Aluno> readAluno() {
        return alunoRepository.findAll();
    }

    public void deleteAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Mensagem padrão");
        }
        alunoRepository.deleteById(id);
    }
}