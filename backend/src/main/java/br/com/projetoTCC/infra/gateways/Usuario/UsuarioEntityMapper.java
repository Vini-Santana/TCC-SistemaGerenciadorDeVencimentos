package br.com.projetoTCC.infra.gateways.Usuario;

import br.com.projetoTCC.domain.entities.Usuario.UsuarioDto;
import br.com.projetoTCC.infra.persistence.Usuario.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity (UsuarioDto usuarioDto){
        return new UsuarioEntity(usuarioDto.getNomeUsuario(), usuarioDto.getSenhaHash());
    }

    public UsuarioDto toDomain(UsuarioEntity entity){
        return new UsuarioDto(entity.getId(), entity.getNomeUsuario(), entity.getSenhaHash());
    }
}
