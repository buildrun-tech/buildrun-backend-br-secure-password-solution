package tech.buildrun.securepassword.service.impl;

import org.springframework.stereotype.Service;
import tech.buildrun.securepassword.service.ValidarPassword;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Autor Jairo Nascimento
 * @Created 09/04/2024 - 12:12
 */
@Service
public class ValidateNumber implements ValidarPassword {
    @Override
    public void validar(String pass, List<String> failures) {
        if (!Pattern.matches(".*[0-9].*", pass)) {
            failures.add("A senha deve possuir pelo menos um número");
        }
    }
}

