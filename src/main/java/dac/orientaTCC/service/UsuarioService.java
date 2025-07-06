package dac.orientaTCC.service;

import dac.orientaTCC.dto.UsuarioCreateDTO;
import dac.orientaTCC.exception.EmailUniqueViolationException;
import dac.orientaTCC.exception.EntityNotFoundException;
import dac.orientaTCC.exception.SenhaInvalidaException;
import dac.orientaTCC.mapper.UsuarioMapper;
import dac.orientaTCC.model.entities.Usuario;
import dac.orientaTCC.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvar(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = UsuarioMapper.toUsuario(usuarioCreateDTO);
        try{
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));//fazendo isso o passwordEncoder.encode realiza a criptografia da senha retornando a senha criptografada
            return usuarioRepository.save(usuario);

        }catch (DataIntegrityViolationException e){
            throw new EmailUniqueViolationException(String.format("Email {%s} já cadastrado", usuario.getEmail()));
        }
    }


    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id = '%s' não encontrado", id))
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {

        if(!novaSenha.equals(confirmaSenha)){
            throw new SenhaInvalidaException("Nova senha não confere com a confirmação de senha");
        }
        Usuario user = buscarPorId(id);

        if(!passwordEncoder.matches(senhaAtual, user.getSenha())){//com criptografia, passa senha atual mandada na requisição e compara usando o matches com a senha criptogrfada do user.getPassword
            throw new SenhaInvalidaException("Sua senha não confere.");
        }

        user.setSenha(passwordEncoder.encode(novaSenha));
        return user;
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorEmail(String username) {
        return usuarioRepository.findByEmail(username).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario com userName = %s não encontrado", username)));
    }
}
