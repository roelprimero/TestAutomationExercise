package amazon.pages;

import config.Config;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.webdrivermanager.WebDriverManager;

import java.util.List;


public class HomePage extends WebDriverManager {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Config applicationConfig;

    @FindBy(xpath = "//div[@id='nav-logo']")
    WebElement amazonLogo;

    @FindBy(xpath = "//div[@id='nav-search-dropdown-card']")
    WebElement searchNav;

    @FindBy(xpath = "//div[@id='nav-search-dropdown-card']//select[@aria-describedby='searchDropdownDescription']")
    WebElement searchNavWithSelect;

    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
    WebElement searchDropDown;

    public HomePage() {
        webDriver = driver;
        webDriverWait = wait;
        applicationConfig = config;
        PageFactory.initElements(webDriver, this);
    }

    public void verify_home_page() {
        Assert.assertTrue("Home Page is not Loaded",
                wait.until(ExpectedConditions.visibilityOf(amazonLogo)).isDisplayed());
    }

    public void hover_searchbox() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(searchNavWithSelect).build().perform();
        Thread.sleep(5000); // Hold for 5 seconds
        String hoverMessage1 = searchNavWithSelect.getAttribute("title");
        Thread.sleep(2000); // Add sleep to verify if new tab is opened
        System.out.println("Hover Message = " + hoverMessage1);
    }

    public void click_all() throws InterruptedException {

        searchNav.click();
        Thread.sleep(2000);
    }

    public void print_dropdown_options() {
        Select select = new Select(searchDropDown);
        List<WebElement> options = select.getOptions();
        System.out.println("PRINTING OUT OPTIONS START");
        for (WebElement e : options) {
            System.out.println("Option > " + e.getText());
        }
        System.out.println("PRINTING OUT OPTIONS END");
    }
}
