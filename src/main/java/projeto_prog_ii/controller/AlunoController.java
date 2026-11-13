package projeto_prog_ii.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_prog_ii.dto.AlunoRequestDTO;
import projeto_prog_ii.dto.AlunoResponseDTO;
import projeto_prog_ii.mapper.AlunoMapper;
import projeto_prog_ii.model.Aluno;
import projeto_prog_ii.service.AlunoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    private final AlunoMapper alunoMapper;

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> createAluno(@Valid @RequestBody AlunoRequestDTO request) {
        Aluno novo = alunoService.createAluno(alunoMapper.toEntity(request));
        return ResponseEntity.created(URI.create("/alunos/" + novo.getId())).body(alunoMapper.toResponse(novo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> getAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoMapper.toResponse(alunoService.getAluno(id)));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> getAlunos() {
        return ResponseEntity.ok(alunoService.getAlunos().stream().map(alunoMapper::toResponse).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> updateAluno(@PathVariable Long id,
                                                        @Valid @RequestBody AlunoRequestDTO request) {
        Aluno atualizado = alunoService.updateAluno(id, alunoMapper.toEntity(request));
        return ResponseEntity.ok(alunoMapper.toResponse(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}