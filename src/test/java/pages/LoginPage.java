package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "txtUsername")
    private WebElementFacade usernameField;

    @FindBy(id = "txtPassword")
    private WebElementFacade passwordField;

    @FindBy(id = "btnLogin")
    private WebElementFacade loginButton;

    @FindBy(id = "spanMessage")
    private WebElementFacade errorMessage;

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
} 