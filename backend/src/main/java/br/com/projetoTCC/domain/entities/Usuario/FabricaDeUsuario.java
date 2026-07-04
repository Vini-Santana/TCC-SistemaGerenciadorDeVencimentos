package br.com.projetoTCC.domain.entities.Usuario;

public class FabricaDeUsuario {

    public UsuarioDto criaUsuario(String nomeUsuario, String senhaHash){
        UsuarioDto usuarioDto = new UsuarioDto(nomeUsuario, senhaHash);
        return usuarioDto;
    }

}
