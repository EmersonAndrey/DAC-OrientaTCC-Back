package dac.orientaTCC.model.entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "orientador")
public class Orientador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O SIAPE do orientador deve ser informado")
    @Column(nullable = false, unique = true)
    private String siape;

    @NotBlank(message = "O email do orientador deve ser informado")
    @Email(message = "O email deve ser válido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha do orientador deve ser informada")
    @Column(nullable = false)
    private String senha;

    @NotBlank(message = "A nome do orientador deve ser informado")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "A área de atuação do orientador deve ser informado")
    @Column(nullable = false)
    private String areaAtuacao;

    @OneToMany(mappedBy = "orientador", cascade = CascadeType.ALL)
    private List<TrabalhoAcademicoTCC> tccs;

}