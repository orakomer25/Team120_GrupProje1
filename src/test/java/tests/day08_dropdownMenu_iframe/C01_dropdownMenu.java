package tests.day08_dropdownMenu_iframe;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HerokuAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.util.List;

public class C01_dropdownMenu  {
    @Test
    public void dropdownTesti(){
//        ● Bir class oluşturun: DropDown
//● https://the-internet.herokuapp.com/dropdown adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("herokuDDUrl"));
//        1. Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        HerokuAppPage herokuAppPage = new HerokuAppPage();
        Select select = new Select(herokuAppPage.dropDownElementi);
        herokuAppPage.dropDownElementi.click();
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);
//        2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);
//        3. Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        ReusableMethods.bekle(2);
//        4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionsList= select.getOptions();
        for (WebElement each:optionsList
             ) {
            System.out.println(each.getText());
        }

//        5. Dropdown’un boyutunun 4 olduğunu test edin
       int expectedBoyut= 4;
       int actualBoyut = optionsList.size();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualBoyut,expectedBoyut,"Dropdown menu boyutu 4 değildir.");

        Driver.closeDriver();

    }

}
