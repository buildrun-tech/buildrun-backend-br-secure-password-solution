package tech.buildrun.securepassword.service;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validate(String pass) {
        List<String> failures = new ArrayList<>();

        validateLength(pass, failures);
        validateUppercase(pass, failures);
        validateLowercase(pass, failures);
        validateNumber(pass, failures);
        validateSpecialChars(pass, failures);

        return failures;
    }
    private static void validateLength(String pass, List<String> failures) {
        if (StringUtils.isBlank(pass) || pass.length() < 8) {
            failures.add("A senha deve possuir pelo menos 08 caracteres.");
        }
    }

    private static void validateUppercase(String pass, List<String> failures) {
        if (!Pattern.matches(".*[A-Z].*", pass)) {
            failures.add("A senha deve possuir pelo menos uma letra maiúscula.");
        }
    }

    private static void validateLowercase(String pass, List<String> failures) {
        if (!Pattern.matches(".*[a-z].*", pass)) {
            failures.add("A senha deve possuir pelo menos uma letra minúscula.");
        }
    }

    private static void validateNumber(String pass, List<String> failures) {
        if (!Pattern.matches(".*[0-9].*", pass)) {
            failures.add("A senha deve possuir pelo menos um numero.");
        }
    }
    private static void validateSpecialChars(String pass, List<String> failures) {
        if (!Pattern.matches(".*[\\W].*", pass)) {
            failures.add("A senha deve possuir pelo menos um caractere especial.");
        }
    }
}
