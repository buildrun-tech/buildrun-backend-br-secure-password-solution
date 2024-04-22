package tech.buildrun.securepassword.service;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 09/04/2024 - 12:09
 */
public interface ValidarPassword {
    void validar(String pass, List<String> failures);
}
