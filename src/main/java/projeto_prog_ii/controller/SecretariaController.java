package projeto_prog_ii.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_prog_ii.dto.TurmaResponseDTO;
import projeto_prog_ii.mapper.TurmaMapper;
import projeto_prog_ii.service.SecretariaService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/secretaria")
public class SecretariaController {

    private final SecretariaService secretariaService;
    private final TurmaMapper turmaMapper;

    @PostMapping("/matricular/{turmaId}/{alunoId}")
    public ResponseEntity<TurmaResponseDTO> matricular(
            @PathVariable long turmaId,
            @PathVariable long alunoId) {
        return ResponseEntity.ok(turmaMapper.toResponse(secretariaService.matricularAluno(turmaId, alunoId)));
    }

    @PostMapping("/transferir/{alunoId}/{origem}/{destino}")
    public ResponseEntity<String> transferir(
            @PathVariable long alunoId,
            @PathVariable long origem,
            @PathVariable long destino) {
        return ResponseEntity.ok(secretariaService.transferirAluno(alunoId, origem, destino));
    }

    @PostMapping("/atribuir_Prof/{turmaId}/{professorId}")
    public ResponseEntity<TurmaResponseDTO> atribuirProfessor(
            @PathVariable long turmaId,
            @PathVariable long professorId) {
        return ResponseEntity.ok(turmaMapper.toResponse(secretariaService.atribuirProf(turmaId, professorId)));
    }

    @PostMapping("/trocar_Prof/{turmaId}/{professorId}")
    public ResponseEntity<TurmaResponseDTO> trocarProfessor(
            @PathVariable long turmaId,
            @PathVariable long professorId) {
        return ResponseEntity.ok(turmaMapper.toResponse(secretariaService.trocarProfessor(turmaId, professorId)));
    }

    @PostMapping("/remover_Prof/{turmaId}")
    public ResponseEntity<TurmaResponseDTO> removerProfessor(@PathVariable long turmaId) {
        return ResponseEntity.ok(turmaMapper.toResponse(secretariaService.removerProf(turmaId)));
    }
}