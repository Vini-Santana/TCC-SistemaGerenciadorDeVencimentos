package br.com.projetoTCC.application.usecases.Usuario;

import br.com.projetoTCC.application.gateways.PasswordEncoder;
import br.com.projetoTCC.application.gateways.RepositorioDeUsuario;
import br.com.projetoTCC.domain.entities.Usuario.UsuarioDto;

public class CriarUsuario {
    private final RepositorioDeUsuario repositorio;
    private final PasswordEncoder passwordEncoder;

    public CriarUsuario(RepositorioDeUsuario repositorio, PasswordEncoder passwordEncoder) {
        this.repositorio = repositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDto criarUsuario(UsuarioDto usuarioDto){
        return repositorio.criarUsuario(usuarioDto);
    }
}
