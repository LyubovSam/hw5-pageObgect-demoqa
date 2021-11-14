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
                        .typeCity("Delhi");

        registrationPage.calendar.DataInputComponent("12","March","1994");
        registrationPage.submitClick();


        registrationPage.checkResultValue("Student Name", "Lyubov" + lastName)
                        .checkResultValue("Email","test@gmail.com" )
                        .checkResultValue("Gender","Female")
                        .checkResultValue("Mobile","1234567890")
                        .checkResultValue("DateOfBirth","12 March,1994")
                        .checkResultValue("Subjects","Biology")
                        .checkResultValue("Hobbies","Music")
                        .checkResultValue("CurrentAddress","currentAddress")
                        .checkResultValue("StateAndCity","NCR Delhi");



    }
}
