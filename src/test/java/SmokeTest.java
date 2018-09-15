import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.*;
import sun.security.tools.KeyStoreUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.PublicKey;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class SmokeTest extends CommonMethods{

    @BeforeTest
    public void openDemoQA(){
        //openBaseURL();
    }

    @Test(description = "verifyHomePage")
    public void verifyHomePage(){

        openBaseURL()
                .verifyHomePage();

    }
@Test(description = "registerProduct")
    public void registerProduct(){
        openBaseURL()
                .clickRegistrationPage()
                .submitRegistrationWithOldId();

}
@Test(description = " this is verifyPasswordRequiredMessage")
@Severity(SeverityLevel.BLOCKER)
    public void verifyPasswordRequiredMessage(){
        openBaseURL()
                .clickRegistrationPage()
                .submitRegistrationWithoutPassword();
}

    @Test(description = " this is verifyPasswordStrengthBar")
    public void verifyPasswordStrengthBar(){
        openBaseURL()
                .clickRegistrationPage(  )
                .passwordStrengthCheck();
    }
    @Test(description = "verifySendmsgContact")
    @Severity(SeverityLevel.MINOR)
    public void verifySendmsgContact(){
        openBaseURL()
                .clickContactPage(  )
                .sendMessageSuccessfully();
    }
    @Test(description = "verifyInvalidSend")
    public void verifyInvalidSend(){
        openBaseURL()
                .clickContactPage(  )
                .incorrectSending();
    }
    @Test(description = "verifyAutoCompleteFirstSuggestion")
    public void verifyAutoCompleteFirstSuggestion(){
        openBaseURL()
                .clickAutoCompletePage()
                .autoCompleteFirst();
    }
    @Test(description = "verifyFirstItemIsSelected")
    public void verifyFirstItemIsSelected(){
        openBaseURL()
                .clickSelectedPage()
                .checkFirstItemSelected();
    }
    @Test
    public void verifyNewWindowIsOpened(){
        openBaseURL()
                .clickFramePage()
                .verifyNewTabIsOpened();
    }

    }


