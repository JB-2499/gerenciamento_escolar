package projeto_prog_ii.controller;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;
import java.util.List;

@RestController
@RequestMapping("/Professor")

public class ProfessorController {

    public ProfessorController(ProfessorService service) {

        this.service = service;
    }
    private final ProfessorService service;

    @GetMapping
    public List<Professor> getProfessores(){
        return service.getProfessores();

    }

    @PostMapping
    public Professor CadastrarProfessor(@RequestBody Professor professor) {

        return service.save(professor);
    }

    @DeleteMapping("/{id}")
    public void CeletarProfessor(@PathVariable Long id) {

        service.delete(id);
    }

}