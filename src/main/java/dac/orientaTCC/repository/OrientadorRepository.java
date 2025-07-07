package dac.orientaTCC.repository;

import dac.orientaTCC.model.entities.Aluno;
import dac.orientaTCC.model.entities.Orientador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrientadorRepository extends JpaRepository<Orientador, Long> {

    Orientador findByUsuarioEmail(String email);

    Orientador findBySiape(String siape);

    Optional<Orientador> findByUsuarioId(Long usuarioId);
}
