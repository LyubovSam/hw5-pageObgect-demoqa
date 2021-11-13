package ru.lyubovsam.tests;

import org.junit.jupiter.api.Test;

import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm extends TestBase {
    @Test
    void fillForTest(){
        registrationPage.openPage();

        registrationPage.typeFirstName("Lyubov")
                        .typeLastName("Samarkina")
                        .typeEmail("test@gmail.com")
                        .typeNumber("1234567890");
        $(byText("Female")).click();
        registrationPage.calendar.setDate("12","March","1994");
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/image.jpg"));
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").setValue("currentAddress");
        $("#state").scrollTo().click();
        $("#state").find(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.checkResultValue("Thanks for submitting the form")
                        .checkResultValue("Lyubov Samarkina")
                        .checkResultValue ("test@gmail.com")
                        .checkResultValue("Female")
                        .checkResultValue("1234567890")
                        .checkResultValue("12 March,1994")
                        .checkResultValue("Biology")
                        .checkResultValue("Music")
                        .checkResultValue("currentAddress")
                        .checkResultValue("NCR Delhi");



    }
}
