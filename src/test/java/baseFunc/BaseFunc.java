package baseFunc;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static jdk.jfr.Timespan.*;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver","C://Users/karivalt/Desktop/CogniLearn/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void getPage(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        driver.get(url);
    }

    public WebElement getElement(By locator){
        Assertions.assertFalse(getAllElements(locator).isEmpty());
        return driver.findElement(locator);
    }

    public List<WebElement> getAllElements(By locator) {
        Assertions.assertFalse(driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public void waitUntilVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitFor10Sec () throws InterruptedException {
//        wait.until(ExpectedConditions.javaScriptThrowsNoExceptions());
            wait(1000);
    }

    public void quit() {
        driver.quit();
    }



}


//    public WebElement clickOn(By locator) {
//        Actions sorting = new Action(driver);
//        driver.findElement(locator).click();
//        Action selectObject = sorting.moveToElement(findElement(By)).click().build();
//        selectObject.perform();
//    }