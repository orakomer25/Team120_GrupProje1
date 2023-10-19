package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoqaPage {
    public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//div[@id=\"draggable\"]" )
    public WebElement dragMeElementi;


   @FindBy(xpath ="(//*[@id=\"droppable\"])[1]" )
    public WebElement hedefElement;

    @FindBy(xpath ="//*[text()=\"Dropped!\"]")
    public WebElement droppedYaziElement;

}
