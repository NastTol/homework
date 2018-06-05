import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TaskOne {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement field1 = driver.findElement(By.name("email"));
        field1.sendKeys("webinar.test@gmail.com");
        WebElement field2 = driver.findElement(By.name("passwd"));
        field2.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement button = driver.findElement(By.name("submitLogin"));
        sleep(1000);
        button.click();
        sleep(1000);
        WebElement image = driver.findElement(By.id("employee_infos"));
        image.click();
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
        sleep(1000);
        driver.quit();
    }
    private static WebDriver initChromeDriver(){
        return new ChromeDriver();

    }
    private static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
            } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}