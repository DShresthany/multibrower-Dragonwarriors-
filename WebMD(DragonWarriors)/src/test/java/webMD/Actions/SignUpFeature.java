package webMD.Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webMD.PageElements.SignUpElements;
import webMD.Utilities.SetupDrivers;

public class SignUpFeature {
	
	SignUpElements SignUp;
	
	public SignUpFeature() {
		this.SignUp = new SignUpElements();
		PageFactory.initElements(SetupDrivers.driver, SignUp);
	}
	
	public void clickSignInLink() {
		SignUp.SignInLink.click();
	}
	
	public void clickSignUnLink() {
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(SignUp.SignUpLink));
		SignUp.SignUpLink.click();
	}
	
	public void enterEmailPassword() {
		SignUp.Username.sendKeys("metald_666@gmail.com");
		SignUp.Password.sendKeys("morgoth666");
		SignUp.Password.sendKeys(Keys.TAB);
		SignUp.DOB.sendKeys("12202003");
		SignUp.Password.sendKeys(Keys.TAB);

	}
	
	public void clickSignUpBtn() {
		SignUp.ConformationSignUn.click();

	}


	public boolean verfifySignUp() {
		boolean bool=false;
		if(SignUp.signinText.isDisplayed()) {
			bool=true;
		}
		return bool;
	}
}
