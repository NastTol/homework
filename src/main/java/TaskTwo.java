import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.ArrayList;


public class TaskTwo {
    public static void main(String[] args) {
        final WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement field1 = driver.findElement(By.name("email"));
        field1.sendKeys("webinar.test@gmail.com");
        WebElement field2 = driver.findElement(By.name("passwd"));
        field2.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement button = driver.findElement(By.name("submitLogin"));
        sleep(1000);
        button.click();
        sleep(1000);
        ArrayList<String> links = new ArrayList<String>();
        List<WebElement> elementsAndLinks = driver.findElements(By.cssSelector("nav#nav-sidebar ul.menu>li>a"));
        for (WebElement el : elementsAndLinks) {
            String link = el.getAttribute("href");
            if (link != null) {
                links.add(link);
            }
        }

        for (String link : links) {
            driver.get(link);
            String title = driver.findElement(By.tagName("h2")).getText();
            System.out.println(title);
            driver.navigate().refresh();
            sleep(1000);
            if (!title.equals(driver.findElement(By.tagName("h2")).getText())) {
                System.out.println("Failed");
            }
        }
    }

    private static void sleep(int timeout) {

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/webdriver/chromedriver.exe" );
        return new ChromeDriver();
    }
}
