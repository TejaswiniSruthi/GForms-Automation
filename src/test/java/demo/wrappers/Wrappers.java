package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    private static ChromeDriver driver;

    public Wrappers(ChromeDriver driver){
        Wrappers.driver = driver;
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public static void typeText(By locator, String text){
        try{
            WebElement txtBox = driver.findElement(locator);
            txtBox.clear();
            txtBox.sendKeys(text);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void click(By locator){
        try{
            driver.findElement(locator).click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void selectOptions(By locator, List<String> lst1){
        try{
            List<WebElement> lstItems = driver.findElements(locator);
            for(WebElement item:lstItems){
                String text = item.getText();
                if(lst1.contains(text)){
                    item.click();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void selectDate(int days){
        try{
            LocalDate today = LocalDate.now();
            LocalDate previousSeven = today.minusDays(days);
            String formattedDate = previousSeven.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            WebElement dateInput = driver.findElement(By.cssSelector("input[type='date']"));
            dateInput.sendKeys(formattedDate);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setTime(){
        try{
            WebElement hr = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
            hr.sendKeys("07");
            
            WebElement min = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
            min.sendKeys("30");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getEpochTime(){
        long epochMillis = System.currentTimeMillis();
        return String.valueOf(epochMillis);    
    }
}
