package dac.orientaTCC.mapper;

import dac.orientaTCC.dto.AlunoCreateDTO;
import dac.orientaTCC.dto.AlunoResponseDTO;
import dac.orientaTCC.model.entities.Aluno;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlunoMapper {

    public static Aluno toAluno(AlunoCreateDTO alunoCreateDTO){
        return new ModelMapper().map(alunoCreateDTO, Aluno.class);
    }

    public static AlunoResponseDTO toAlunoDTO(Aluno aluno){
        return new ModelMapper().map(aluno, AlunoResponseDTO.class);
    }
}
