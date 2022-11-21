package ru.augorbunov.pages;

import com.codeborne.selenide.SelenideElement;
import ru.augorbunov.pages.components.CalendarComponent;
import ru.augorbunov.pages.components.RadioComponent;
import ru.augorbunov.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    //Elements
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RadioComponent radioComponent = new RadioComponent();
    private SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            mobileInput = $("#userNumber"),
                            subjectsInput = $("#subjectsInput"),
                            hobbiesInput = $("#hobbiesWrapper"),
                            pictureInput = $("#uploadPicture"),
                            addressInput = $("#currentAddress"),
                            cityInput = $("#city"),
                            stateInput = $("#state"),
                            stateCityWrapper = $("#stateCity-wrapper");

    private final static String TITLE_TEXT = "Student Registration Form";

    private ResultsModal resultsModal = new ResultsModal();

    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        //check that the page has been loaded
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        //remove useless elements from the page
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        radioComponent.setValue(value);

        return this;
    }

    public RegistrationFormPage setMobile(String value) {
        mobileInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String path) {
        pictureInput.uploadFromClasspath(path);

        return this;
    }
    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setStateCity(String state, String city) {
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    public void submitPage() {
        $("#submit").click();
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }
    public RegistrationFormPage checkValue(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }
}
