package br.com.bootcamp.junit;

public class SrBarriga {

    public static void teste1(){
        VariaveisEstaticas.setEmail("teste@teste.com.br");
        VariaveisEstaticas.setPassword("TEste124");
        System.out.println("Teste 1"+VariaveisEstaticas.getEmail());
        System.out.println("Teste 1"+VariaveisEstaticas.getPassword());
    }

    public static void teste2(){
        System.out.println("Teste 2"+VariaveisEstaticas.getEmail());
        System.out.println("Teste 2"+VariaveisEstaticas.getPassword());
    }
}