package br.com.bootcamp.funcionalidade;

import br.com.bootcamp.pages.HomePage;
import br.com.bootcamp.settings.BaseTest;
import org.openqa.selenium.WebDriver;

public class HomeFuncionalidade extends BaseTest {

    private HomePage homePage;

    public HomeFuncionalidade(){
        this.homePage = new HomePage(WebDriver);

    }
}
