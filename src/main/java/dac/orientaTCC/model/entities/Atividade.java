package dac.orientaTCC.model.entities;

import java.time.LocalDate;
import java.util.List;

import dac.orientaTCC.enums.FasesEntrega;
import dac.orientaTCC.enums.StatusPDF;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data de início deve ser informada")
    @FutureOrPresent(message = "A data informada deve ser hoje ou no futuro")
    private LocalDate dataEntrega;

    @NotNull(message = "A fase de entrega deve ser informada")
    private FasesEntrega entregavel;

    @NotNull(message = "O satus da entrega deve ser informado")
    private StatusPDF status;

    @ManyToOne
    @JoinColumn(name = "trabalho_id")
    private TrabalhoAcademicoTCC trabalho;

    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PDF> pdfs;

    private String comentario;
    private String descricao;

    public List<PDF> getPdfs() {
        return pdfs;
    }

    public void setPdfs(List<PDF> pdfs) {
        this.pdfs = pdfs;
    }

    public TrabalhoAcademicoTCC getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(TrabalhoAcademicoTCC trabalho) {
        this.trabalho = trabalho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FasesEntrega getEntregavel() {
        return entregavel;
    }

    public void setEntregavel(FasesEntrega entregavel) {
        this.entregavel = entregavel;
    }

    public StatusPDF getStatus() {
        return status;
    }

    public void setStatus(StatusPDF status) {
        this.status = status;
    }

}
