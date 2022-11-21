package ru.augorbunov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.augorbunov.pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormTest {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        @BeforeAll
        static void setUp () {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "1920x1080";
        }

        @Test
        void fillFormTest () {
            registrationFormPage.openPage()
                    .setFirstName("Alex")
                    .setLastName("Surname")
                    .setEmail("test@email.com")
                    .setGender("Other")
                    .setMobile("1234567890")
                    .setBirthDate("29", "June", "1990")
                    .setSubjects("Math")
                    .setHobbies("Sports")
                    .uploadPicture("img/1.jpg")
                    .setAddress("Address st. 1 apt.123")
                    .setStateCity("Haryana", "Karnal").submitPage();


            //check filled values
            registrationFormPage.checkResultsTableVisible()
                    .checkValue("Student Name", "Alex Surname")
                    .checkValue("Student Email", "test@email.com")
                    .checkValue("Gender", "Other")
                    .checkValue("Mobile", "1234567890")
                    .checkValue("Date of Birth", "29 May,1990")
                    .checkValue("Subjects", "Maths")
                    .checkValue("Hobbies", "Sports")
                    .checkValue("Picture", "1.jpg")
                    .checkValue("Address","Address st. 1 apt.123")
                    .checkValue("State and City", "Haryana Karnal");

        }

        @Test
        void fillFormTestMinimal () {
            registrationFormPage.openPage()
                    .setFirstName("Alex")
                    .setLastName("Surname")
                    .setGender("Other")
                    .setMobile("1234567890")
                    .submitPage();


            //check filled values
            registrationFormPage.checkResultsTableVisible()
                    .checkValue("Student Name", "Alex Surname")
                    .checkValue("Gender", "Other")
                    .checkValue("Mobile", "1234567890");

        }


}
