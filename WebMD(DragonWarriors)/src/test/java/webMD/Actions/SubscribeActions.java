package webMD.Actions;

import org.openqa.selenium.support.PageFactory;

import webMD.PageElements.SubscribeElements;
import webMD.Utilities.SetupDrivers;

public class SubscribeActions {
	SubscribeElements subscribe;
	
	public SubscribeActions(){
		this.subscribe=new SubscribeElements();
		PageFactory.initElements(SetupDrivers.driver, subscribe);
	}
	
	public void clickSubscribeBtn() {
		subscribe.SubscribeBtn.click();
	}
	
	public void enterEmail() {
		subscribe.email.sendKeys("TalenTech@gmail.com");
	}
	
	public void submitSubscribeBtn() {
		subscribe.SubmitSubscribe.click();
	}
	
	public boolean verifySubscribe() {
		boolean bool = false;
		if (subscribe.verifySubscribe.isDisplayed()) {
			bool = true;
		}
		return bool;
	}
}
