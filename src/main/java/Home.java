import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;
public class Home extends CommonMethods{

    SelenideElement homeBtn =$(By.id("menu-item-38"));
    SelenideElement aboutUs=$(By.id("menu-item-158"));
    SelenideElement registration=$(By.id("menu-item-374"));
    SelenideElement dragable=$(By.id("menu-item-140"));
    SelenideElement registrationHeader=$(By.xpath("//h1[text()='Registration']"));
    SelenideElement homeHeader=$(By.xpath("//h1[text()='Home']"));
    SelenideElement contact=$(By.id("menu-item-64"));
    SelenideElement autoComplete=$(By.id("menu-item-145"));
    SelenideElement selected=$(By.id("menu-item-142"));
    SelenideElement frame=$(By.id("menu-item-148"));

    @Step("Open Registration page")
    public Registration clickRegistrationPage(){
    clickElement(registration);
    verifyElementPresent(registrationHeader);
    return Selenide.page(Registration.class);
}
@Step("Verify Home Page")
    public void verifyHomePage(){
    verifyElementPresent(homeHeader);
}
@Step("Click Contact Page")
    public Contact clickContactPage(){
        clickElement(contact);
        verifyElementPresent(contact);
        return Selenide.page(Contact.class);
            }

 @Step("click auto complete")
    public AutoComplete clickAutoCompletePage(){
        clickElement(autoComplete);
        verifyElementPresent(autoComplete);
        return Selenide.page(AutoComplete.class);
    }

 @Step("click selected page")
    public Selected clickSelectedPage(){
        clickElement(selected);
        verifyElementPresent(selected);
        return Selenide.page(Selected.class);
    }

 @Step("Click frame page")
    public Frame clickFramePage(){
        clickElement(frame);
        verifyElementPresent(frame);
        return Selenide.page(Frame.class);
    }
}
