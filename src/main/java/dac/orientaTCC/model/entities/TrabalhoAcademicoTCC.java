package dac.orientaTCC.model.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrabalhoAcademicoTCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "siape_orientador", nullable = false)
    private Orientador orientador;

    @Column(name = "nome_trabalho", nullable = false)
    private String nomeTrabalho;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;

    @OneToOne
    @JoinColumn(name = "aluno_matricula", nullable = false)
    private Aluno aluno;

}
