package dac.orientaTCC.controller;

import dac.orientaTCC.model.entities.Aluno;
import dac.orientaTCC.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.findById(id));
    }

}
