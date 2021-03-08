package webMD.Actions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webMD.PageElements.FitnessCalorieCounterElements;
import webMD.Utilities.SetupDrivers;

public class FitnessCalorieCounterActions {
	FitnessCalorieCounterElements CalorieElements;

	public FitnessCalorieCounterActions() {
		this.CalorieElements = new FitnessCalorieCounterElements();
		PageFactory.initElements(SetupDrivers.driver, CalorieElements);
	}

	public void getwebMDHomepage() {
		SetupDrivers.driver.get("https://www.webmd.com/");
		SetupDrivers.driver.manage().window().maximize();
		SetupDrivers.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	public void clickFitnessLink() {
		CalorieElements.FitnessCalorielink.click();
	}

	public boolean verifyFitnessPage() {
		boolean bool = false;
		System.out.println(SetupDrivers.driver.getTitle());
		if (SetupDrivers.driver.getTitle().contains("Calories Burned Calculator")) {
			bool = true;
		}
		return bool;
	}

	public void enterExercise(String string) {
		CalorieElements.searchExercise.sendKeys(string);
		CalorieElements.searchExercise.sendKeys(Keys.ENTER);
		CalorieElements.searchExercise.sendKeys(Keys.TAB);

	}

	public void clickFirstExercise() {
//		WebDriverWait wait =new WebDriverWait(SetupDrivers.chromeDriver, 15);
//		wait.until(ExpectedConditions.elementToBeClickable(CalorieElements.ClickFirstExercise));
		JavascriptExecutor jse = (JavascriptExecutor)SetupDrivers.driver;
		jse.executeScript("arguments[0].click()", CalorieElements.ClickFirstExercise);
//		CalorieElements.ClickFirstExercise.click();
	}

	public void clickExcersice() {
		CalorieElements.BicyclingLink.click();
	}

	public void clickExcersice2() {
		CalorieElements.DancingLink.click();
	}

	public void clickExcerciseType() {
		CalorieElements.BMX.click();

	}

	public void clickExcerciseType2() {
		CalorieElements.GenDancing.click();

	}

	public void enterWeight(String lbs) {
		CalorieElements.Weight.sendKeys(lbs);
		CalorieElements.Weight.sendKeys(Keys.TAB);
	}

	public void enterDuration(String hrs, String mins) {
		CalorieElements.Hours.sendKeys(hrs);
		CalorieElements.Minutes.sendKeys(mins);
	}

	public void clickCalculcateBtn() {

		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(CalorieElements.CalculateBtn));
		JavascriptExecutor jse = (JavascriptExecutor)SetupDrivers.driver;
		jse.executeScript("arguments[0].click()", CalorieElements.CalculateBtn);
//		CalorieElements.CalculateBtn.click();
	}

	public boolean verifyCaloriesBurned() {
		boolean bool = false;
		// System.out.println(SetupDrivers.chromeDriver.getTitle());
		if (CalorieElements.CalorieBurned.isDisplayed()) {
			bool = true;
		}
		return bool;
	}
}
