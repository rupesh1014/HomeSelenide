import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
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

    @Test
    public void verifyHomePage(){

        openBaseURL()
                .verifyHomePage();

    }
@Test
    public void registerProduct(){
        openBaseURL()
                .clickRegistrationPage()
                .submitRegistrationWithOldId();

}
@Test
    public void verifyPasswordRequiredMessage(){
        openBaseURL()
                .clickRegistrationPage()
                .submitRegistrationWithoutPassword();
}

    @Test
    public void verifyPasswordStrengthBar(){
        openBaseURL()
                .clickRegistrationPage(  )
                .passwordStrengthCheck();
    }
    @Test
    public void verifySendmsgContact(){
        openBaseURL()
                .clickContactPage(  )
                .sendMessageSuccessfully();
    }
    @Test
    public void verifyInvalidSend(){
        openBaseURL()
                .clickContactPage(  )
                .incorrectSending();
    }
    @Test
    public void verifyAutoCompleteFirstSuggestion(){
        openBaseURL()
                .clickAutoCompletePage()
                .autoCompleteFirst();
    }
    @Test
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


