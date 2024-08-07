package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GoogleSteps {

    @Given("url {string} is launched")
    public void url(String url) {
        W.get().driver.get(url);
        acceptCookiesIfWarned();
    }

    private static void acceptCookiesIfWarned() {
        try {
            W.get().driver.findElement(By.cssSelector("#L2AGLb")).click();
        } catch (NoSuchElementException ignored) {
        }
    }


}
