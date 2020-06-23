import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.Random;

public class AutomacaoBatista {

    private static //Criar instancia do driver do chrome
            WebDriver driver;

    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        //setar as propriedades do Chrome Driver
        //abrir browser e acessar URL
        //maximizando o Browser Windows
        driver.manage().window().maximize();
        driver.get("https://automacaocombatista.herokuapp.com/users/new");


    }

    @Test
    public void radioCheckBox() {
        driver.get("https://automacaocombatista.herokuapp.com/buscaelementos/radioecheckbox");
        driver.findElement(By.xpath("//label [@for ='red']")).click();
        driver.findElement(By.xpath("//label [@for ='blue']")).click();
        driver.findElement(By.xpath("//label [@for ='yellow']")).click();
        driver.findElement(By.xpath("//label [@for ='green']")).click();
        driver.findElement(By.xpath("//label [@for ='purple']")).click();
        driver.findElement(By.xpath("//label [@for ='grey']")).click();
        driver.findElement(By.xpath("//label [@for ='black']")).click();
        driver.findElement(By.xpath("//label [@for ='white']")).click();

    }

    @Test
    public void select (){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Dropdown e Select']")));
        driver.findElement(By.xpath("//a[text()='Busca de elementos']"));

        driver.findElement(By.xpath("//a [text()='Dropdown e Select']")).click();

        driver.findElement(By.xpath("//label[text()='Desenho Favorito']/preceding-sibling::div[@class='select-wrapper']"));
        driver.findElement(By.xpath("//span [text()='Dragon Ball']")).click();

        driver.findElement(By.xpath("//span [text()='Ronaldinho Gaucho']/ancestor::ul/preceding-sibling::input")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Dragon Ball']"))).click();

        WebElement listaSelecao =  driver.findElement(By.xpath("//select[@id='dropdown']"));
        JavascriptException js = (JavascriptException)driver;

        Select listaDesenhoFavorito = new Select(listaSelecao);

        listaDesenhoFavorito.selectByIndex(1);

        listaDesenhoFavorito.selectByValue("3");

        listaDesenhoFavorito.selectByVisibleText("Internet Explorer");

    }

    @AfterAll
    public static void fecharBrowser() {
        driver.quit();
    }

    @Test
    public void criarUsuario() {
        //maximizando o Browser Windows
        driver.manage().window().maximize();
        driver.get("https://automacaocombatista.herokuapp.com/users/new");

        Random random = new Random();
        random.nextInt(1000);
        String email = "gustavo" + random.nextInt() + "@gmail.com.br";
        //setar as propriedades do Chrome Driver


        //Maximizando o Browser Mac/Linux
        //driver.manage().window().fullscreen();


            //Identificando um elemento e preenchendo o campo com um texto
            driver.findElement(By.xpath("//a[text()= 'Formulário']")).click();
            driver.findElement(By.xpath("//a[text()= 'Criar Usuários']")).click();
            driver.findElement(By.xpath("//input [@id ='user_name' ]")).sendKeys("Gustavo");
            driver.findElement(By.xpath("//input [@id ='user_lastname']")).sendKeys("Prestes");
            driver.findElement(By.xpath("//input [@name = 'user[email]']")).sendKeys(email);
            driver.findElement(By.xpath("//input [@name = 'user[address]']")).sendKeys("Estrada Tambory");
            driver.findElement(By.xpath("//input [@name = 'user[university]']")).sendKeys("USPADO MLK");
            driver.findElement(By.xpath("//input [@name = 'user[profile]']")).sendKeys("Comedor de Casadas");
            driver.findElement(By.xpath("//input [@name = 'user[gender]']")).sendKeys("Helicoptero de Combate");
            //Thread.sleep(6000); má pratica
            driver.findElement(By.xpath("//input [@name = 'user[age]']")).sendKeys("24");
            driver.findElement(By.xpath("//div [@class = 'actions btn waves-effect green']")).click();
            //Atribuindo o texto da mensagem na tela para a variavel
            String mensagem = driver.findElement(By.xpath("//p[@id='notice']")).getText();

            Assertions.assertEquals("Usuário Criado com sucesso", mensagem);

        }
    }

