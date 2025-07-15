package dac.orientaTCC.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class TrabalhoAcademicoTCCCreateDTO {
    
    @NotBlank(message = "O nome do trabalho deve ser informado")
    private String nome;

    @NotNull(message = "A data de início deve ser informada")
    @FutureOrPresent(message = "A data informada deve ser hoje ou no futuro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;

    @NotBlank(message = "O siape do orientador deve ser informado")
    private String siapeOrientador;

    @NotBlank(message = "O nome do aluno deve ser informado")
    private Long idAluno;

    //private List<AtividadeDTO> atividades;
}

