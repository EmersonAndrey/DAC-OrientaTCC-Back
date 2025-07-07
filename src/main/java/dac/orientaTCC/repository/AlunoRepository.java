package dac.orientaTCC.repository;

import dac.orientaTCC.model.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByUsuarioEmail(String email);

    Aluno findByMatricula(String matricula);

    Optional<Aluno> findByUsuarioId(Long usuarioId);
}
