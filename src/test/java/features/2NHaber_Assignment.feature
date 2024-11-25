Feature: 2NHaber Assignment Test Scenarios


  Scenario: Navbar Kontrolü
    When Linke Gidilir "https://2nhaber.com/"
    Then Navbar Kontrolü


  Scenario: Arama ve Detay Kontrolü
    When Linke Gidilir "https://2nhaber.com/"
    When "//div[@class='elementor-widget-cmsmasters-search__container']" xpathine tıklanır
    When "//input[@class='elementor-widget-cmsmasters-search__field ']" Xpathine "Istanbul" Değeri Doldurulur Ve Search Edilir
    Then 8 Nolu Haberin Kontrolü


  Scenario: Başvuru Kontrolü
    When Linke Gidilir "https://www.2ntech.com.tr/hr"
    When "//input[@id='name']" Xpathine "Dilara Aslı" Değeri Doldurulur
    When "//input[@id='tcKimlik']" Xpathine "11111111111" Değeri Doldurulur
    When "//input[@id='birth']" Xpathine "21.05.1993" Değeri Doldurulur
    When "//input[@id='cv_field']" Xpathine "src/test/java/file/fake.pdf" Dosyası Upload Edilir
    When "//input[@id='phone']" Xpathine "05999999999" Değeri Doldurulur
    When "//input[@id='email']" Xpathine "test@test.com" Değeri Doldurulur
    When "//button[text()='Lisans']" xpathine tıklanır
    When "//button[@type='submit']" xpathine tıklanır
    When "//span[contains(text(),'Test Engineer')]" xpathine tıklanır
    When "//div[contains(text(),'Gönder')]" xpathine tıklanır
    ##Gönder Butonuna tıklandıktan sonra sayfa sadece refresh oluyor bundan dolayı kontrol sağlıyamıyorum

