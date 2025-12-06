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
    public List<Professor> listProfessores() {
        return service.getProfessores();
    }

    @PostMapping
    public Professor registerProfessor(@Valid @RequestBody Professor professor) {
        return service.save(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @Valid @RequestBody Professor professor) {
        return service.update(id, professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        service.delete(id);
    }
}
