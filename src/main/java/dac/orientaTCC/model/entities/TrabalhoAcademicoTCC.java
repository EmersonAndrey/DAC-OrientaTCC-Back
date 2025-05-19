package dac.orientaTCC.model.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class TrabalhoAcademicoTCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do trabalho deve ser informado")
    private String nomeTrabalho;

    @NotNull(message = "A data de início deve ser informada")
    @FutureOrPresent(message = "A data informada deve ser hoje ou no futuro")
    private LocalDate dataInicio;

    @NotBlank(message = "O SIAPE do orientador deve ser infomado")
    private String SIAPEOrientador;

    @NotBlank(message = "A matricula do aluno deve ser informada")
    private String matriculaAluno;

    @OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getNomeTrabalho() {
        return nomeTrabalho;
    }

    public void setNomeTrabalho(String nomeTrabalho) {
        this.nomeTrabalho = nomeTrabalho;
    }

    public String getSIAPEOrientador() {
        return SIAPEOrientador;
    }

    public void setSIAPEOrientador(String sIAPEOrientador) {
        SIAPEOrientador = sIAPEOrientador;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
