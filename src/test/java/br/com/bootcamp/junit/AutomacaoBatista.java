package br.com.bootcamp.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.Random;

public class AutomacaoBatista {

    //Criar instancia do driver do chrome
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup(){
        //Setar as propriedades do chrome Driver
        System.setProperty("./src/main/resources/chromedriver","chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,90);
        //Abrir browser e acessar a URL
        driver.get("https://automacaocombatista.herokuapp.com");
        //Maximizando o Browser Windows
        //driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Começar Automação Web']")).click();
        //Maximizando o Browser Mac/Linux
        driver.manage().window().fullscreen();
    }

    @Test
    public void criarUsuario() {

        Random random = new Random();
        String email = random.nextInt(10000)+"@bootcamp.com.br";

        //Identificando um elemento e preenchendo o campo com um texto
        driver.findElement(By.xpath("//a[text()='Formulário']")).click();
        //Thread.sleep(30000); má pratica

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Criar Usuários']")));

        driver.findElement(By.xpath("//a[text()='Criar Usuários']")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("user_name")));
        driver.findElement(By.id("user_name")).sendKeys("Marcos");
        driver.findElement(By.id("user_lastname")).sendKeys("Barbosa");
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_address")).sendKeys("Avenida Trindade");
        driver.findElement(By.id("user_university")).sendKeys("Nenhuma");
        driver.findElement(By.id("user_profile")).sendKeys("Qa");
        driver.findElement(By.id("user_gender")).sendKeys("M");
        driver.findElement(By.id("user_age")).sendKeys("18");

        //Clicando no botao Criar
        driver.findElement(By.name("commit")).click();

        //Atribuindo o texto da mensagem na tela para a variável
        String mensagem = driver.findElement(By.xpath("//p[@id='notice']")).getText();

        //Validando se a mensagem que eu necessito está sendo exibida na tela
        Assertions.assertEquals("Usuário Criado com sucesso", mensagem);
    }

    @Test
    public void radioCheckBox(){

        driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();

        WebElement link = driver.findElement(By.xpath("//a[text()='Radio e Checkbox']"));
        wait.until(ExpectedConditions.visibilityOf(link));
        link.click();

    }

    @Test
    public void select(){
        driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Dropdown e Select']")));

        driver.findElement(By.xpath("//a[text()='Dropdown e Select']")).click();

        driver.findElement(By.xpath("//label[text()='Desenho Favorito']/preceding-sibling::div[@class='select-wrapper']")).click();
        driver.findElement(By.xpath("//span[text()='Dragon Ball']")).click();

        driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']/ancestor::ul/preceding-sibling::input")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Ronaldinho Gaucho']")));
        driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']")).click();

        WebElement segundoCombo1 = driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']/ancestor::ul/preceding-sibling::input"));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].click();", segundoCombo1);

        WebElement listaSelecao = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select listaDesenhoFavorito = new Select(listaSelecao);

        listaDesenhoFavorito.selectByIndex(1);

//        listaDesenhoFavorito.selectByValue("3");
//
//        listaDesenhoFavorito.selectByVisibleText("Internet Explorer");
    }
    @AfterAll
    public static void fecharBrowser(){
        //Fechando meu navagador
        driver.quit();
    }
}