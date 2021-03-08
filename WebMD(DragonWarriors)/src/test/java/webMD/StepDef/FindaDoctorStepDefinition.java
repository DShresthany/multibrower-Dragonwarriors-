package webMD.StepDef;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webMD.Actions.FindaDoctorActions;
import webMD.Utilities.SetupDrivers;

public class FindaDoctorStepDefinition {
	FindaDoctorActions Action1 = new FindaDoctorActions();

	@Given("I land on the WebMD homepage")
	public void i_land_on_the_WebMD_homepage() {
		Action1.getwebMDHomepage();
		Action1.cookieClose();
		Assert.assertEquals(Action1.verifyWebMDHomepage(), true);
	}

	@When("I click on the Find a Doctor Link")
	public void i_click_on_the_Find_a_Doctor_Link() {
		Action1.clickFindaDoctor();

	}

	@When("I land on Find a Doctor page")
	public void i_land_on_Find_a_Doctor_page() {
		SetupDrivers.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(Action1.verifyFindaDocPage(), true);
	}

	@When("I enter {string} in the first search bar")
	public void i_enter_in_the_first_search_bar(String string) {
		Action1.enterdoctorinfo(string);

	}

	@When("I press Tab button in the keyboard")
	public void i_press_Tab_button_in_the_keyboard() {
		Action1.enterTabBtn();

	}

	@When("I enter {string} in the second search bar")
	public void i_enter_in_the_second_search_bar(String zip) {
		Action1.enterzip(zip);

	}

	@When("I press Enter button in the keyboard")
	public void i_press_Enter_button_in_the_keyboard() {
		Action1.enterBtn();

	}

	@Then("I am able to see the list of doctors.")
	public void i_am_able_to_see_the_list_of_doctors() {
		Assert.assertEquals(Action1.verifyFindaDoctorResult(), true);

	}

	@Then("I am able to see error message.")
	public void i_am_able_to_see_error_message() {
		Assert.assertEquals(Action1.verifyErrorMsg(), true);

	}
}
