package tests.day08_dropdownMenu_iframe;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class C04_BasicAuthentication{
  @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : admin
        // 	password      : admin
        //
    Driver.getDriver().get(ConfigReader.getProperty("herokuAdminUrl"));

        //4- Basarili sekilde sayfaya girildigini dogrulayin
    String expectedIcerik = "Congratulations";
    HerokuAppPage herokuAppPage = new HerokuAppPage();
    String actualIcerik = herokuAppPage.tebrikYaziElementi.getText();
    Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    ReusableMethods.bekle(3);
    Driver.closeDriver();


    }
}
