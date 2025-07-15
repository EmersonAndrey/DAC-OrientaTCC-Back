package dac.orientaTCC.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dac.orientaTCC.mapper.TrabalhoAcademicoTCCMapper;
import dac.orientaTCC.model.dto.TrabalhoAcademicoTCCCreateDTO;
import dac.orientaTCC.model.dto.TrabalhoAcademicoTCCResponseDTO;
import dac.orientaTCC.model.entities.TrabalhoAcademicoTCC;
import dac.orientaTCC.repository.TrabalhoAcademicoTCCRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrabalhoAcademicoTCCService {

    private TrabalhoAcademicoTCCMapper mapper;
    private TrabalhoAcademicoTCCRepository trabalhoAcademicoTCCRepository;
    //private OrientadorRepository orientadorRepository;
    //private AlunoRepository alunoRepository;

    @Transactional
    public TrabalhoAcademicoTCCResponseDTO save(TrabalhoAcademicoTCCCreateDTO dto) {
        TrabalhoAcademicoTCC entity = mapper.toEntity(dto);

        // entity.setOrientador(orientadorRepository.findBySiape(dto.getSiapeOrientador())
        // .orElseThrow(() -> new EntityNotFoundException(
        //                 String.format("Orientador siape = %s não encontrado", dto.getSiapeOrientador()))));
        // entity.setAluno(alunoRepository.findByid(dto.getIdAluno())
        // .orElseThrow(() -> new EntityNotFoundException(
        //                 String.format("Aluno id = %s não encontrado", dto.getIdAluno()))));

        entity.getAtividades().forEach(atividade -> atividade.setTrabalho(entity));//faz as atividadess apontarem para esse trabalho, pertecendo a ele

        TrabalhoAcademicoTCC salvo = trabalhoAcademicoTCCRepository.save(entity);
        return mapper.toDTO(salvo);
    }

    @Transactional(readOnly = true)
    public TrabalhoAcademicoTCC findById(Long id) {
        return trabalhoAcademicoTCCRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Trabalho Academico id = %s não encontrado", id)));
    }

    @Transactional
    public TrabalhoAcademicoTCC update(TrabalhoAcademicoTCC trabalhoAcademicoTCC, Long id) {
        TrabalhoAcademicoTCC trabalhoAtualizado = findById(id);
        trabalhoAtualizado.setAtividades(trabalhoAcademicoTCC.getAtividades());

        return trabalhoAcademicoTCCRepository.save(trabalhoAtualizado);
    }

    @Transactional
    public void remove(Long id) {
        TrabalhoAcademicoTCC trabalhoExistente = findById(id);
        trabalhoAcademicoTCCRepository.delete(trabalhoExistente);
    }
}
