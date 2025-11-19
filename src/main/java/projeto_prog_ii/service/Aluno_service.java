package projeto_prog_ii.service;

import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Aluno_service {
    private final Map<Integer, Aluno> alunos = new HashMap<>();

    private int contadorId = 1;

    public int registrarAluno(Aluno aluno){
        int idGerado = contadorId++;
        alunos.put(idGerado, aluno);

        System.out.println("Aluno registrado com sucesso!\nO Id do aluno é: " + idGerado);

        return idGerado;
    }

    public boolean alterAluno(int id, Aluno novosDados) {
        if (!this.alunos.containsKey(id)) {
            System.out.println("Aluno não encontrado");
            return false;
        }

        Aluno alunoExistente = alunos.get(id);

        alunoExistente.setNome(novosDados.getNome());
        alunoExistente.setIdade(novosDados.getIdade());
        alunoExistente.setTurma(novosDados.getTurma());
        alunoExistente.setMedia(novosDados.getMedia());
        alunoExistente.setSituacao(novosDados.isSituacao());

        return true;
    }

    public Aluno searchAluno(int id){
        return this.alunos.get(id);
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(this.alunos.values());
    }
}