package projeto_prog_ii.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter@Setter
public class Aluno_service {

    private final Map<Integer, Aluno> alunos = new HashMap<>();
    private List<Aluno> ListaAluno = new ArrayList<>();


    private int contadorId = 1;
    public int registerAluno(Aluno aluno){
        int idGerado = contadorId++;
        alunos.put(idGerado, aluno);
        return idGerado;
    }

    public boolean updateAluno(int id, Aluno novosDados) {
        if (!this.alunos.containsKey(id)) {
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

    public List<Aluno> listAlunos() {
        return new ArrayList<>(this.alunos.values());
    }

    public boolean deleteAluno(int id){
        if (!this.alunos.containsKey(id)) {
            return false;
        } else {
            alunos.remove(id);
            return true;
        }
    }

    public List<Aluno> getListaAluno() {
        return ListaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        ListaAluno = listaAluno;
    }
}