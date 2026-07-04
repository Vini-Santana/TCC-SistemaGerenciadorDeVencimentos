package br.com.projetoTCC.infra.gateways.Usuario;

import br.com.projetoTCC.application.gateways.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderAdapter implements PasswordEncoder {

    private final BCryptPasswordEncoder encoder;

    public BCryptPasswordEncoderAdapter() {
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(String senha) {
        return encoder.encode(senha);
    }

    @Override
    public boolean matches(String senha, String hash) {
        return encoder.matches(senha, hash);
    }
}
