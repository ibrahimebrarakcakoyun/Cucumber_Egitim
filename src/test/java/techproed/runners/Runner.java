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
@CucumberOptions(features = "src/test/resources/features/day30_IlkFeature",
                    glue = {"techproed/stepDefinitions"}, // Bu parametre ile kodlarımızı yazdığımız stepDefinitin
                                                        // class'ının package'ını belirtiriz
                    tags = "@gr1")

//features ===> features'ların olduğu dosyanın yolunu ver(ContentRoot)
//        glue ====> stepDefinition'ların olduğu dosyanın yolunu ver(Source Root)
//        tags ====> çalıştırmak istediğin grubu yaz


public class Runner {
}
