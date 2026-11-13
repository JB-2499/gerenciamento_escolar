package projeto_prog_ii.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.dto.AlunoResponseDTO;
import projeto_prog_ii.dto.TurmaRequestDTO;
import projeto_prog_ii.dto.TurmaResponseDTO;
import projeto_prog_ii.mapper.AlunoMapper;
import projeto_prog_ii.mapper.TurmaMapper;
import projeto_prog_ii.model.Turma;
import projeto_prog_ii.service.TurmaService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;
    private final TurmaMapper turmaMapper;
    private final AlunoMapper alunoMapper;

    @PostMapping
    public ResponseEntity<TurmaResponseDTO> createTurma(@Valid @RequestBody TurmaRequestDTO request) {
        Turma nova = turmaService.createTurma(turmaMapper.toEntity(request), request.professorId());
        return ResponseEntity.created(URI.create("/turmas/" + nova.getId())).body(turmaMapper.toResponse(nova));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> readTurma(@PathVariable Long id) {
        return ResponseEntity.ok(turmaMapper.toResponse(turmaService.buscarTurma(id)));
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> listarTurmas() {
        return ResponseEntity.ok(turmaService.listarTurmas().stream().map(turmaMapper::toResponse).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> updateTurma(@PathVariable Long id,
                                                        @Valid @RequestBody TurmaRequestDTO request) {
        Turma atualizada = turmaService.updateTurma(id, turmaMapper.toEntity(request), request.professorId());
        return ResponseEntity.ok(turmaMapper.toResponse(atualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/media")
    public ResponseEntity<Double> calcularMediaTurma(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.calcularMediaTurma(id));
    }

    @GetMapping("/{turmaId}/alunos/{alunoId}")
    public ResponseEntity<AlunoResponseDTO> searchAluno(@PathVariable Long turmaId, @PathVariable Long alunoId) {
        return ResponseEntity.ok(alunoMapper.toResponse(turmaService.searchAlunoTurma(turmaId, alunoId)));
    }
}