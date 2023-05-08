package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Driver {

    /*
    Driver Class'ındaki temel mantık extends yöntemiyle değil yani TestBase class'ına extent etmek yerine Driver class'ından
    static methodlar kullanarak driver oluştururuz. Static olduğu için class ismi ile her yerden methoda ulaşabileceğiz.

    Singleton Pattern: Tekli kullanım kalıbı
    Bir Class'tan obje oluşturulmasının önüne geçilmesi için kullanılan ifade.
    Bir Class'tan obje oluşturmanın önüne geçmek için default constructor'ın kullanımını engellemek için private
    access modifier kullanarak bir constructor oluştururuz.
     */
    private Driver(){
    }

    static WebDriver driver;
    public static WebDriver getDriver(){
        /*
        Driver'ı her çağırdığında yeni bir pencere açılmasının önüne geçmek için
        if bloğu içinde Eğer driver'a değer atanmamışsa değer ata, Eğer değer atanmışsa
        Driver'ı aynı sayfada RETURN et. Bunun için sadece yapmamız gereken if (driver==null) kullanmak
         */
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){// Driver'a değer atanmışsa
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){
        if (driver!=null){// Driver'a değer atanmışsa
            driver.quit();
            driver=null;
        }
    }

}
