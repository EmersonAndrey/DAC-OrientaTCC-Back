package dac.orientaTCC.model.entities;

import dac.orientaTCC.enums.TipoUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @NotBlank(message = "O email do usuário deve ser informado")
    private String email;

    @NotBlank(message = "A senha do usuário deve ser informada")
    private String senha;

    @NotBlank(message = "A nome do usuário deve ser informado")
    private String nome;

    @NotNull(message = "O tipo do usuário deve ser informado")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    private String matricula; // ou vai ter matricula ou SIAPE
    private String SIAPE; // Vai depender do tipo de usuario que ele é

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSIAPE() {
        return SIAPE;
    }

    public void setSIAPE(String sIAPE) {
        SIAPE = sIAPE;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
