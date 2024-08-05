    package Core;
    
    
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeDriverService;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.WebDriverWait;
    
    import java.time.Duration;
    
    public class DriverManager {
        public static WebDriver webDriver;
        public static WebDriverWait wait;
    
        public static void initializeBrowser(String browser) {
            if (browser.equals("chrome")) {
                webDriver = new ChromeDriver(ChromeDriverService.createDefaultService());
            } else if (browser.equals("firefox")) {
                webDriver = new FirefoxDriver();
            }
            wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        }
    
        public static void closeDriver() {
            if (webDriver != null) {
                webDriver.quit();
            }
        }
    }
