package ru.augorbunov.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RadioComponent {
    public void setValue(String value){
        $("#genterWrapper").$(byText(value)).click();
    }
}
