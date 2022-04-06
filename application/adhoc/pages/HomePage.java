package adhoc.pages;

import config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.webdrivermanager.WebDriverManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class HomePage extends WebDriverManager {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Config applicationConfig;

    public HomePage() {
        webDriver = driver;
        webDriverWait = wait;
        applicationConfig = config;
        PageFactory.initElements(webDriver, this);
    }

    public void go_to_w3schools() {
        driver.get("https://www.w3schools.com/");
    }

    public void get_and_print_all_links() throws InterruptedException  {
        Thread.sleep(5000);
        List<WebElement> allLinks = driver.findElements(By.xpath("//*[@href]"));
        System.out.println("PRINTING OUT LINKS START");
        for (WebElement e : allLinks) {
            System.out.println("link > " + e.getText());
        }
        System.out.println("PRINTING OUT LINKS END");
    }

    public void go_to_results() {
        Path sampleFile = Paths.get("results.html");
        driver.get(sampleFile.toUri().toString());
    }

    public void print_results() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table//tr")); //4 rows
        for(WebElement e: allRows)
        {
            if (e == allRows.get(0)) continue; //Skip first iteration
            List<WebElement> rowContent = e.findElements(By.xpath("td")); //contains 3 tds
            System.out.println(rowContent.get(0).getText() + " scored " + rowContent.get(1).getText() + " in " +
                    rowContent.get(2).getText());
        }
    }

    public void multiple_handles()
    {
        WebElement elementToFind = driver.findElement(By.id("elementToFind"));
        String parent=driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> handleIterator= handles.iterator();
        while(handleIterator.hasNext())
        {
            if(elementToFind.isDisplayed())
            {
                //If the element is in the current window, break the loop
                break;
            }

            String child_window=handleIterator.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                try {
                    if(elementToFind.isDisplayed())
                    {
                        //Do any operation here
                        break;
                    }
                } catch (Exception e) {
                    // Do nothing for now
                } finally {
                    continue;
                }
            }
        }
    }
}

