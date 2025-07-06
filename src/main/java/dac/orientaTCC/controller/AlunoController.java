package dac.orientaTCC.controller;

import dac.orientaTCC.dto.AlunoCreateDTO;
import dac.orientaTCC.dto.AlunoResponseDTO;
import dac.orientaTCC.model.entities.Aluno;
import dac.orientaTCC.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> create(@RequestBody @Valid AlunoCreateDTO alunoCreateDTO){
        AlunoResponseDTO aluno = alunoService.create(alunoCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.findById(id));
    }
}
