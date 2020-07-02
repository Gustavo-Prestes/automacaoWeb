package br.com.bootcamp.runTest;

import br.com.bootcamp.settings.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions (monochrome = true, dryRun = false, snippets = CucumberOptions.SnippetType.CAMELCASE,plugin = {"pretty", "json:target/cucumber.json"},
    features = {"./src/test/resources/"}, glue = {"br.com.projeto.web.steps",
            "br.com.projeto.app.steps", "br.com.projeto.configuration",
            "br.com.projeto.commons", "br.com.projeto.bean"},
            tags = {"test-web","@app"})

    public class RunTest extends BaseTest {

}
