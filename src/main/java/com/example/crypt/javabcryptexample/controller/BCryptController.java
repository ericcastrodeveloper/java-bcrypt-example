package com.example.crypt.javabcryptexample.controller;

import com.example.crypt.javabcryptexample.domain.BCryptDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bcrypt")
public class BCryptController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/encode")
    public ResponseEntity<String> getPasswordEncrypted(@RequestHeader String password){
        return new ResponseEntity<>(passwordEncoder.encode(password), HttpStatus.OK);
    }

    @PostMapping("/matches")
    public ResponseEntity<Boolean> matches(@RequestBody BCryptDomain bCryptDomain){
        return new ResponseEntity<>(passwordEncoder.matches(bCryptDomain.getPassword(), bCryptDomain.getPasswordEncoded()), HttpStatus.OK);
    }
}
