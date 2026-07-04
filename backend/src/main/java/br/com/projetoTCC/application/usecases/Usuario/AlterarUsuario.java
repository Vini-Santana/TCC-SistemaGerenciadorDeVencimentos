package br.com.projetoTCC.application.usecases.Usuario;

import br.com.projetoTCC.application.gateways.RepositorioDeUsuario;
import br.com.projetoTCC.domain.entities.Usuario.UsuarioDto;


public class AlterarUsuario {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public AlterarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public UsuarioDto alteraUsuario(Long idUsuario, UsuarioDto usuarioDto){
        return repositorioDeUsuario.alterarUsuario(idUsuario, usuarioDto);}
}
