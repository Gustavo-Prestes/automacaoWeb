import br.com.bootcamp.variaveis.VariaveisEstaticas;

public class SrBarriga {
    VariaveisEstaticas variaveisEstaticas = new VariaveisEstaticas();

    public static void main(String[] args) {
        teste1();
        teste02();
    }
    public static void teste1 (){
    VariaveisEstaticas.setEmail("teste@teste.com.br");
    VariaveisEstaticas.setPassword("teste123");
    System.out.println("Teste 1 "+VariaveisEstaticas.getEmail());
    System.out.println("Teste 1 "+VariaveisEstaticas.getPassword());
    }
    public static void teste02(){
        System.out.println("Teste2 "+VariaveisEstaticas.getEmail());
        System.out.println("Teste2 "+VariaveisEstaticas.getPassword());

    }
}
