import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;


import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CommonMethods {

    Logger log= LoggerFactory.getLogger(CommonMethods.class);

@Step("Open base URL")
    public Home openBaseURL(){

      Properties pro=new Properties();
      InputStream input= null;
      try {
          input = new FileInputStream("C:\\Users\\Rupesh\\IdeaProjects\\WebUI\\src\\main\\resources\\application.properties");
          pro.load(input);
          Configuration.browser=pro.getProperty("browser");
          open(pro.getProperty("URL"));
          log.info("Opening Base Url");
      }
      catch (Exception e) {
          log.info("problem in opening url");
      }
      return Selenide.page(Home.class);
    }

    public void enterText(SelenideElement element, String text){
        log.info("Entering text in text box");
        element.shouldBe(Condition.visible);
        element.clear();
        element.setValue(text);
        element.sendKeys(Keys.TAB);
       // getWebDriver().switchTo().alert().


    }
    public void clickElement(SelenideElement element){
        log.info("clicking element");
        element.shouldBe(Condition.visible);
        element.click();
    }
    public void verifyElementPresent(SelenideElement element){
        log.info("verifying element is present or not");
        element.shouldBe(Condition.visible);

    }
    public void selectRadioByLabel(String label) {
        log.info("Selecting radio by label");
        $(By.xpath(" //label[contains(text()[normalize-space()], '"+label+"')]//following::input[@type='radio'][1]")).shouldBe(Condition.visible).click();
    }
    public void selectCheckBoxByLabel(String label) {
        log.info("Selecting checkbox by label");
        $(By.xpath(" //label[contains(text()[normalize-space()], '"+label+"')]//following::input[@type='checkbox'][1]")).shouldBe(Condition.visible).click();
    }
    public void selectDropDownByValue(String elementID,String value) {
        log.info("Selecting dropdown by value");
        $(By.xpath("//select[@id='"+elementID+"']//following::option[@value='"+value+"']")).shouldBe(Condition.visible).click();
    }

    public void waitForElementToVisible(SelenideElement element){
        log.info("Waiting for the element to get visible");
        WebDriverWait wait= new WebDriverWait(getWebDriver(),10000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void switchToNewtab(){
          int i=getWebDriver().getWindowHandles().size();
          switchTo().window(i-1);

    }

}


