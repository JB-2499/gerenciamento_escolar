package projeto_prog_ii.service;

import org.springframework.stereotype.Service;
import projeto_prog_ii.repository.Aluno_repository;

@Service
public class Aluno_service {
    private final Aluno_repository aluno_repository;

    public Aluno_service(Aluno_repository aluno_repository) {
        this.aluno_repository = aluno_repository;
    }

    public list<Aluno> getAll() {
        return aluno_repository.findAll();
    }
}
