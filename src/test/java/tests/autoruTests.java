package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class autoruTests {
//эксперименты с разделом "мото" сайта auto.ru

        @Test
        void motoTest() {
            open("http://moto.auto.ru/");

            $(By.className("GeoSelect__title-shrinker")).click();
            $(By.className("GeoSelectPopupRegion__clear")).click(); // очищаем регион по умолчанию
            $(Selectors.byText("Сохранить")).click();
            $(By.className("ListingPopularMMM-module__expandLink")).click();//быдем искать Harley в популярных марках
            $(Selectors.byText("Harley-Davidson")).click();

            $("html").shouldHave(Condition.text("Dyna"));//проверяем, что в выдаче есть хоть одна Dyna

        }

        @Test
        void motoSelectTest() {
            open("http://moto.auto.ru/");

            $(Selectors.byText("Марка")).click();//будем выбирать марку из выпадающего списка (учусь использовать hover)
            $(Selectors.byText("Марка")).hover();
            $(Selectors.byText("Harley-Davidson")).click();
            $(".ButtonWithLoader__content").click();

            $$(".ListingItem-module__container").shouldHaveSize(37);//проверяем, что в выдаче на первой странице 37 предложений

    }

}
