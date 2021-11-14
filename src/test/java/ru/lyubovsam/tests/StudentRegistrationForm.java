package ru.lyubovsam.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


public class StudentRegistrationForm extends TestBase {
    Faker faker = new Faker();
    String lastName = faker.name().lastName();
    @Test
    void fillForTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName("Lyubov")
                        .typeLastName(lastName)
                        .typeEmail("test@gmail.com")
                        .chooseGender("Female")
                        .typeNumber("1234567890")
                        .typeSubject("Biology")
                        .chooseHobby("Music")
                        .uploadFile("image.jpg")
                        .typeCurrentAddress("currentAddress")
                        .typeState("NCR")
                        .typeCity("Delhi")
                        .submitClick();

        registrationPage.calendar.setDate("12","March","1994");


        registrationPage.checkResultValue("Lyubov" + lastName)
                        .checkResultValue("test@gmail.com")
                        .checkResultValue("Female")
                        .checkResultValue("1234567890")
                        .checkResultValue("12 March,1994")
                        .checkResultValue("Biology")
                        .checkResultValue("Music")
                        .checkResultValue("currentAddress")
                        .checkResultValue("NCR Delhi");



    }
}
