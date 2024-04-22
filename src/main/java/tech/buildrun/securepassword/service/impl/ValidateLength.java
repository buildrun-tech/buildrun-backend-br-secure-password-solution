package tech.buildrun.securepassword.service.impl;

import org.springframework.stereotype.Service;
import tech.buildrun.securepassword.service.ValidarPassword;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 09/04/2024 - 12:11
 */
@Service
public class ValidateLength implements ValidarPassword {
    @Override
    public void validar(String pass, List<String> failures) {
        if (pass != null && pass.length() < 8) {
            failures.add("A senha deve possuir pelo menos 8 caracteres");
        }
    }
}

