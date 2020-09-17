import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class Selenide {

    @Before
    public void setup(){
        Configuration.browser = "chrome";

    }

    @Test
    public void test(){
        open("http://www.rgs.ru");
        $(By.xpath("//a[@class='hidden-xs' and @data-toggle='dropdown']")).click();
        $(By.xpath("//a[contains(text(), 'ДМС')]")).click();

        $(By.xpath("//div[@class='clearfix']/h1")).shouldHave(exactText("ДМС — добровольное медицинское страхование"));

        $(By.xpath("//a[contains(text(), 'Отправить заявку')]")).click();

        $(By.xpath("//b[contains(text(), 'Заявка на добровольное')]")).shouldHave(exactText("Заявка на добровольное медицинское страхование"));

        $(By.xpath("//input[@name='LastName']")).setValue("Фамилия");
        $(By.xpath("//input[@name='FirstName']")).setValue("Имя");
        $(By.xpath("//input[@name='MiddleName']")).setValue("Отчество");
        $(By.xpath("//select[@name='Region']")).selectOptionByValue("77");
        $(By.xpath("//label[contains(text(), 'Телефон')]/../input")).setValue("1111111111");
        $(By.xpath("//input[@name='Email']")).setValue("qwertyqwerty");
        $(By.xpath("//textarea[@name='Comment']")).setValue("My Comment");
        $(By.xpath("//label[@for='$prev']")).click();

        $(By.xpath("//input[@name='LastName']")).shouldHave(value("Фамилия"));
        $(By.xpath("//input[@name='FirstName']")).shouldHave(value("Имя"));
        $(By.xpath("//input[@name='MiddleName']")).shouldHave(value("Отчество"));
        $(By.xpath("//select[@name='Region']")).shouldHave(value("77"));
        $(By.xpath("//label[contains(text(), 'Телефон')]/../input")).shouldHave(value("+7 (111) 111-11-11"));
        $(By.xpath("//input[@name='Email']")).shouldHave(value("qwertyqwerty"));
        $(By.xpath("//textarea[@name='Comment']")).shouldHave(value("My Comment"));
        $(By.id("button-m")).click();

        $(By.xpath("//span[contains(text(), 'почты')]")).shouldHave(exactText("Введите адрес электронной почты"));


    }
}
