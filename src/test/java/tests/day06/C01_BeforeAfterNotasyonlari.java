package tests.day06;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_BeforeAfterNotasyonlari {
    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin



    @Test
    public void test1(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //AmazonPage amazonPage = new AmazonPage();

        String expectedIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }
    @Test
    public void test2(){
        Driver.getDriver().get(ConfigReader.getProperty("wqUrl"));

        String expectedTitleIcerik = "Wise";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        Driver.closeDriver();


    }
    @Test
    public void test3(){
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));

        String unExpectedTitle = "best";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertNotEquals(unExpectedTitle,actualTitle);
        Driver.closeDriver();

    }
}
