package br.com.projetoTCC.application.usecases.Usuario;

import br.com.projetoTCC.application.gateways.RepositorioDeUsuario;
import br.com.projetoTCC.domain.entities.Usuario.UsuarioDto;

import java.util.List;

public class ListarUsuario {

    final RepositorioDeUsuario repositorioDeUsuario;

    public ListarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public List<UsuarioDto> listarTodosUsuarios(){
        return repositorioDeUsuario.listarTodosUsuarios();
    }

    public UsuarioDto listarUsuarioPorNomeUsuario(String nome){
        return repositorioDeUsuario.listarUsuarioPorNomeUsuario(nome);
    }

    public UsuarioDto listarUsuarioPorNomeUsuarioSenha(String nome, String senha){
        return repositorioDeUsuario.listarUsuarioPorNomeUsuarioSenha(nome, senha);
    }
}
