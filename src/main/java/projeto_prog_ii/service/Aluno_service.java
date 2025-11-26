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

    private long Id(List<Aluno> alunos) {
        return alunos.stream().mapToLong(Aluno::getId).max().orElse(0L) + 1;
    }

    public long registerAluno(Aluno aluno){
        List<Aluno> alunos = alunoRepository.loadAlunos();

        long id_gerado = Id(alunos);
        aluno.setId(id_gerado);

        alunos.add(aluno);
        alunoRepository.salvar(alunos);

        return id_gerado;
    }

    public boolean updateAluno(long id, Aluno novosDados) {
        List<Aluno> alunos = alunoRepository.loadAlunos();

        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                aluno.setNome(novosDados.getNome());
                aluno.setIdade(novosDados.getIdade());
                aluno.setTurma(novosDados.getTurma());
                aluno.setMedia(novosDados.getMedia());
                aluno.setEstado(novosDados.isEstado());

                alunoRepository.salvar(alunos);
                return true;
            }
        }

        return false;
    }

    public Aluno searchAluno(long id) {
        List<Aluno> alunos = alunoRepository.loadAlunos();
        return alunos.stream().filter(aluno -> aluno.getId() == id).findFirst().orElse(null);
    }

    public List<Aluno> listAlunos() {
        return alunoRepository.loadAlunos();
    }

    public boolean deleteAluno(long id){
        List<Aluno> alunos = alunoRepository.loadAlunos();
        boolean removido = alunos.removeIf(aluno -> aluno.getId() == id);

        if (removido) {
            alunoRepository.salvar(alunos);
        }
        return removido;
    }
}