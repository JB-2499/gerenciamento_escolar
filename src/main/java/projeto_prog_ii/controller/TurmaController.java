package projeto_prog_ii.controller;
//Criação dos CRUD's e REST
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.model.Turma;
import projeto_prog_ii.service.AlunoService;
import projeto_prog_ii.service.TurmaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turmas")
public class TurmaController {
    //Injeção de dependência via construtor
    private final TurmaService turmaService;
    //private final ProfessorService professorService;
    private final AlunoService alunoService;

    //Cria turma
    @PostMapping
    public ResponseEntity<Turma> createTurma(@Valid  @RequestBody Turma turma) {
        Turma nova = turmaService.createTurma(turma); //Falta criar esse método
        return ResponseEntity.ok(nova);
    }
    //Buscar turma
    @GetMapping("/{id}")
    public ResponseEntity<Turma> readTurma(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.buscarTurma(id));
    }
    //Listar turmas
    @GetMapping
    public ResponseEntity<List<Turma>> listarTurmas() { //lista as turmas
        return ResponseEntity.ok(turmaService.listarTurmas());
    }
    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(
            @PathVariable Long id,
            @Valid  @RequestBody Turma turma) {
        Turma atualizado = turmaService.updateTurma(id, turma);
        return ResponseEntity.ok(atualizado);
    }
    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/media")
    public ResponseEntity<Double> calcularMediaTurma(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.calcularMediaTurma(id));
    }
    //Pesquisar aluno
    @GetMapping("/{turmaId}/alunos/{alunosId}")
    public ResponseEntity<Aluno> searchAluno(
            @PathVariable Long turmaId,
            @PathVariable Long alunosId) {
        return ResponseEntity.ok(turmaService.searchAlunoTurma(turmaId, alunosId));
    }
    //Pesquisar professor
    /*@GetMapping("/{turmaId}/professores/{professorId}")
    public ResponseEntity<Professor> pesquisarProfessor(
            @PathVariable Long turmaId,
            @PathVariable Long professorId){
        return ResponseEntity.ok(turmaService.pesquisaProfessorTurma(turmaId, professorId));
    }*/
    //Total de alunos
    @GetMapping("/{turmaId}/total-alunos")
    public ResponseEntity<Integer> totalAlunos(
            @PathVariable Long turmaId){
        return ResponseEntity.ok(turmaService.contarAlunos(turmaId));
    }
    @PutMapping("/{id}/atualizar-quantidade")
    public ResponseEntity<Void> atualizarQuantiAluno(@PathVariable Long id){
        turmaService.atualizarQuantiAluno(id);
        return ResponseEntity.noContent().build();
    }

}