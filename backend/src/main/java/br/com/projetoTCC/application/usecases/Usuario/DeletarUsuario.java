package br.com.projetoTCC.application.usecases.Usuario;

import br.com.projetoTCC.application.gateways.RepositorioDeUsuario;
import br.com.projetoTCC.domain.entities.Usuario.UsuarioDto;

public class DeletarUsuario {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public DeletarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public UsuarioDto deletarUsuario(Long id, UsuarioDto usuarioDto){
        return repositorioDeUsuario.deletarUsuario(id, usuarioDto);}
}
