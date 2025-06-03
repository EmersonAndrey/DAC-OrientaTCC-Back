package dac.orientaTCC.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "aluno")
public class Aluno {

    @Id
    @NotBlank(message = "A matricula do aluno deve ser informada")
    private String matricula;

    @NotBlank(message = "O email do aluno deve ser informado")
    @Email(message = "O email deve ser válido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha do aluno deve ser informada")
    @Column(nullable = false)
    private String senha;

    @NotBlank(message = "A nome do aluno deve ser informado")
    @Column(nullable = false)
    private String nome; 

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private TrabalhoAcademicoTCC tcc;

}