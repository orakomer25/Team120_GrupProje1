package tests.day08_dropdownMenu_iframe;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuAppPage;
import pages.YoutubePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class C03_JSAlerts  {

    @Test
    public void test01(){
        // youtube anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));


        // cookies kabul edin
       // YoutubePage youtubePage = new YoutubePage();
       // youtubePage.cokiesElementi.click();
        Driver.closeDriver();
    }



    @Test
    public void jsAlertTesti(){
        //2. Test
        //	-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokujsUrl"));

        //	- 1.alert'e tiklayin
        HerokuAppPage herokuAppPage = new HerokuAppPage();
        herokuAppPage.jsAlertElementi.click();


        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualYazi,expectedYazi);


        //	-  OK tusuna basip alert'i kapatin
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }



    @Test
    public void cancelTesti(){
        //3.Test
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokujsUrl"));
        //	- 2.alert'e tiklayalim
        HerokuAppPage herokuAppPage = new HerokuAppPage();
        herokuAppPage.jsConfirmElementi.click();
        //	- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        Driver.getDriver().switchTo().alert().dismiss();
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi= herokuAppPage.sonucYaziElementi.getText();
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }


    @Test
    public void promptTesti(){
        //4.Test
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokujsUrl"));
        //	- 3.alert'e tiklayalim
        HerokuAppPage herokuAppPage = new HerokuAppPage();
        herokuAppPage.jsPromptElementi.click();


        //	- Cikan prompt ekranina "Abdullah" yazdiralim
        Driver.getDriver().switchTo().alert().sendKeys("Abdullah");

        //	- OK tusuna basarak alert'i kapatalim
       Driver.getDriver().switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualSonucYazisi=herokuAppPage.sonucYaziElementi.getText();
        String expectedIcerik = "Abdullah";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        Driver.closeDriver();



    }
}
