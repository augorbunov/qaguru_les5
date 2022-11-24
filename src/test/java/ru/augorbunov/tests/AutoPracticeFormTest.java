package ru.augorbunov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.augorbunov.pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormTest extends TestBase {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        @Test
        void fillFormTest () {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setMobile(mobile)
                    .setBirthDate(day, month, year)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .uploadPicture(picture)
                    .setAddress(address)
                    .setStateCity(state, city).submitPage();


            //check filled values
            registrationFormPage.checkResultsTableVisible()
                    .checkValue("Student Name", firstName + " " + lastName)
                    .checkValue("Student Email", email)
                    .checkValue("Gender", gender)
                    .checkValue("Mobile", mobile)
                    .checkValue("Date of Birth", day + " " + month + "," + year)
                    .checkValue("Subjects", subjects)
                    .checkValue("Hobbies", hobbies)
                    .checkValue("Picture", picture)
                    .checkValue("Address",address)
                    .checkValue("State and City", state + " " + city);

        }

        @Test
        void fillFormTestMinimal () {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setMobile(mobile)
                    .submitPage();


            //check filled values
            registrationFormPage.checkResultsTableVisible()
                    .checkValue("Student Name", firstName + " " + lastName)
                    .checkValue("Gender", gender)
                    .checkValue("Mobile", mobile);

        }


}
