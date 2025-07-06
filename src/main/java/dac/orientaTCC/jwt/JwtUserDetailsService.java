package dac.orientaTCC.jwt;

import dac.orientaTCC.enums.Role;
import dac.orientaTCC.model.entities.Usuario;
import dac.orientaTCC.repository.UsuarioRepository;
import dac.orientaTCC.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    @Override //vai buscar um usuario por email, se ele for encontrado ele é retornado no formato de um userDetails
    public UserDetails loadUserByUsername(String email){
        Usuario usuario = usuarioService.buscarPorEmail(email);
        log.info("Usuário encontrado: {}, senha no banco: {}", usuario.getEmail(), usuario.getSenha());
        return new JwtUserDetails(usuario);
    }

    //utilizado para gerar o token jwt, quando o cliente vai autenticar na aplicação
    public JwtToken getTokenAuthenticated(String email){

        Role role = usuarioService.buscarPorEmail(email).getTipoRole();
        return JwtUtils.createToken(email, role.name().substring("Role_".length()));
    }
}
