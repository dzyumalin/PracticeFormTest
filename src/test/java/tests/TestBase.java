package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @AfterAll
    static void forPractice(){
        System.out.println("Just for pull request");
    }
}
