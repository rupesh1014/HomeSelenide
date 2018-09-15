import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.junit.SoftAsserts;
import io.qameta.allure.Step;
import jdk.nashorn.internal.AssertsEnabled;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class Registration  extends CommonMethods {

    SelenideElement registrationHeader = $(By.xpath("//h1[text()='Registration']"));
    SelenideElement firstName = $(By.id("name_3_firstname"));
    SelenideElement lastName = $(By.name("last_name"));
    public String country = "dropdown_7";
    public String month = "mm_date_8";
    public String date = "dd_date_8";
    public String year = "yy_date_8";
    SelenideElement phone = $(By.id("phone_9"));
    SelenideElement userName = $(By.id("username"));
    SelenideElement email = $(By.id("email_1"));
    SelenideElement about = $(By.id("description"));
    SelenideElement photo = $(By.id("profile_pic_10"));
    SelenideElement thankYou = $(By.className("piereg_message"));
    SelenideElement password = $(By.id("password_2"));
    SelenideElement confirmPassword = $(By.id("confirm_password_password_2"));
    SelenideElement submitBtn = $(By.name("pie_submit"));
    SelenideElement assertMsg = $(By.xpath("//*[@id=\"post-49\"]/div/p"));
    SelenideElement noPasswordWarning = $(By.xpath("//span[contains(@class, 'legend ') and contains(@class ,'error')]"));
    SelenideElement miniMumPassword=$(By.xpath("//div[@class='legend_txt']/span"));
    SelenideElement strengthIndiocator=$(By.className("piereg_pass"));
    SelenideElement veryWeakPassword=$(By.className("piereg_pass_v_week"));

    //Thank you for your registration
    @Step("Submit registration with old id")
    public void submitRegistrationWithOldId() {
        enterText(firstName, "Rupesh");
        enterText(lastName, "kumar");
        selectRadioByLabel("Married");
        selectCheckBoxByLabel("Cricket");
        selectDropDownByValue(country, "Chad");
        selectDropDownByValue(month, "3");
        selectDropDownByValue(date, "5");
        selectDropDownByValue(year, "2012");
        enterText(phone, "9550893745");
        enterText(userName, "rupesh76348");
        enterText(email, "rupesh10414@gmail.com");
        enterText(about, "this is for testing purpose");
        enterText(password, "Welcome12#");
        enterText(confirmPassword, "Welcome12#");
      //  photo.sendKeys("C:\\Users\\Rupesh\\Downloads\\image.jpg");
          photo.click();
          try {
              Runtime.getRuntime().exec("C:\\selenium\\FileUpload.exe");
          }
          catch (Exception e){
              e.printStackTrace();
          }


        sleep(5000);
        clickElement(submitBtn);
        verifyElementPresent(assertMsg);
        assertMsg.shouldHave(Condition.text("Error: Username already exists"));
        System.out.println("message is ----" + assertMsg.getText());
        sleep(5000);

    }
@Step("submit Registration Without Password")
    public void submitRegistrationWithoutPassword() {
        enterText(firstName, "Rupesh");
        enterText(lastName, "kumar");
        selectRadioByLabel("Married");
        selectCheckBoxByLabel("Cricket");
        selectDropDownByValue(country, "Chad");
        selectDropDownByValue(month, "3");
        selectDropDownByValue(date, "5");
        selectDropDownByValue(year, "2012");
        enterText(phone, "9550893745");
        enterText(userName, "rupesh76348");
        enterText(email, "rupesh10414@gmail.com");
        enterText(about, "this is for testing purpose");
        clickElement(submitBtn);
        waitForElementToVisible(noPasswordWarning);
        System.out.println(noPasswordWarning.getText());
        noPasswordWarning.shouldNotHave(Condition.text("* This field is required"));



    }

    public void minimumPasswordLength(){
        enterText(firstName, "Rupesh");
        enterText(lastName, "kumar");
        enterText(password,"rupesh");
        miniMumPassword.shouldBe(Condition.visible);
        System.out.println(miniMumPassword.getText());
        miniMumPassword.shouldHave(Condition.text("* Minimum 8 characters required"));
    }
@Step("Password Strength check")
    public void passwordStrengthCheck() {

        enterText(firstName, "Rupesh");
        enterText(lastName, "kumar");
        strengthIndiocator.shouldHave(Condition.text("Strength Indicator"));
        enterText(password,"rupesh");
        veryWeakPassword.shouldHave(Condition.text("Very weak"));


    }
}