package techproed.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*
Runner class; testNGdeki .xml file larda belirttiğimiz class'ları, packageları veya metotları nasıl
çalıştırıyorsak, Cucumber frameworkunde de Runner class'ındaki tags parametresi ile belirttiğimiz
senayoryoyu çalıştırabiliriz.
 */

// Cucumber ile Junit'in entegre olmasını sağlayan test çalıştırıcı notasyonudur.
@RunWith(Cucumber.class)

// Senaryoların nerede ve nasıl çalışacağı, hangi raporu kullanacağıyla alakalı seçenekleri ayarlarız
@CucumberOptions(
                    plugin = {"pretty","html:src/test/resources/features/htmlReport/cucumberHooks.html",
                                        "json:src/test/resources/features/htmlReport/cucumber.json",
                                        "junit:src/test/resources/features/htmlReport/cucumber.xml"}, // plugin ifadesi ile pretty ifadesi kullanılırsa konsolda scenario'lar ile ilgil ibilgi gösterir.

                    features = "src/test/resources/features",

                    glue = {"techproed/stepDefinitions"}, // Bu parametre ile kodlarımızı yazdığımız stepDefinitin
                                                        // class'ının package'ını belirtiriz
                    tags = "@hooks",
                    dryRun = false, // dryRun=false Test e-adımlarını kontrol eder ve Browser'ı çalıştırır.
                                    // dryRun=true test adımlarını sadece kontrol eder.
                                    // default olarak false'tur

                    monochrome = true // pretty ifadesinden sonra monochrome=true kullanırsal senaryo adımlarını
                                        // tek renk olarak siyah gösterir. monochrome=false kullanırsak renkli gösterir.



)

// features ===> features'ların olduğu dosyanın yolunu ver(ContentRoot)
// glue ====> stepDefinition'ların olduğu dosyanın yolunu ver(Source Root)
// tags ====> çalıştırmak istediğin grubu yaz


public class Runner {
}
