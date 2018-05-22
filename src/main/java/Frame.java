import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import com.codeborne.selenide.*;


import static com.codeborne.selenide.Selenide.$;

public class Frame extends CommonMethods {

    SelenideElement newtab=$(By.linkText("New Browser Tab"));

    public void verifyNewTabIsOpened(){
        clickElement(newtab);
        switchToNewtab();
       // System.out.println("url is ---- "+WebDriverRunner.url());
        WebDriverRunner.url().equalsIgnoreCase("http://demoqa.com/frames-and-windows/#");

    }


}
