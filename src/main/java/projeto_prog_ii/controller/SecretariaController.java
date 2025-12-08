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

    @PostMapping("/transferir/{alunoId}/{origem}/{destino}")
    public ResponseEntity<String> transferir(
            @PathVariable long alunoId,
            @PathVariable long origem,
            @PathVariable long destino){
        return ResponseEntity.ok(secretariaService.transferirAluno(alunoId, origem, destino));
    }

    @PostMapping("/atribuir_Prof/{turmaId}/{professorId}")
    public ResponseEntity<Turma> atribuirProfessor(
            @PathVariable long turmaId,
            @PathVariable long professorId){
        return ResponseEntity.ok(secretariaService.atribuirProf(turmaId, professorId));
    }

    @PostMapping("/trocar_Prof/{turmaId}/{professorId}")
    public ResponseEntity<Turma> trocarProfessor(
            @PathVariable long turmaId,
            @PathVariable long professorId){
        return ResponseEntity.ok(secretariaService.trocarProfessor(turmaId, professorId));
    }

    @PostMapping("/remover_Prof/{turmaId}")
    public ResponseEntity<Turma> removerProfessor(
            @PathVariable long turmaId){
        return ResponseEntity.ok(secretariaService.removerProf(turmaId));
    }
}
