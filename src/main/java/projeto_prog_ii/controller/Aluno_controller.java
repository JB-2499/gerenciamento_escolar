package projeto_prog_ii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.service.Aluno_service;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class Aluno_controller {

    @Autowired
    private Aluno_service alunoService;

    @PostMapping
    public String registerAluno(@RequestBody Aluno aluno){
        int idGerado = alunoService.registerAluno(aluno);
        return "Aluno registrado com sucesso!\nO ID do aluno é: " + idGerado;
    }

    @GetMapping("/{id}")
    public Aluno searchAluno(@PathVariable int id){
        return alunoService.searchAluno(id);
    }

    @GetMapping
    public List<Aluno> listAlunos(){
        return alunoService.listAlunos();
    }

    @PutMapping("/{id}")
    public String updateAluno(@PathVariable int id, @RequestBody Aluno aluno) {
        boolean alterado = alunoService.updateAluno(id, aluno);

        if (alterado) {
            return "Dados do aluno atualizados com sucesso!";
        } else {
            return "Aluno não encontrado.";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAluno(@PathVariable int id) {
        boolean removido = alunoService.deleteAluno(id);

        if (removido) {
            return "Aluno removido com sucesso!";
        } else {
            return "Aluno não encontrado.";
        }
    }
}