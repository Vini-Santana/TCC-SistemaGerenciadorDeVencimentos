package br.com.projetoTCC.infra.gateways.Usuario;

import br.com.projetoTCC.application.gateways.RepositorioDeUsuario;
import br.com.projetoTCC.domain.entities.Usuario.UsuarioDto;
import br.com.projetoTCC.domain.exceptions.UsuarioNotFoundExceptionId;
import br.com.projetoTCC.infra.persistence.Usuario.UsuarioEntity;
import br.com.projetoTCC.infra.persistence.Usuario.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;
    private final BCryptPasswordEncoderAdapter passwordEncoder;


    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper, BCryptPasswordEncoderAdapter passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsuarioDto criarUsuario(UsuarioDto usuarioDto) {
        UsuarioEntity entity = mapper.toEntity(usuarioDto);
        entity.setSenhaHash(passwordEncoder.encode(usuarioDto.getSenhaHash()));
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public UsuarioDto alterarUsuario(Long id, UsuarioDto usuarioDto) {

        UsuarioEntity entity = new UsuarioEntity(id, usuarioDto.getNomeUsuario(), usuarioDto.getSenhaHash());
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<UsuarioDto> listarTodosUsuarios() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto listarUsuarioPorNomeUsuario(String nomeUsuario) {
        UsuarioEntity usuarioEntity = repository.findByNomeUsuario(nomeUsuario);

        return mapper.toDomain(usuarioEntity);
    }

    @Override
    public UsuarioDto listarUsuarioPorNomeUsuarioSenha(String usuario, String senha) {

        UsuarioEntity usuarioDto = repository.findByNomeUsuario(usuario);

        if (!passwordEncoder.matches(senha, usuarioDto.getSenhaHash())) {
            throw new UsuarioNotFoundExceptionId(usuario);
        }

        return mapper.toDomain(usuarioDto);
    }

    @Override
    public UsuarioDto deletarUsuario(Long id, UsuarioDto usuarioDto) {
        repository.deleteById(id);
        return usuarioDto;
    }
}