package dac.orientaTCC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dac.orientaTCC.model.entities.TrabalhoAcademicoTCC;

@Repository
public interface TrabalhoAcademicoTCCRepository extends JpaRepository<TrabalhoAcademicoTCC, Long> {

    TrabalhoAcademicoTCC findByAlunoMatricula(String aluno_Matricula);

    List<TrabalhoAcademicoTCC> findByOrientadorSiape(String orientador_Siape);
}
