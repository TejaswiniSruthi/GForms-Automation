package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    static ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test
    public void testCase01() throws InterruptedException {
        System.out.println("testCase01 executed");
        Wrappers wrap = new Wrappers(driver);

        //Navigate to Google form
        System.out.println("Step 1: Opening URL!");
        wrap.openUrl("https://forms.gle/wjPkzeSEk1CM7KgGA");

        // Wait until the page is loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']")));

        // Fill in Crio Learner in the first text box
        System.out.println("Step 2: Enter Crio Learner Name");
        wrap.typeText(By.xpath("(//input[@type = 'text'])[1]"), "Crio Learner");
        Thread.sleep(2000);

        // Answer 'Why are you practicing Automation' with EPOCH time
        System.out.println("Step 3: Enter the reason with EPOCH time");
        wrap.typeText(By.xpath("//textarea"), "I want to be the best QA Engineer! "+ Wrappers.getEpochTime());
        Thread.sleep(2000);

        // Select Radio Button for Test Experience
        System.out.println("Step 4: Select Years of Experience");
        List<String> list1 = Arrays.asList("0 - 2");
        wrap.selectOptions(By.xpath("//span[@class='aDTYNe snByac OvPDhc OIC90c']"),list1);
        Thread.sleep(2000);

        // Select Check Box for learnt skills
        System.out.println("Step 5: Select the skills learnt");
        List<String> list2 = Arrays.asList("Java","Selenium","TestNG");
        wrap.selectOptions(By.className("eBFwI"),list2);
        Thread.sleep(2000);

        // Select dropdown for 'How should you be addressed?'
        System.out.println("Step 6: Chosse what would you like to be called");
        wrap.click(By.xpath("//div[@role='option']//span[text()='Choose']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[text()='Ms']")));
        wrap.click(By.xpath("//div[@role='option']//span[text()='Ms']"));
        Thread.sleep(2000);

        // Select Date for seven days ago
        System.out.println("Step 7: Select the seven days ago date");
        Wrappers.selectDate(7);
        Thread.sleep(2000);

        // Select Time
        System.out.println("Step 8: Set Time");
        Wrappers.setTime();

        //Submit the form
        System.out.println("Step 9: Submit the form");
        wrap.click(By.xpath("//span[text()='Submit']"));
        Thread.sleep(2000);

        // Wait untill you see response page
        System.out.println("Step 10: Wait for the page to load");
        wait.until(ExpectedConditions.urlContains("formResponse"));

        // Print the same message on the console upon successful completion
        System.out.println("Step 11: Print the Success Message!");
        System.out.println(driver.findElement(By.className("vHW8K")).getText());
        Thread.sleep(2000);

        Thread.sleep(5000);
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}