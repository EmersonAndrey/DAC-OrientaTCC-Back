package dac.orientaTCC.service;

import dac.orientaTCC.dto.AlunoCreateDTO;
import dac.orientaTCC.dto.AlunoResponseDTO;
import dac.orientaTCC.dto.UsuarioCreateDTO;
import dac.orientaTCC.mapper.AlunoMapper;
import dac.orientaTCC.model.entities.Aluno;
import dac.orientaTCC.model.entities.Usuario;
import dac.orientaTCC.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public Aluno save(Aluno aluno) { //colocar o tratamento depois
        return alunoRepository.save(aluno);
    }

    @Transactional
    public AlunoResponseDTO create(@Valid AlunoCreateDTO alunoCreateDTO) {
        Usuario usuario = usuarioService.salvar(new UsuarioCreateDTO(alunoCreateDTO.getEmail(), alunoCreateDTO.getSenha(), "ROLE_ALUNO"));
        Aluno aluno = AlunoMapper.toAluno(alunoCreateDTO);
        aluno.setUsuario(usuario);

        aluno = save(aluno);

        return AlunoMapper.toAlunoDTO(aluno);
    }

    @Transactional(readOnly = true)
    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id = %s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Aluno findByIdUsuario(Long id) {
        return alunoRepository.findByUsuarioId(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id = %s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Aluno findByEmail(String email) {
        return alunoRepository.findByUsuarioEmail(email);
    }

    @Transactional(readOnly = true)
    public Aluno findByMatricula(String matricula) {
        return alunoRepository.findByMatricula(matricula);
    }

    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Transactional
    public void remove(Long id) {
        //esperando vcs
    }

    @Transactional
    public Aluno update(AlunoCreateDTO alunoCreateDTO) {
        Aluno alunoBuscado = findByMatricula(alunoCreateDTO.getMatricula());

        if(!alunoCreateDTO.getNome().isEmpty()){
            alunoBuscado.setNome(alunoCreateDTO.getNome());
        }

        if(!alunoCreateDTO.getSenha().isEmpty()){
            alunoBuscado.getUsuario().setSenha(passwordEncoder.encode(alunoCreateDTO.getSenha()));
        }

        return alunoBuscado;
    }
}
