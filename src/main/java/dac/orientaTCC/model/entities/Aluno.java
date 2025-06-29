package dac.orientaTCC.model.entities;

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
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A matricula do aluno deve ser informada")
    @Column(nullable = false, unique = true, name = "matricula")
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

}