package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {

    String firstName = "Dmitry",
            lastName = "Rejman",
            userEmail = "bgdt@gmail.com",
            userNumber = "9527776556",
            userGender = "Male",
            userSubjects = "Computer Science",
            userHobbies = "Sports",
            monthOfBirth = "July",
            yearOfBirth = "1995",
            dayOfBirth = "005",
            dayWeekOfBirth = "Wednesday",
            currentAdress = "Unter den Linden",
            state = "NCR",
            city = "Gurgaon",
            picture = "qa.jpg";

    @Test
    void successfulPracticeForm() {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        // input Name
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);

        // input Email
        $("#userEmail").val(userEmail);

        // select Gender
        $("#genterWrapper").$(byText(userGender)).click();

        // input Mobile
        $("#userNumber").val(userNumber);

        // select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();

        // input Subjects
        $("#subjectsInput").val(userSubjects).pressEnter();

        // select Hobbies
        $("#hobbiesWrapper").$(byText(userHobbies)).click();

        // select Picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + picture));

        // input Current Address
        $("#currentAddress").val(currentAdress);

        // select state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        // check Table
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(userEmail));
        $x("//td[text()='Gender']").parent().shouldHave(text(userGender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("05" + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(userSubjects));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(userHobbies));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAdress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

    }
}
