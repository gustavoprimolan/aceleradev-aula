package br.com.aceleradev.main;

public class MainEstrutural {

    public static void main(String[] args) {

        String login = "gustavo123";

        if(validaLogin(login)) {
            System.out.println("login valido");
        } else {
            System.out.println("Login invalido");
        }

        String login2 = "jo";

        if(validaLogin(login2)) {
            System.out.println("login valido");
        } else {
            System.out.println("Login invalido");
        }

    }

    private static boolean validaLogin(String login) {
        return login.length() > 3;
    }

}
