package dac.orientaTCC.service;

import dac.orientaTCC.model.entities.Aluno;
import dac.orientaTCC.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public Aluno findById(String id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id = %s não encontrado", id))
        );
    }
}
