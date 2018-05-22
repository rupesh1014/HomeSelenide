import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Contact extends CommonMethods {
    Logger log= LoggerFactory.getLogger(Contact.class);

    SelenideElement firstName = $(By.name("your-name"));
    SelenideElement email = $(By.name("your-email"));
    SelenideElement subject = $(By.name("your-subject"));
    SelenideElement msg = $(By.name("your-message"));
    SelenideElement send = $(By.xpath("//input[@value='Send']"));
    SelenideElement confirmationMsg = $(By.xpath("//div[contains(@class,'wpcf7-response-output')]"));

    public void sendMessageSuccessfully() {
        log.info("Enter:Send messgae");
        enterText(firstName,"Rupesh");
        enterText(email,"rupesh1014@gmail.com");
        enterText(subject,"This is Test message");
        enterText(msg, "this is test message to enter. Lets see how it works");
        clickElement(send);
        confirmationMsg.shouldHave(Condition.text("Your message was sent successfully. Thanks."));
        log.info("Exit:Sent messgae");
    }
    public void incorrectSending() {
        log.info("Enter:try incorrect Sending");
        enterText(firstName,"Rupesh");
       // enterText(email,"rupesh1014@gmail.com");
        enterText(subject,"This is Test message");
        enterText(msg, "this is test message to enter. Lets see how it works");
        clickElement(send);
        confirmationMsg.shouldHave(Condition.text("Validation errors occurred. Please confirm the fields and submit it again."));
        log.info("Enter:try incorrect Sending");

    }
}