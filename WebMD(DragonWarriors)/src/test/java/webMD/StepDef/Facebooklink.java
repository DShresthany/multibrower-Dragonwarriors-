package webMD.StepDef;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import webMD.Actions.FacebookActions;
import webMD.Utilities.SetupDrivers;

public class Facebooklink {
	FacebookActions FbActions = new FacebookActions();
	String parentWindow;
	
	@Given("I click on Facebook Like Page button")
	public void i_click_on_Facebook_Like_Page_button() throws InterruptedException {
		parentWindow = SetupDrivers.driver.getWindowHandle();
		System.out.println("parent Window is:" + parentWindow);
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 15); // Explicit Wait of 15 seconds
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@data-testid='fb:page Facebook Social Plugin']")));
		//SetupDrivers.chromeDriver.switchTo().frame(SetupDrivers.chromeDriver.findElement(By.xpath("//iframe[@data-testid='fb:page Facebook Social Plugin']")));
		//System.out.println(FbElements.likeFacebookLink.getText());
		WebDriverWait wait1 = new WebDriverWait(SetupDrivers.driver, 15); // Explicit Wait of 15 seconds
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='u_0_2']")));
		FbActions.clicklikeFBbtn();
	}

	@Then("I land on new window of WebMD Facebook Page")
	public void i_land_on_new_window_of_WebMD_Facebook_Page() {
		Set<String> whandles = SetupDrivers.driver.getWindowHandles();
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 15); // Explicit Wait of 15 seconds
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println("Num of whandles:" + whandles.size());
		for (String childWindow : whandles) {
			if (!parentWindow.equals(childWindow)) {
				SetupDrivers.driver.switchTo().window(childWindow);
				System.out.println("Child Window Handler: "+ childWindow);
				System.out.println(">> Child Window title: "+SetupDrivers.driver.switchTo().window(childWindow).getTitle());
			}

		}
	}

	@Given("I click on Facebook button")
	public void i_click_on_Facebook_button() {
		FbActions.clickfacebookIcon();
		
	}

	@Then("I land on WebMD Facebook Page")
	public void i_land_on_WebMD_Facebook_Page() {
		Assert.assertEquals(FbActions.verifyFBPage(), true);

	}

	@Given("I click on Twitter icon")
	public void i_click_on_Twitter_icon() {
		FbActions.clickTwitterIcon();

	}

	@Then("I land on WebMD Twitter Page")
	public void i_land_on_WebMD_Twitter_Page() {
		Assert.assertEquals(FbActions.verifyTwitterPage(), true);

	}

	@Given("I click on Pinterest icon")
	public void i_click_on_Pinterest_icon() {
		FbActions.clickPinterestIcon();

	}

	@Then("I land on WebMD Pinterest Page")
	public void i_land_on_WebMD_Pinterest_Page() {
		Assert.assertEquals(FbActions.verifyPinterestPage(), true);

	}

}
