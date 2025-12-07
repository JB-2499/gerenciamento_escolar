package projeto_prog_ii.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;
import java.util.List;

@RestController
@RequestMapping("/Tb_Professor")
public class ProfessorController {

    private final ProfessorService service;
    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> ReadAllProfessor() {
        return service.lerProfessores();
    }

    @GetMapping("/{id}")
    public Professor ReadProfessor(@PathVariable long id) {
        return service.pesquisaProfessores(id);
    }

    @PostMapping
    public Professor createProfessor(@Valid @RequestBody Professor professor) {
        return service.criarProfessores(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @Valid @RequestBody Professor professor) {
        return service.atualizarProfessores(id, professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        service.deletar(id);
    }
}
