package example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
public class Selenium {
public static void main(String[] args) {
//System.setProperty("webdriver.chrome.driver","/var/lib/jenkins/workspace/selenium-free/geckodriver"); // <– Change this path
System.setProperty("browser.gecko.driver", System.getProperty("/var/lib/jenkins/workspace/selenium-free/")+"/geckodriver");
WebDriver driver = new FirefoxDriver();
String baseUrl = "https://experitest.com/free-trial/";
String expectedTitle = "Free trial";
String actualTitle = "";
driver.get(baseUrl);
actualTitle = driver.getTitle();
if (actualTitle.contentEquals(expectedTitle)){
System.out.println("TEST PASSED!");
} else {
System.out.println("TEST FAILED");
}
driver.close();
}
}
