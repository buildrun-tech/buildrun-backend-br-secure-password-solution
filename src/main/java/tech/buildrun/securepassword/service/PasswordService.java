package tech.buildrun.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    private final List<ValidarPassword> validacoes;

    public PasswordService(List<ValidarPassword> validacoes) {
        this.validacoes = validacoes;
    }


    public List<String> validate(String pass) {
        List<String> failures = new ArrayList<>();

        validacoes.forEach(v -> v.validar(pass, failures));

        return failures;
    }
}
