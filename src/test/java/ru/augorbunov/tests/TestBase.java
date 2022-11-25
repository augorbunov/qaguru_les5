package ru.augorbunov.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.concurrent.ThreadLocalRandom;

public class TestBase {
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Other",
            mobile = faker.phoneNumber().subscriberNumber(10),
            day = "" + ThreadLocalRandom.current().nextInt(1, 28),
            month = "June",
            year = "" + ThreadLocalRandom.current().nextInt(1950, 2022),
            subjects = "Math",
            hobbies = "Sports",
            picturePath = "img/1.jpg",
            picture = "1.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void setUp () {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
}
