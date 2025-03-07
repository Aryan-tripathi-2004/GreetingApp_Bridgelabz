package org.example.greetingapp.controller;

import org.example.greetingapp.DTO.AuthUserDTO;
import org.example.greetingapp.DTO.LoginDTO;
import org.example.greetingapp.DTO.ResponseDTO;
import org.example.greetingapp.Exception.UserException;
import org.example.greetingapp.Model.AuthUser;
import org.example.greetingapp.service.EmailSenderService;
import org.example.greetingapp.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody AuthUserDTO userDTO) throws Exception{
        AuthUser user=authenticationService.register(userDTO);
        ResponseDTO responseUserDTO =new ResponseDTO("User details is submitted!", user);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) throws UserException {
        String result = authenticationService.login(loginDTO);
        ResponseDTO responseUserDTO=new ResponseDTO("Login successfully!!", result);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.OK);
    }
}