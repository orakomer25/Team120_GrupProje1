package tests.day08_dropdownMenu_iframe;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.util.List;

public class C02_dropdownMenu  {
   AmazonPage amazonPage;
   Select select;


    @Test
    public void dropdowntesti(){
        //- Test 1
    // https://www.amazon.com/ sitesine gidin
    Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
    amazonPage = new AmazonPage();
    select = new Select(amazonPage.dropDownElementi);
    List<WebElement> optionsList=select.getOptions();
    int expectedSayi= 28;
    int actualSayi = optionsList.size();
    Assert.assertEquals(expectedSayi,actualSayi,"45 eleman yoktur");
    Driver.closeDriver();



    }


    @Test
    public void javaAramaTesti(){
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage= new AmazonPage();
        select= new Select(amazonPage.dropDownElementi);
        ReusableMethods.bekle(2);
        select.selectByVisibleText("Books");




       //	2. Arama kutusuna Java yazin ve aratin
       amazonPage.aramaKutusu.sendKeys("Java"+Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
       System.out.println(amazonPage.sonucYaziElementi.getText());


       //4. Sonucun Java kelimesini icerdigini test edin
       String expectedIcerik = "Java";
       String actualSonucYazisi =amazonPage.sonucYaziElementi.getText();
       Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
       Driver.closeDriver();



    }
}
