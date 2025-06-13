package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import pages.LoginPage;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSteps extends PageObject {

    @Steps
    private LoginPage loginPage;

    @Given("I am on the OrangeHRM login page")
    public void iAmOnTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        getDriver().manage().window().maximize();
        open();
    }

    @When("I enter valid username and password")
    public void iEnterValidCredentials() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidCredentials() {
        loginPage.enterUsername("InvalidUser");
        loginPage.enterPassword("InvalidPass");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("dashboard"));
    }

    @And("I should see the dashboard")
    public void iShouldSeeTheDashboard() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("dashboard"));
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @And("I should remain on the login page")
    public void iShouldRemainOnTheLoginPage() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("login"));
    }
} 