package br.com.projetoTCC.domain.entities.Usuario;

public class UsuarioDto {

    private Long id;
    private String nomeUsuario;
    private String senhaHash;

    public UsuarioDto(Long id, String nomeUsuario, String senhaHash) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;

    }

    public UsuarioDto(String nomeUsuario, String senhaHash) {
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;

    }

    public Long getId() {
        return id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
}