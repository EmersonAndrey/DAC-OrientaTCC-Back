package dac.orientaTCC.model.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
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
public class TrabalhoAcademicoTCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "siape_orientador", nullable = false)//amiga muda o nome do relacionamneto para id_orientador pq no banco fica o id
    private Orientador orientador;

    @NotBlank(message = "O nome do trabalho deve ser informado")
    @Column(name = "nome_trabalho", nullable = false)
    private String nomeTrabalho;

    @NotNull(message = "A data de início deve ser informada")
    @FutureOrPresent(message = "A data informada deve ser hoje ou no futuro")
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;

    @OneToOne
    @JoinColumn(name = "aluno_matricula", nullable = false)//amiga muda o nome do relacionamneto para id_alunor pq no banco fica o id
    private Aluno aluno;

}
