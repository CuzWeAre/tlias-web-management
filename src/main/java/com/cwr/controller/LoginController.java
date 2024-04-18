package com.cwr.controller;

import com.cwr.pojo.Emp;
import com.cwr.pojo.Result;
import com.cwr.pojo.validation.EmpLoginGroup;
import com.cwr.service.EmpService;
import com.cwr.service.KeyGenerationService;
import com.cwr.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    private final EmpService empService;
    private final KeyGenerationService keyGenerationService;

    @Value("${jwt.expiration}")
    private Long expiration;

    public LoginController(EmpService empService,KeyGenerationService keyGenerationService) {
        this.empService = empService;
        this.keyGenerationService = keyGenerationService;
    }

    @PostMapping("/login")
    public Result<Object> login(@Validated(EmpLoginGroup.class) @RequestBody Emp emp) throws NoSuchAlgorithmException {

        boolean isValidCredentials = empService.checkPassword(emp);

        if(isValidCredentials){
            Map<String, Object> map = new HashMap<>();
            map.put("username", emp.getUsername());
            String jwt = JwtUtils.generateJwt(map,keyGenerationService.getCurrentKey(),expiration);
            return Result.success(jwt);
        } else {
            return new Result<>(0,"NOT_LOGIN",null);
        }

    }
}
