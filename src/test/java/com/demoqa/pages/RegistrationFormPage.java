package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;
import com.demoqa.pages.components.AddressComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private final AddressComponent adressComponent = new AddressComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderCheckBox = $("#genterWrapper"),
            userUserNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsContainer").$("[autocapitalize=none]"),
            hobbiesWrapperCheckBox = $("#hobbiesWrapper"),
            uploadPictureButton =  $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state").$("[autocapitalize=none]"),
            cityInput = $("#city").$("[autocapitalize=none]"),
            submitButton = $("#submit");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();

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
        genderCheckBox.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        userUserNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesWrapperCheckBox.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setAddress(String address, String state, String city) {
        adressComponent.setAddress(address, state, city);

        return this;
    }
    public RegistrationFormPage clickSubmitButton() {
        submitButton.click();

        return this;
    }
    public RegistrationFormPage checkVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }

}
