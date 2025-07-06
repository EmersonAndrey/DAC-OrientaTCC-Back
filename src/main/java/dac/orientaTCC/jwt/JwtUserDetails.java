package dac.orientaTCC.jwt;

import dac.orientaTCC.model.entities.Usuario;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class JwtUserDetails extends User {

    private Usuario usuario;

    public JwtUserDetails(Usuario usuario){
        super(usuario.getEmail(), usuario.getSenha(), AuthorityUtils.createAuthorityList(usuario.getTipoRole().name()));
    }

    //so precisa pegar o id e a role, pq como a classe extends da User ela ja tras o getEmail e o getSenha.
    public Long getId(){
        return this.usuario.getId();
    }

    public String getRole(){
        return this.usuario.getTipoRole().name();
    }

}
