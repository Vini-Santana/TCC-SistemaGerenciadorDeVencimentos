package br.com.projetoTCC.application.gateways;

public interface PasswordEncoder {

    String encode(String senha);

    boolean matches(String senha, String hash);


}
