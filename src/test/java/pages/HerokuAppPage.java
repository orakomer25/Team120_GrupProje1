package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HerokuAppPage {
    public HerokuAppPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "hot-spot")
    public WebElement ciziliAlanElementi;
   @FindBy (xpath = "//*[text()=\"Elemental Selenium\"]" )
    public WebElement elementalSeleniumLink;

  @FindBy (tagName = "h1")
    public WebElement makeSureCodeLandsYaziElementi;

}
