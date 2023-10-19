package tests.soruCozumleri;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class page77_MavenTestiJunitToTestNG {

    String ilkUrunIsmi;

    @Test
    public void saucedemoTesti() {

        SaucedemoPage saucedemoPage = new SaucedemoPage();


        //      1. “https://www.saucedemo.com” Adresine gidin

        Driver.getDriver().get(ConfigReader.getProperty("sdUrl"));


        //      2. Username kutusuna “standard_user” yazdirin
        saucedemoPage.userNameBox.sendKeys("standard_user");


        //        3. Password kutusuna “secret_sauce” yazdirin
        saucedemoPage.passwordBox.sendKeys("secret_sauce");

        //        4. Login tusuna basin
        saucedemoPage.loginButton.click();


        //        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        ilkUrunIsmi = saucedemoPage.ilkUrunElement.getText();

        saucedemoPage.ilkUrunElement.click();

        //        6. Add to Cart butonuna basin
        saucedemoPage.addToCartButton.click();


        //        7. Alisveris sepetine tiklayin
        saucedemoPage.alisverisSepeti.click();


        //        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

       // String actualUrunIsmi = saucedemoPage.sepetUrunElement.getText();

        Assert.assertTrue(saucedemoPage.sepetUrunElement.isDisplayed());


        //        9. Sayfayi kapatin
        Driver.closeDriver();

    }
}

