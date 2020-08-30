package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class FNSTests {

    @Test
    void FNSGold(){
    // тест проверяет, загрузились ли данные за июнь по экспорту золота
        open("http://stat.customs.ru/"); // главная страница ФНС

        $(Selectors.byText("Анализ данных")).click(); // переход в нужную вкладку
        $("#P2_DIRECTION_2").click(); // экспорт
        $("#P2_CH_PER_3").click(); // месяц
        $("#P2_MONTH_LEFT").selectOption("Июнь 2020 года");
        $("#P2_MONTH_MOVE").click(); // выбор месяца
        $("#P2_CH_STR2_0").click();  // все страны
        $("#P2_TNVED").selectOption("4 знака"); // 4 знака кода ТНВЭД
        $("#P2_CH_TNVED_2").click(); // ввод кода ТНВЭД вручную
        $("#P2_TNVED4_4").setValue("7108"); // код ТНВЭД для золота
        $("#FEDERAL_DISTRICT_0").click(); // все округа
        $("#FEDERAL_SUBJECT_0").click(); // все субъекты
        $("#P2_DOLL_2").click(); // млн долл
        $("#P2_VES_1").click(); // тонны
        sleep(Long.parseLong("20000")); //пауза, чтобы ввести вручную капчу
        $(Selectors.byText("Показать результаты")).click();
        sleep(Long.parseLong("20000")); // пауза, чтобы прогрузился медленный сайт
        
        $("html").shouldHave(Condition.text("Золото"));
            }
}
