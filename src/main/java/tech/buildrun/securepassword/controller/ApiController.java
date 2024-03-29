package tech.buildrun.securepassword.controller;

import io.micrometer.common.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.securepassword.service.PasswordService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class ApiController {

    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping
    public ResponseEntity<List<String>> isSafe(@RequestBody BodyRequest request){
        var failures = passwordService.validate(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(failures);
    }
}
