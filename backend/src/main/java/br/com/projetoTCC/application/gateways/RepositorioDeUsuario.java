package br.com.projetoTCC.application.gateways;

import br.com.projetoTCC.domain.entities.Usuario.UsuarioDto;

import java.util.List;

public interface RepositorioDeUsuario {


    UsuarioDto criarUsuario(UsuarioDto produto);

    List<UsuarioDto> listarTodosUsuarios();

    UsuarioDto listarUsuarioPorNomeUsuario(String nomeUsuario);

    UsuarioDto listarUsuarioPorNomeUsuarioSenha(String nomeUsuario, String senha);

    UsuarioDto deletarUsuario(Long id, UsuarioDto usuarioDto);

    UsuarioDto alterarUsuario(Long id, UsuarioDto usuarioDto);


}
