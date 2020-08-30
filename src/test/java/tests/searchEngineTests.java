package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.*;

public class searchEngineTests {
    // один из моих первых тестов - учусь нажимать кнопки в поисковиках

    @Test
    void yahooTest (){
        //простой поиск

        open("https://yahoo.com");

        $(byName("p")).setValue("Струков").pressEnter();//находим поисковую строку по имени, вводим текст, наживаем Enter

        $("html").shouldHave(Condition.text("Константин Иванович"));//проверяем, что в выдаче есть информация о нужном человеке
    }

    @Test
    void googleTest(){
        //поиск с переходом по ссылке

        open("https://google.com");

        $(byName("q")).setValue("\"носочки с лисичками\"").pressEnter();// на этот раз ищем по точному совпадению, кавычки "экранируем"
        $(byPartialLinkText("fox_n_socks")).click();//переходим по нужной ссылке

        $("html").shouldHave(Condition.text("Ларина"));//проверяем, что попали в группу Лариной

    }

    @Test
    void yaTest() {
        //поиск и переходом по ссылке, которая открывается в новом окне

        open("https://ya.ru");

        $("#text").setValue("носочки с лисичками").pressEnter();//на этот раз находим поисковую строку по id
        $(byPartialLinkText("fox_n_socks")).click();
        switchTo().window(1);//переходим в новую вкладку

        $("html").shouldHave(Condition.text("Ларина"));

    }

}