package common.hooks;

import config.ConfigReader;
import io.cucumber.java.*;
import org.apache.commons.lang.NotImplementedException;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.driver.WebDriverFactory;
import ui.webdrivermanager.WebDriverManager;
import java.time.Duration;


public class HookManager {
    Scenario scenario;
    WebDriverManager webDriverManager;

    @Before
    public void beforeScenario(Scenario scenario) throws Exception
    {
        this.scenario = scenario;
        System.out.println("Executing Scenario - " + scenario.getName());

        if (scenario.getUri().toString().contains("ui"))
        {
            //Initialize UI Setup
            System.out.println("Initializing UI Setup");

            //Get Web Driver Instance
            webDriverManager.driver = WebDriverFactory.createChromeWebDriver();

            //Get Application name
            String applicationName = scenario.getUri().toString().split("testscripts/")[1].split("/")[0];

            if (applicationName.equals("adhoc")){
                //use knowit as default application for adhoc written tests
                applicationName = "knowit";
            }

            //Get config files data
            String application_url = ConfigReader.get_environment_config_url(applicationName);
            webDriverManager.config = ConfigReader.get_config(applicationName);

            //Initialize and get WebDriver Wait Instance
            webDriverManager.wait = new WebDriverWait(webDriverManager.driver, Duration.ofSeconds(20), Duration.ofSeconds(5));

            //Go to Application's URL
            webDriverManager.driver.get(application_url);
        }
        else if (scenario.getUri().toString().contains("api"))
        {
            //Un-used
            //Initialize API Setup
            System.out.println("Initializing API Setup");
        }
        else
        {
            throw new NotImplementedException();
        }

    }

    @BeforeStep
    public void beforeStep(Scenario scenario)
    {
        this.scenario = scenario;
        System.out.println("Executing " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario)
    {
        this.scenario = scenario;
        System.out.println("Status of " + scenario.getName() + " is " + scenario.getStatus());
    }


    @After
    public void afterScenario(Scenario scenario){
        this.scenario = scenario;
        if (scenario.getUri().toString().contains("ui"))
        {
            System.out.println("Ending " + scenario.getName());
            if (webDriverManager.driver != null)
                webDriverManager.driver.quit();
        }
    }
}
