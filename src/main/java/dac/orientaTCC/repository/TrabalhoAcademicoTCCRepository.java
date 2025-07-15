package dac.orientaTCC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dac.orientaTCC.model.entities.TrabalhoAcademicoTCC;

@Repository
public interface TrabalhoAcademicoTCCRepository extends JpaRepository<TrabalhoAcademicoTCC, Long>{

}
