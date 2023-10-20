package tests.day10_actionClass;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class C01_sagClick_testi extends TestBaseRapor {


    @Test
    public void test01() {
         extentTest=extentReports.createTest("Alert Testi","Sağ click yapar ve Çıkan alert üzerindeki yazı test edilir ");
        HerokuAppPage herokuAppPage=new HerokuAppPage();
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
       Driver.getDriver().get(ConfigReader.getProperty("herokuAppContextUrl"));
       extentTest.info("herokuapp.com a gider");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(Driver.getDriver());
        actions.contextClick(herokuAppPage.ciziliAlanElementi).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        ReusableMethods.bekle(5);
        String expectedAlertYazi="You selected a context menu";
        String actualAlertYazi=Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);
        extentTest.pass("Alert üzerindeki yazıyı test eder");
        //5- Tamam diyerek alert’i kapatalim
        Driver.getDriver().switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHD=Driver.getDriver().getWindowHandle();
       herokuAppPage.elementalSeleniumLink.click();
       extentTest.info("Elemental Selenium linkine tıklar");
        ReusableMethods.bekle(5);
        String ikinciSayfaWHD="";
        Set<String> whd=Driver.getDriver().getWindowHandles();
        for (String each:whd
        ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;
            }

        }

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);

        String expectedYazi="Make sure your code lands";
        String actualYazi=herokuAppPage.makeSureCodeLandsYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        extentTest.pass("Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test eder");

        //Sayfalari  kapat(quit)
        Driver.quitDriver();
        extentTest.info("Sayfaları Kapatır quit ile kapatır.");
    }
}
