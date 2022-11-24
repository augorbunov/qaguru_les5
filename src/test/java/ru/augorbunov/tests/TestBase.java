package ru.augorbunov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    String firstName = "Alex",
            lastName = "Surname",
            email = "test@email.com",
            gender = "Other",
            mobile = "1234567890",
            day = "29",
            month = "June",
            year = "1990",
            subjects = "Math",
            hobbies = "Sports",
            picture = "img/1.jpg",
            address = "Address st. 1 apt.123",
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void setUp () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
}
