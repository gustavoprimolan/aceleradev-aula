package br.com.aceleradev.exceptions;

public class LoginInvalidoException extends RuntimeException{
    public LoginInvalidoException(String message) {
        super(message);
    }
}
