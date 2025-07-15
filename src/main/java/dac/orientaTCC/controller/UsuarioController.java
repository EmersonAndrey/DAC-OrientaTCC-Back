package dac.orientaTCC.controller;

import dac.orientaTCC.dto.UsuarioSenhaDTO;
import dac.orientaTCC.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('COORDENADOR','ALUNO', 'ORIENTADOR') AND (#id == authentication.principal.id)") //hasAnyRole('COORDENADOR','ALUNO', 'ORIENTADOR') RECEBE UMA LISTA DE USUARIOS, E CADA USUARIO SO PODE AlTERAR SUA PROPRIA SENHA
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDTO usuarioSenhaDTO){
        usuarioService.editarSenha(id, usuarioSenhaDTO.getSenhaAtual(),usuarioSenhaDTO.getNovaSenha(),usuarioSenhaDTO.getConfirmaSenha());

        return ResponseEntity.noContent().build();
    }
}
