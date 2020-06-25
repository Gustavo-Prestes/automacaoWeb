package br.com.bootcamp.settings;


import br.com.bootcamp.interfaces.BrowserImp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    protected void initializeWebApplication (BrowserImp webApplication){
        if (webDriver != null)
            webDriver.close();
        webDriver = webApplication.getDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 60);

    }

    //Fecha o Driver Web
    protected static void closeWeb(){
        webDriver.quit();
    }
}
