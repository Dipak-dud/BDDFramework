import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriverManager and initialize ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.demoblaze.com/index.html");

        // Find the search box, enter text, and submit
        WebElement category = driver.findElement(By.id("itemc"));
        category.click();

        // Wait for results and verify the page title
        String expectedTitle = "STORE";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, driver.getTitle());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
