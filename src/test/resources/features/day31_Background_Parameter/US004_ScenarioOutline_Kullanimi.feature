Feature: Google_Search

  Background: Kullanici_Google_Anasayfasina_Gider
    Given kullanici_"google_Url"_sayfasina_gider

    #Scenario Outline: TestNG'deki @DataProvider mantığı ile çalışır.
    #Birden fazla veriyi tek seferde feature file'dan kullanmamıza yardımce olur

  Scenario Outline: Google_Aramalari
    * kullanici googleda "<aranacakKelime>" aratir
    * basligin "<aranacakKelime>" icerdigini dogrular
    * sayfayi_kapatir
    Examples:
      | aranacakKelime |
      | volvo          |
      | bmw            |
      | mercedes       |
      | audi           |
      | ford           |








