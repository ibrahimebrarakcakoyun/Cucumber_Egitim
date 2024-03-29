package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.AmazonPage;
import techproed.pages.DataTablePage;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class DataTableStepDefinition {
    DataTablePage dataTablePage;
    @Then("kullanici_sayfadaki_tabloda_new_butonuna_basar")
    public void kullanici_sayfadaki_tabloda_new_butonuna_basar() {
        dataTablePage = new DataTablePage();
        dataTablePage.newButton.click();
    }

    @When("cikan_pencerede_verilen_bilgileri_girelim {string},{string},{string},{string},{string},{string},{string}")
    public void cikan_pencerede_verilen_bilgileri_girelim(String firstname, String lastname, String position, String office, String extention, String date, String salary) {
        dataTablePage = new DataTablePage();
        dataTablePage.firstName.sendKeys(firstname, Keys.TAB,lastname, Keys.TAB,position, Keys.TAB,office, Keys.TAB,extention, Keys.TAB,date, Keys.TAB,salary);
    }

    @And("kullanici_create_butonuna_basar")
    public void kullanici_create_butonuna_basar() {
        dataTablePage = new DataTablePage();
        dataTablePage.createButton.click();
    }

    @And("kullanici_search_bolumune_{string}_bilgisi_girer")
    public void kullanici_search_bolumune__bilgisi_girer(String firstname) {
        dataTablePage = new DataTablePage();
        dataTablePage.search.sendKeys(firstname);
    }


    @And("kullanici_{string}ile_basarili_bir_sekilde_giris_yapildigini_dogrular")
    public void kullanici_Ile_basarili_bir_sekilde_giris_yapildigini_dogrular(String firstname) {
        dataTablePage = new DataTablePage();
        Assert.assertTrue(dataTablePage.verify.getText().contains(firstname));
    }


    @And("kullanici_verilen_urunleri_aratir")
    public void kullanici_verilen_urunleri_aratir(DataTable data) {
        AmazonPage amazonPage = new AmazonPage();
        System.out.println(data.asList());
        for (int i=1; i<data.asList().size();i++){
            amazonPage.aramaKutusu.sendKeys(data.asList().get(i),Keys.ENTER);
            ReusableMethods.bekle(2);
            Assert.assertTrue(Driver.getDriver().getTitle().contains(data.asList().get(i)));
            amazonPage.aramaKutusu.clear();
        }
    }
}
