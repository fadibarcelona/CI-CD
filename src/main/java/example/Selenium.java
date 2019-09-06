package example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selenium {
public static void main(String[] args) {
SSystem.setProperty("browser.gecko.driver", System.getProperty("/var/lib/jenkins/workspace/servicenow/")+"/geckodriver");
WebDriver driver = new FirefoxDriver();

String baseUrl = “https://experitest.com/free-trial/”;
String expectedTitle = “Free trial”;
String actualTitle = “”;
driver.get(baseUrl);
actualTitle = driver.getTitle();
if (actualTitle.contentEquals(expectedTitle)){
System.out.println(“TEST PASSED!”);
} else {
System.out.println(“TEST FAILED”);
}
driver.close();
}
}
