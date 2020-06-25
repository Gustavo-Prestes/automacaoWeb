package br.com.bootcamp.enums;

import br.com.bootcamp.interfaces.BrowserImp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public enum Browser implements BrowserImp {
    CHROME {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver", "chromewindows/chromedriver.exe");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            return new ChromeDriver(options);

        }
    }
}
