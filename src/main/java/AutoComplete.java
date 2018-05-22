import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AutoComplete {

    Logger log = LoggerFactory.getLogger(AutoComplete.class);
    SelenideElement tag = $(By.id("tagss"));


    public void autoCompleteFirst() {
        log.info("enter auto complete");
        tag.sendKeys("a");
        sleep(2000);
        tag.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER));
        sleep(5000);
    }
}