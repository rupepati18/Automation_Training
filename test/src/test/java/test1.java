import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {
    WebDriver driver;
    @Before
    void initialize()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/bmi-calculator.html?ctype=metric");
        driver.manage().window().maximize();
    }

    String calculate_female(String n1, String n3, String n4)
    {
        WebElement element1 = driver.findElement(By.id("cage"));
        element1.clear();
        element1.sendKeys(n1);
        WebElement element3 = driver.findElement(By.id("cheightmeter"));
        element3.clear();
        element3.sendKeys(n3);
        WebElement element4 = driver.findElement(By.id("ckg"));
        element4.clear();
        element4.sendKeys(n4);

        WebElement element2 = driver.findElement(By.xpath("//label[@for =\"csex2\"]"));
        element2.click();

        WebElement calculate = driver.findElement(By.xpath("//input[@value =\"Calculate\"]"));
        calculate.click();
        String Actual_Result_Female = driver.findElement(By.xpath("//div[@style = \"margin-top:5px;\"]/b")).getText().trim();
        return Actual_Result_Female;
    }
    String calculate_male(String n1, String n3, String n4)
    {
        WebElement element1 = driver.findElement(By.id("cage"));
        element1.clear();
        element1.sendKeys(n1);
        WebElement element3 = driver.findElement(By.id("cheightmeter"));
        element3.clear();
        element3.sendKeys(n3);
        WebElement element4 = driver.findElement(By.id("ckg"));
        element4.clear();
        element4.sendKeys(n4);

        WebElement element2 = driver.findElement(By.xpath("//label[@for =\"csex1\"]"));
        element2.click();

        WebElement calculate = driver.findElement(By.xpath("//input[@value =\"Calculate\"]"));
        calculate.click();
        String Actual_Result_Male = driver.findElement(By.xpath("//div[@style = \"margin-top:5px;\"]/b")).getText().trim();
        return Actual_Result_Male;
    }

    void close_driver()
    {
        driver.quit();
    }


    @Test
    public static void main(String args[])
    {
       // System.out.println("Hello");
       // System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        test1 obj = new test1();
        obj.initialize();
        String Actual_Result = obj.calculate_male("20","180","60");

        System.out.println(Actual_Result);
        if(Actual_Result.equals("BMI = 18.5 kg/m2"))
            System.out.println("Pass");
        else
            System.out.println(("Fail"));

        Actual_Result = obj.calculate_female("35","160","55");
      System.out.println(Actual_Result);
        if(Actual_Result.equals("BMI = 21.5 kg/m2"))
            System.out.println("Pass");
        else
            System.out.println(("Fail"));

        Actual_Result = obj.calculate_male("50","175","65");
        System.out.println(Actual_Result);
        if(Actual_Result.equals("BMI = 21.2 kg/m2"))
            System.out.println("Pass");
        else
            System.out.println(("Fail"));


        Actual_Result = obj.calculate_female("45","150","52");
        System.out.println(Actual_Result);
        if(Actual_Result.equals("BMI = 23.1 kg/m2"))
            System.out.println("Pass");
        else
            System.out.println(("Fail"));
        obj.close_driver();


    }
}
