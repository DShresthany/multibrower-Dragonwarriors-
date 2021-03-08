package webMD.StepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import webMD.Actions.FitnessCalorieCounterActions;
import webMD.Utilities.SetupDrivers;

public class fitnessCalorieCounterStepDefinition {
	FitnessCalorieCounterActions CalorieActions = new FitnessCalorieCounterActions();

	@Given("I click on Fitness Calorie Counter")
	public void i_click_on_Fitness_Calorie_Counter() {
		CalorieActions.clickFitnessLink();

	}

	@Given("I land on Fitness & Exercise page")
	public void i_land_on_Fitness_Exercise_page() {
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 10);
		wait.until(ExpectedConditions.titleContains("Calories Burned Calculator"));
		Assert.assertEquals(CalorieActions.verifyFitnessPage(), true);
	}

	@Given("I click {string} from the visible popular exercises")
	public void i_click_from_the_visible_popular_exercises(String string) {
		CalorieActions.enterExercise(string);
	}

	@Given("I click Excersice Type from the Select an Exercise list")
	public void i_click_Excersice_Type_from_the_Select_an_Exercise_list() {
		CalorieActions.clickFirstExercise();
	}

	@Given("I enter {string} in the weight text box")
	public void i_enter_in_the_weight_text_box(String lbs) {
		CalorieActions.enterWeight(lbs);
	}

	@Given("I enter {string} and {string} in the duration text boxes")
	public void i_enter_and_in_the_duration_text_boxes(String hrs, String mins) {
		CalorieActions.enterDuration(hrs, mins);

	}

	@Given("I click Calculate button")
	public void i_click_Calculate_button() {
		CalorieActions.clickCalculcateBtn();

	}

	@Then("I can see the number of calories I burned")
	public void i_can_see_the_number_of_calories_I_burned() {

		Assert.assertEquals(CalorieActions.verifyCaloriesBurned(), true);
	}

}
