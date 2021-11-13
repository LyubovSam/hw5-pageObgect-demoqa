package ru.lyubovsam.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.lyubovsam.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String FORM_TITLE = "StudentRegistrationForm";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            resultTable = $(".table-responsive");

    public CalendarComponent calendar = new CalendarComponent();


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

    }

    public RegistrationPage typeFirstName(String value) {

        firstNameInput.setValue("value");
        return this;
    }
    public RegistrationPage typeLastName(String value) {

        lastNameInput.setValue("value");
        return this;
    }
    public RegistrationPage typeEmail(String value) {

        emailInput.setValue("value");
        return this;

    }
    public void typeNumber(String value) {

        numberInput.setValue("value");
    }








        public RegistrationPage checkResultValue(String value){

            resultTable.shouldHave(Condition.attribute(value));
            return this;


        }


    }