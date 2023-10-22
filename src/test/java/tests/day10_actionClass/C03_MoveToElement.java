package tests.day10_actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ConfigurationGroupMethods;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_MoveToElement extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Elementin Üzerine Hareket Testi","kullanıcı fareyi elemetin üzerince getirince menu acılır");
        //1- https://www.amazon.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazona gider");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        AmazonPage amazonPage=new AmazonPage();
        WebElement accountLists= amazonPage.accountListElementi;
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(accountLists).perform();
        extentTest.info("Fareyi elementin üstüne hareket ettirir.");
        //3- “Create a list” butonuna basin
        WebElement creatAList= amazonPage.creatAList;
        actions.click(creatAList).perform();
        extentTest.info("Elemente click yapar");
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualyourLists= amazonPage.yourListElementi.getText();
        String expectedYazi="Your Lists";
        Assert.assertEquals(expectedYazi,actualyourLists);
        extentTest.pass("Your Lists yazısını test eder.");

    }
}
