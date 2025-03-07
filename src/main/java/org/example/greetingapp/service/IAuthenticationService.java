package org.example.greetingapp.service;

import org.example.greetingapp.DTO.AuthUserDTO;
import org.example.greetingapp.DTO.LoginDTO;
import org.example.greetingapp.Exception.UserException;
import org.example.greetingapp.Model.AuthUser;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;
    String login(LoginDTO loginDTO) throws UserException;
}
