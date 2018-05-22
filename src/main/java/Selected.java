import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Selected extends CommonMethods {

    Logger log = LoggerFactory.getLogger(AutoComplete.class);
    public SelenideElement firstItemSelected=$(By.xpath("//li[contains(@class,'selected')]"));
    public SelenideElement firstElement=$(By.xpath("//*[@id=\"selectable\"]/li[1]"));


    public void checkFirstItemSelected(){
        firstItemSelected.shouldNot(Condition.visible);
        log.info("first Item is not selected");
        clickElement(firstElement);
        verifyElementPresent(firstItemSelected);
        log.info("first Item is not selected");
        sleep(5000);
    }
}
