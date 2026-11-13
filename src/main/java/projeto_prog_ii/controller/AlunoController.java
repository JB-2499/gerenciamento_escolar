package projeto_prog_ii.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.service.AlunoService;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@Valid @RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.createAluno(aluno);

        return ResponseEntity.created(URI.create("/alunos" + novoAluno.getId())).body(novoAluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.getAluno(id);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAluno() {
        return ResponseEntity.ok(alunoService.getAluno());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAluno(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        alunoService.updateAluno(id, aluno);
        return ResponseEntity.ok("Dados do aluno atualizados com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.ok("Aluno removido com sucesso!");
    }
}