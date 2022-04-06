package knowit.pages;

import config.Config;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenshot.ScreenShotTaker;
import ui.webdrivermanager.WebDriverManager;

import java.io.IOException;
import java.util.ArrayList;


public class HomePage extends WebDriverManager
{
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Config applicationConfig;

    @FindBy(xpath="//div[@class='coi-banner__wrapper']")
    WebElement consentBanner;

    @FindBy(xpath="//button[@class='coi-banner__accept']")
    WebElement acceptConsentButton;

    @FindBy(xpath="//div[@class='video-container']")
    WebElement videoContainer;

    @FindBy(xpath="//div[@class='top-icon']//a[@data-type='search']")
    WebElement searchOption;

    @FindBy(xpath="//input[@type='search']")
    WebElement searchBox;

    @FindBy(xpath="//a[@href='https://www.facebook.com/weareknowit']")
    WebElement facebookIcon;

    public HomePage()
    {
        webDriver = driver;
        webDriverWait = wait;
        applicationConfig = config;
        PageFactory.initElements(webDriver, this);
    }

    public void verify_home_page()
    {
        try {
            if(consentBanner.isDisplayed())
            {
                acceptConsentButton.click();
            }

        } catch (Exception e) {
            // Do nothing
        }

        Assert.assertTrue("Home Page is not Loaded",
                wait.until(ExpectedConditions.visibilityOf(videoContainer)).isDisplayed());
    }

    public void click_search_option()
    {
        Assert.assertTrue("Search option is not available",
                wait.until(ExpectedConditions.visibilityOf(searchOption)).isDisplayed());

        searchOption.click();
    }

    public void get_search_box_value()
    {
        Assert.assertTrue("Search box is not available",
                wait.until(ExpectedConditions.visibilityOf(searchBox)).isDisplayed());

        String defaulSearchString = searchBox.getAttribute("placeholder");
        System.out.println("Default Value = " +  defaulSearchString);
    }

    public void type_string_search_box()
    {
        searchBox.sendKeys("Automation");
    }

    public void keyboard_enter()
    {
        searchBox.sendKeys(Keys.ENTER);
    }

    public void scroll_down()
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void click_facebook_icon()
    {
        wait.until(ExpectedConditions.visibilityOf(facebookIcon)).click();
    }

    public void close_recently_opened_tab() throws InterruptedException
    {
        ArrayList<String> tabs= new ArrayList<String> (driver.getWindowHandles());
        Thread.sleep(2000); // pause for observation
        driver.switchTo().window(tabs.get(1)); //go to recently opened tab
        Thread.sleep(2000); // Add sleep to verify if new tab is opened
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void navigate_to_original_tab_scroll_up() throws InterruptedException {
        ArrayList<String> tabs= new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)"); //Not working so will use Keys instead
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.CONTROL,Keys.HOME)).perform();
        Thread.sleep(2000);
    }

    public void take_screenshot() throws IOException
    {
        ScreenShotTaker screenShotTaker = new ScreenShotTaker();
        screenShotTaker.takeScreenShot(driver, "KnowIt_HomePage");
    }

}
