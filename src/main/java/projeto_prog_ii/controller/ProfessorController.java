package projeto_prog_ii.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.dto.ProfessorRequestDTO;
import projeto_prog_ii.dto.ProfessorResponseDTO;
import projeto_prog_ii.mapper.ProfessorMapper;
import projeto_prog_ii.model.Professor;
import projeto_prog_ii.service.ProfessorService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> getProfessor() {
        return ResponseEntity.ok(
                professorService.getProfessores().stream().map(professorMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> getProfessor(@PathVariable Long id) {
        return ResponseEntity.ok(professorMapper.toResponse(professorService.getProfessor(id)));
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> createProfessor(@Valid @RequestBody ProfessorRequestDTO request) {
        Professor novo = professorService.createProfessores(professorMapper.toEntity(request));
        return ResponseEntity.created(URI.create("/professores/" + novo.getId()))
                .body(professorMapper.toResponse(novo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> updateProfessor(@PathVariable Long id,
                                                                @Valid @RequestBody ProfessorRequestDTO request) {
        Professor atualizado = professorService.updateProfessores(id, professorMapper.toEntity(request));
        return ResponseEntity.ok(professorMapper.toResponse(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}