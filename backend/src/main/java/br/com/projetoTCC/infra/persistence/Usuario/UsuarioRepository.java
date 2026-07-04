package br.com.projetoTCC.infra.persistence.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByNomeUsuario(String nomeUsuario);

}
