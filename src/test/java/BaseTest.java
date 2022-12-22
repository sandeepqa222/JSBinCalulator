import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationProp;
import utilities.DriverManager;

public class BaseTest extends DriverManager {

    @BeforeMethod
    public void driverSetup() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver(options));

        DriverManager.getDriver().get(ConfigurationProp.getProp().get("url").toString());
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }


}
