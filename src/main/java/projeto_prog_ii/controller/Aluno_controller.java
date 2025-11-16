package projeto_prog_ii.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.service.Aluno_service;

import java.util.List;

@RestController
@RequestMapping("/Aluno")
public class Aluno_controller {
    private final Aluno_service aluno_service;

    public Aluno_controller(Aluno_service aluno_service) {
        this.aluno_service = aluno_service;
    }

    @GetMapping
    public List<Aluno> getAll() {return aluno_service.getAll()}
}
