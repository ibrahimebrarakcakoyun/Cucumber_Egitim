Feature: US001_Amazon_Sayfasinda_Urun_Aratma

  #Classlarımızda kullandığımız @Before gibi burada kullandığımız her scenario'dan önce Background yapısı çalışır
  Background: Kullanici_Amazon_Sayfasina_Gider
    Given kullanici_amazon_sayfasina_gider

    #Feature file'da birden fazla ürün aratmak için her ürün için yeni method oluşturmak gerekir.
    #Dolayısıyla stepdefinitinda class'ında çok fazla method oluşturmuş oluruz.
    #Tek bir parameterel imethod oluşturup üstesinden gelebiliriz.
    #Bunun için feature file'da aratmak istediğim metni " " tırnek içinde yazarsak stepdefinition class'ında bize
    #parametreli method oluşturur. Böylece bu methodu kullanarak istediğimiz kadar metin aratabiliriz.

  Scenario: TC01_Amazon_Sayfasinda_Selenium_Aratma
    Then arama_kutusunda_"Selenium"_aratir
    And kullanici 3 saniye bekler

  Scenario: TC02_Amazon_Sayfasinda_github_Aratma
    Then arama_kutusunda_"github"_aratir
    And kullanici 3 saniye bekler

  Scenario: TC03_Amazon_Sayfasinda_samsung_Aratma
    Then arama_kutusunda_"samsung"_aratir
    And kullanici 3 saniye bekler

  Scenario: TC04_Amazon_Sayfasinda_nokia_Aratma
    Then arama_kutusunda_"nokia"_aratir
    And kullanici 3 saniye bekler
    And sayfayi_kapatir



