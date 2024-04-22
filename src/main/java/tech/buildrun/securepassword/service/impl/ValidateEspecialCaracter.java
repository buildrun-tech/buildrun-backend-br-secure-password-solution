package tech.buildrun.securepassword.service.impl;

import org.springframework.stereotype.Service;
import tech.buildrun.securepassword.service.ValidarPassword;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Autor Jairo Nascimento
 * @Created 09/04/2024 - 12:10
 */
@Service
public class ValidateEspecialCaracter implements ValidarPassword {
    @Override
    public void validar(String pass, List<String> failures) {
        if (!Pattern.matches(".*[\\W].*", pass)) {
            failures.add("A senha deve possuir pelo menos um caracter especial (e.g, !@#$%)");
        }
    }
}