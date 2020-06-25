package br.com.bootcamp.junit;

public class VariaveisEstaticas {

    private static String email;
    private static String password;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        VariaveisEstaticas.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        VariaveisEstaticas.password = password;
    }
}