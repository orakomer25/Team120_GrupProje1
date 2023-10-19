package tests.day10_actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_DragAndDrop extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Sürükle ve Bırak Testi","Kullanici demoqa'da istenen elementi sürükleyip bırakabilmeli");
        //1- https://demoqa.com/droppable adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("demoqaUrl"));
        extentTest.info("demoqa.com gider");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        DemoqaPage demoqaPage=new DemoqaPage();
        WebElement dragMeElementi=demoqaPage.dragMeElementi;
        WebElement hedefElement=demoqaPage.hedefElement;
       Actions actions=new Actions(Driver.getDriver());
       actions.dragAndDrop(dragMeElementi,hedefElement).perform();
       extentTest.info("istenen elementi sürükleyip bırakır");
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi=ConfigReader.getProperty("demoqa_droppedYazi");
        String actualYazi=demoqaPage.droppedYaziElement.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        extentTest.pass("dropped yazısının var oldugunu test eder");

    }
}
