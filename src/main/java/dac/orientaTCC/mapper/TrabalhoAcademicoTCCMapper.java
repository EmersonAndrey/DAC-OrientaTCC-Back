package dac.orientaTCC.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dac.orientaTCC.model.dto.TrabalhoAcademicoTCCCreateDTO;
import dac.orientaTCC.model.dto.TrabalhoAcademicoTCCResponseDTO;
import dac.orientaTCC.model.entities.TrabalhoAcademicoTCC;

@Mapper(componentModel = "spring")
public interface TrabalhoAcademicoTCCMapper {
    
    //Entity -> DTO
    TrabalhoAcademicoTCCResponseDTO toDTO(TrabalhoAcademicoTCC entity);

    //DTOO -> Entity
    @Mapping(target = "id", ignore = true) // ID não vem na criação
    @Mapping(target = "orientador", ignore = true) // será setado no service
    @Mapping(target = "aluno", ignore = true)      // será setado no service
    //@Mapping(target = "atividades", source = "atividades") quando colocar as atividades no dto
    TrabalhoAcademicoTCC toEntity(TrabalhoAcademicoTCCCreateDTO dto);
    
}
