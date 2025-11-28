package projeto_prog_ii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/paginaControle")
public class ProfessorController {

    @Autowired
    public ProfessorController(ProfessorService service){

        this.service = service;
    }
    private final ProfessorService service;

    @GetMapping

    public List<Professor> getProfessores(){
        return service.getProfessores();

    }


}























