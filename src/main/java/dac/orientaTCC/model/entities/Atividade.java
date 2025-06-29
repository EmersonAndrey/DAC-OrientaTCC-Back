package dac.orientaTCC.model.entities;

import java.time.LocalDate;
import java.util.List;

import dac.orientaTCC.enums.StatusPDF;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data de entrega deve ser informada")
    @FutureOrPresent(message = "A data informada deve ser hoje ou no futuro")
    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;

    @NotBlank(message = "O nome da atividade deve ser informada")
    @Column(name = "nome_da_atividade", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O status da entrega deve ser informado")
    @Column(name = "status", nullable = false)
    private StatusPDF status;

    @NotBlank(message = "A descrição da atividade deve ser informada")
    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "trabalho_id")
    private TrabalhoAcademicoTCC trabalho;

    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PDF> pdfs;

    private List<String> comentario;
}
