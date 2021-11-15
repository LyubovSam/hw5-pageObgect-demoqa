package ru.lyubovsam.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


public class StudentRegistrationForm extends TestBase {
    Faker faker = new Faker();
    String lastName = faker.name().lastName();
    String firstName = faker.name().firstName();
    String number = faker.number().digits(11);
    String currentAddress = faker.address().streetAddress();
    @Test
    void fillForTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeEmail("test@gmail.com")
                        .chooseGender("Female")
                        .typeNumber(number)
                        .typeSubject("Biology")
                        .chooseHobby("Music")
                        .uploadFile("image.jpg")
                        .typeCurrentAddress(currentAddress)
                        .typeState("NCR")
                        .typeCity("Delhi");

        registrationPage.calendar.DataInputComponent("12","March","1994");
        registrationPage.submitClick();


        registrationPage.checkResultValue("Student Name", firstName + lastName)
                        .checkResultValue("Email","test@gmail.com" )
                        .checkResultValue("Gender","Female")
                        .checkResultValue("Mobile",number)
                        .checkResultValue("DateOfBirth","12 March,1994")
                        .checkResultValue("Subjects","Biology")
                        .checkResultValue("Hobbies","Music")
                        .checkResultValue("CurrentAddress",currentAddress)
                        .checkResultValue("StateAndCity","NCR Delhi");



    }
}
