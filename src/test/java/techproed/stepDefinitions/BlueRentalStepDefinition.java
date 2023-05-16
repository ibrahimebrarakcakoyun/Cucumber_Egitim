package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.BlueRentalPage;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.Map;

public class BlueRentalStepDefinition {
    BlueRentalPage blueRentalPage;
    @Then("Verilen_kullanici_ile_login_olur")
    public void verilen_kullanici_ile_login_olur(DataTable data) {
        blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        ReusableMethods.bekle(2);
        blueRentalPage.emailBox.sendKeys(data.row(1).get(0), Keys.TAB,data.row(1).get(1),Keys.ENTER);
        ReusableMethods.bekle(3);
        Assert.assertEquals(blueRentalPage.userDropDown.getText(),"Sam Walker");
        Driver.getDriver().navigate().back(); // logout işlemi yerine navigate().back() metotu ile çözdük
        blueRentalPage.emailBox.sendKeys(data.row(2).get(0), Keys.TAB,data.row(2).get(1),Keys.ENTER);
        ReusableMethods.bekle(3);
        Assert.assertEquals(blueRentalPage.userDropDown.getText(),"Kate Brown");
        ReusableMethods.bekle(6);
        //data.cell(1,0);
    }

    @Then("Verilen_kullanicilar_ile_login_olur")
    public void verilen_kullanicilar_ile_login_olur(DataTable data) {
        blueRentalPage = new BlueRentalPage();
        System.out.println(data.asMaps());// Map'lereden oluşan bir List oluşturur.
        // [{email=sam.walker@bluerentalcars.com, password=c!fas_art}, {email=kate.brown@bluerentalcars.com, password=tad1$Fas}]
        // Feature File'daki oluşturduğumuz tabloyu map olarak listeler.
        // Başlığı key olarak alır. altındaki verileri value olarak alır
        for (Map<String,String> w:data.asMaps()){
            blueRentalPage.loginButton.click();
            blueRentalPage.emailBox.sendKeys(w.get("emailAdress"), Keys.TAB, w.get("password"), Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.logOut.click();
            ReusableMethods.bekle(2);
            blueRentalPage.OK.click();
        }
    }
}
