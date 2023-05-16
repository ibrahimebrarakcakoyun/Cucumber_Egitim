package techproed.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.Driver;

import java.awt.*;

public class Hooks {
    /**
     Scenario'lar arasındaki bağlantıyı sağlayan glu parametresine koyduğumuz stepDefiniition package'ı içerisinde @Before
     ve @After gibi bir notasyon varsa extend yapmamıza gerek kalmadan her scenariodan önce veya sonra bu metorlar çalışacaktır.
        Cucumber'da @Before, @After kullanma ihtiyacımız olursa bunu Hooks class'ına koyarız.
        İstersek yeni bir pacage oluşturup bunun içine de Hooks Class'ını koyabiliriz. Eğer yeni bir package içerine koyarsak
     Runner Class'ındaki glue parametresine bu package'da eklememiz gerekir.
        Kullandığımız @Before, @After notasyonları Junit'ten değil Cucumber'dan olmalıdır.
     */
    @Before("@All")
    public void setUp1(){
        System.out.println("Testler çalışmaya başladı");
    }

    @Before("@gr1")
    public void setUp2(){
        System.out.println("Amazonda SQL Aratıldı");
    }

    @Before("@gr2")
    public void setUp3(){
        System.out.println("Amazonda Java Aratıldı");
    }

    @Before("@gr3")
    public void setUp4(){
        System.out.println("Amazonda Selenium Aratıldı");
    }

    @After
    public void tearDown(Scenario scenario){//Bu methoda Scenario class'ından bir parametre ataması yapılır.
        // Bu method'u fail olan scenario'larımızın resmini almak için kullanırız.
        if (scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES),"image/jpeg","screenShot_"+scenario.getName());
        }
        Driver.closeDriver();
    }
}
