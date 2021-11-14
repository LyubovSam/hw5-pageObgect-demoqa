package ru.lyubovsam.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CalendarComponent {
    private SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");
    private ElementsCollection dayt = $$(".react-datepicker__day");


    public void DataInputComponent(String day, String month, String year) {
        dateOfBirthInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayt.find(Condition.text(day)).click();
    }

}
