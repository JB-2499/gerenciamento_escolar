package projeto_prog_ii.controller;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_prog_ii.model.Turma;
import projeto_prog_ii.service.SecretariaService;

@RestController
@RequestMapping("/secretaria")
@Data

public class SecretariaController {
    private final SecretariaService secretariaService;

    @PostMapping("/matricular/{turmaId}/{alunoId}")
    public ResponseEntity<Turma> matricular(
            @PathVariable long turmaId,
            @PathVariable long alunoId){
        return ResponseEntity.ok(secretariaService.matricularAluno(turmaId, alunoId));
    }
}
