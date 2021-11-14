package ru.lyubovsam.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.lyubovsam.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            fileUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput =  $("#city"),
            clickSubmit = $("#submit"),
            resultTable = $(".table-responsive");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue("Lyubov");
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue("Samarkina");
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue("test@gmail.com");
        return this;

    }
    public RegistrationPage chooseGender(String value) {
        genderRadio.find(byText("Female")).click();
        return this;

    }
    public RegistrationPage typeNumber(String value) {
        numberInput.setValue("1234567890");
        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue("Biology").pressEnter();
        return this;
    }

    public RegistrationPage chooseHobby(String value) {
        hobbyInput.find(byText("Music")).click();
        return this;
    }

    public RegistrationPage uploadFile(String value) {
        fileUpload.uploadFromClasspath("image.jpg");
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        addressInput.setValue("currentAddress");
        return this;
    }

    public RegistrationPage typeState(String value) {
        stateInput.scrollTo().click();
        stateInput.find(byText("NCR")).click();
        return this;
    }
    public RegistrationPage typeCity(String value) {
        cityInput.click();
        cityInput.find(byText("Delhi")).click();
        return this;
    }
    public RegistrationPage submitClick() {
        clickSubmit.click();
        return this;
    }
    public RegistrationPage checkResultValue(String value) {
        resultTable.shouldHave(Condition.attribute(value));
        return this;
    }
}
