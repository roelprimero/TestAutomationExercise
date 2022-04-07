package screenshot;

import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.AShot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenShotTaker {
    public void takeScreenShot(WebDriver webdriver, String fileName) throws IOException {
        //TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        Screenshot screenshot = new AShot().takeScreenshot(webdriver);
        //String fullPath = "D:\\KnowITQA\\output\\" + fileName + ".PNG";
        String fullPath = "output\\" + fileName + ".PNG";
        Assert.assertTrue(ImageIO.write(screenshot.getImage(), "PNG", new File(fullPath)));
        System.out.println("Taking screenshot at: " +fullPath);
    }
}
