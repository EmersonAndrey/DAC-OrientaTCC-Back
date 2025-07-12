package dac.orientaTCC.controller;

import dac.orientaTCC.dto.AlunoCreateDTO;
import dac.orientaTCC.dto.AlunoResponseDTO;
import dac.orientaTCC.mapper.AlunoMapper;
import dac.orientaTCC.model.entities.Aluno;
import dac.orientaTCC.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @PreAuthorize("hasRole('COORDENADOR')")
    public ResponseEntity<AlunoResponseDTO> create(@RequestBody @Valid AlunoCreateDTO alunoCreateDTO){
        AlunoResponseDTO aluno = alunoService.create(alunoCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @PreAuthorize("hasRole('ALUNO')")
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> findById(@PathVariable Long id){
        Aluno aluno = alunoService.findById(id);
        return ResponseEntity.ok().body(AlunoMapper.toAlunoDTO(aluno));
    }

    @PreAuthorize("hasRole('COORDENADOR') OR #email == authentication.principal.username")
    @GetMapping("/email/{email}")
    public ResponseEntity<AlunoResponseDTO> findByEmail(@PathVariable String email){
        Aluno aluno = alunoService.findByEmail(email);
        return ResponseEntity.ok(AlunoMapper.toAlunoDTO(aluno));
    }

    @PreAuthorize("hasRole('COORDENADOR') OR #matricula == authentication.principal.identificador")
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<AlunoResponseDTO> findByMatricula(@PathVariable String matricula){

        Aluno aluno = alunoService.findByMatricula(matricula);
        return ResponseEntity.ok(AlunoMapper.toAlunoDTO(aluno));
    }

    @PreAuthorize("hasRole('COORDENADOR')")
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> findAll(){
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok(AlunoMapper.toListAlunoDTO(alunos));
    }

    @PreAuthorize("hasRole('COORDENADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Long id){
        alunoService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
