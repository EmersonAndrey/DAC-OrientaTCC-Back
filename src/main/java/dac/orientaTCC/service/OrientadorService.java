package dac.orientaTCC.service;

import dac.orientaTCC.dto.*;
import dac.orientaTCC.mapper.OrientadorMapper;
import dac.orientaTCC.model.entities.Orientador;
import dac.orientaTCC.model.entities.Usuario;
import dac.orientaTCC.repository.OrientadorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrientadorService {

    private final OrientadorRepository orientadorRepository;
    private final UsuarioService usuarioService;

    @Transactional
    public Orientador save(Orientador orientador) { //colocar o tratamento depois
        return orientadorRepository.save(orientador);
    }

    @Transactional
    public OrientadorResponseDTO create(@Valid OrientadorCreateDTO orientadorCreateDTO) {
        Usuario usuario = usuarioService.salvar(new UsuarioCreateDTO(orientadorCreateDTO.getEmail(), orientadorCreateDTO.getSenha(), "ROLE_ORIENTADOR"));

        Orientador orientador = OrientadorMapper.toOrientador(orientadorCreateDTO);
        orientador.setUsuario(usuario);

        orientador = save(orientador);

        return OrientadorMapper.toOrientadorDTO(orientador);
    }

    @Transactional(readOnly = true)
    public Orientador findById(Long id) {
        return orientadorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id = %s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Orientador findByEmail(String email) {
        return orientadorRepository.findByUsuarioEmail(email);
    }

    @Transactional(readOnly = true)
    public Orientador findBySiape(String siape) {
        return orientadorRepository.findBySiape(siape);
    }

    @Transactional(readOnly = true)
    public List<Orientador> findAll() {
        return orientadorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Orientador findByIdUsuario(Long id) {
        return orientadorRepository.findByUsuarioId(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id = %s não encontrado", id))
        );
    }

}
