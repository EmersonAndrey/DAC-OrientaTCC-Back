package dac.orientaTCC.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PDF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do arquivo deve ser informado")
    @Column(name = "nome_arquivo", nullable = false)
    private String nomeArquivo;

    @Lob
    @Column(nullable = false)
    private byte[] conteudo;

    @ManyToOne
    @JoinColumn(name = "atividade_id", nullable = false)
    private Atividade atividade;

}
