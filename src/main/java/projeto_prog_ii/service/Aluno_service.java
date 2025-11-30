package projeto_prog_ii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.repository.Aluno_repository;

import java.util.*;

@Service
public class Aluno_service {

    @Autowired
    private Aluno_repository alunoRepository;

    public Aluno registerAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public boolean updateAluno(Long id, Aluno novosDados) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();

            aluno.setNome(novosDados.getNome());
            aluno.setTurma(novosDados.getTurma());
            aluno.setIdade(novosDados.getIdade());
            aluno.setMedia(novosDados.getMedia());
            aluno.setEstado(novosDados.isEstado());

            alunoRepository.save(aluno);
            return true;
        }
        return false;
    }

    public Aluno searchAluno(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public List<Aluno> listAlunos() {
        return alunoRepository.findAll();
    }

    public boolean deleteAluno(Long id){
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}