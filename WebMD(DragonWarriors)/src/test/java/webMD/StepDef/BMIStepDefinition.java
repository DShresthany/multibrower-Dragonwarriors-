package webMD.StepDef;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import webMD.Actions.BMIActions;
import webMD.Utilities.SetupDrivers;

public class BMIStepDefinition {

	BMIActions Actions2 = new BMIActions();

	@Given("I click on the BMI Calcular link")
	public void i_click_on_the_BMI_Calcular_link() {
		Actions2.clickBMICalulator();
		//

	}

	@Given("I land on BMI Calculator Page")
	public void i_land_on_BMI_Calculator_Page() {
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 5);
		wait.until(ExpectedConditions.titleContains("BMI Calculator"));
		boolean Actual = Actions2.verifyBMIPage();
		Assert.assertEquals(Actual, true);

	}

	@Given("I enter {string} in feet text box")
	public void i_enter_in_feet_text_box(String feet) {
		Actions2.enterFeet(feet);

	}

	@Given("I eneter {string} in inches text box")
	public void i_eneter_in_inches_text_box(String inch) {
		Actions2.enterInches(inch);

	}

	@Given("I eneter {string} in pounds text box")
	public void i_eneter_in_pounds_text_box(String pound) {
		Actions2.enterPouds(pound);

	}

	@Given("I click calculate button")
	public void i_click_calculate_button() {
		Actions2.clickSubmitBtn();

	}

	@Then("I am able to see BMI Result")
	public void i_am_able_to_see_BMI_result() {
		boolean Actual = Actions2.verifyBMIResult();
		Assert.assertEquals(Actual, true);

	}

	@Then("I am able to see error message")
	public void i_am_able_to_see_error_message() {
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 10);
		wait.until(ExpectedConditions.titleContains("BMI Calculator"));
		boolean Actual = Actions2.verifyErrorMsg();
		Assert.assertEquals(Actual, true);

	}

}
