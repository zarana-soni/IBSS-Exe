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


    @When("About page is shown")
    public void aboutPageIsShown() {
        String actualText = W.get().driver.findElement(By.xpath("//div[@class='L3eUgb']/div/a")).getText();
        String expectedText = "About";
        Assert.assertEquals(actualText,expectedText);
    }

    @Then("page displays {string}")
    public void pageDisplays(String arg0) {
        W.get().driver.findElement(By.xpath("//div[@class='L3eUgb']/div/a")).click();
        String actualText = W.get().driver.findElement(By.xpath("//div[@id='page-content']/section/div/div[2]/h1")).getText();
        String expectedText = "Our mission is to organise the world’s information and make it universally accessible and useful";
    }

    @When("searching for {string}")
    public void searchingFor(String text) {
        String expectedText= W.get().driver.findElement(By.linkText("About")).getText(); // get text from the "about" link
        String actualText = "About";
        Assert.assertEquals(expectedText,actualText);
        W.get().driver.findElement(By.id("APjFqb")).click();
        W.get().driver.findElement(By.id("APjFqb")).sendKeys(text);
        W.get().driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
    }

    @Then("results contain {string}")
    public void resultsContain(String text) {
        W.get().driver.findElement(By.xpath("//h3[contains(text(), '"+ text + "')]"));
    }

    @And("result stats are displayed")
    public void resultStatsAreDisplayed() {
        WebElement bbcLogo = W.get().driver.findElement(By.id("dimg_13"));

    }

    @And("number of {string} is more than {int}")
    public void numberOfIsMoreThan(String result, int number ) {
        List<WebElement> searchList = W.get().driver.findElements(By.cssSelector(".yuRUbf"));
        for (WebElement search:searchList){
            System.out.println(search.getText());
        }
        int noOfSearch = searchList.size();
        Assert.assertTrue(noOfSearch>number);
    }

}
