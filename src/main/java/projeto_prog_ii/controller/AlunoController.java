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
    public ResponseEntity<Aluno> registerAluno(@Valid @RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.registerAluno(aluno);

        return ResponseEntity.created(URI.create("/api/alunos/" + novoAluno.getId())).body(novoAluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> searchAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.searchAluno(id);

        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listAlunos() {
        return ResponseEntity.ok(alunoService.listAlunos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAluno(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        boolean alterado = alunoService.updateAluno(id, aluno);

        if (!alterado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Dados do aluno atualizados com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
        boolean removido = alunoService.deleteAluno(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Aluno removido com sucesso!");
    }
}