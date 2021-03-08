package webMD.Actions;

import org.openqa.selenium.support.PageFactory;
import webMD.PageElements.SignInElements;
import webMD.Utilities.SetupDrivers;

public class SigninActions {
	SignInElements signin; 
	
	public SigninActions() {
		this.signin = new SignInElements();
		PageFactory.initElements(SetupDrivers.driver, signin);
	}
	
	
	public void clicksignin() {
	signin.SignInLink.click();
	}
	
	public void enterUserEmali() {
		signin.Username.sendKeys("warroirsdragon@gmail.com");
	}
	
	public void enterPassword() {
		signin.Password.sendKeys("Talentech123456");
	}
	
	public void clickSigninBtn() {
		signin.SigninBtn.click();
	}
	
	public boolean verifySignIn() {
		boolean bool = false;
		if (signin.ConformationSignin.isDisplayed()) {
			bool = true;
		}
		return bool;
	}
}
