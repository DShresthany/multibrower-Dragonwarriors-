package webMD.StepDef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import webMD.Actions.DepressionQuizActions;
import webMD.Utilities.SetupDrivers;

public class DepressionQuizStepDefinition {
	DepressionQuizActions Quiz = new DepressionQuizActions();

	@Given("I move the mouse over the tab {string}")
	public void i_move_the_mouse_over_the_tab(String string) {
		Quiz.mousehover();

	}

	@Given("I click on link {string}")
	public void i_click_on_link(String string) {
		Quiz.clickDepressionLink();

	}

	@Given("I land on Depression page")
	public void i_land_on_Depression_page() {
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 10);
		wait.until(ExpectedConditions.titleContains("Depression"));
		Assert.assertEquals(Quiz.verifyDepressionPage(), true);

	}

	@Given("I click on menu button")
	public void i_click_on_menu_button() {
		Quiz.clickMenuBtn();

	}

	@Given("I click on Quizzes link")
	public void i_click_on_Quizzes_link() {
		Quiz.clickquizzeslink();

	}

	@Given("I land on Depression Quizzes Page")
	public void i_land_on_Depression_Quizzes_Page() {
		SetupDrivers.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(Quiz.verifyDepressionQuizPage(), true);

	}

	@Given("I click on Myths and Facts About Depression Symptoms link")
	public void i_click_on_Myths_and_Facts_About_Depression_Symptoms_link() {

		Quiz.clickSymptomsLink();
	}

	@Given("I land on the page with first quiz")
	public void i_land_on_the_page_with_first_quiz() {
		Assert.assertEquals(Quiz.verifyQuizPage(), true);

	}

	@Given("I am able to select the answers and complete the quizzes")
	public void i_am_able_to_select_the_answers_and_complete_the_quizzes() throws InterruptedException {
	 for(int i=0; i<=7; i++) {
		List<WebElement> question = SetupDrivers.driver
				.findElements(By.xpath("//li[@class='slide question slide-with-image']"));
		for (WebElement li : question) {
			if (li.isDisplayed()) {
				Quiz.clickAnswer1();
			}

		}
		List<WebElement> answer = SetupDrivers.driver.findElements(By.xpath("//li[@class='slide answer']"));
		for (WebElement li : answer) {
			if (li.isDisplayed()) {
				Quiz.clickNext();

			}
		}
	 }

	}

	@Then("I am able to see the quiz result")
	public void i_am_able_to_see_the_quiz_result() throws InterruptedException {
		Quiz.clickNext();
		Assert.assertEquals(Quiz.verifyQuizResult(), true);

	}
}
