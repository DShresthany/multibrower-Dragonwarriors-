package webMD.Actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webMD.PageElements.BMICalculatorElements;
import webMD.Utilities.SetupDrivers;

public class BMIActions {
	BMICalculatorElements BMIElements;

	public BMIActions() {
		this.BMIElements = new BMICalculatorElements();
		PageFactory.initElements(SetupDrivers.driver, BMIElements);
	}

	public void clickBMICalulator() {
		BMIElements.BMILink.click();
	}

	public boolean verifyBMIPage() {
		boolean bool = false;
		if (SetupDrivers.driver.getTitle().contains("BMI Calculator")) {
			bool = true;
		}
		return bool;
		//
	}

	public void enterFeet(String feet) {
		BMIElements.feet.sendKeys(feet);
	}

	public void enterInches(String inch) {
		BMIElements.inches.sendKeys(inch);
	}

	public void enterPouds(String pound) {
		BMIElements.weight.sendKeys(pound);
	}

	public void clickSubmitBtn() {
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(BMIElements.submitBtn));
		BMIElements.submitBtn.click();
	}

	public boolean verifyBMIResult() {
		boolean bool = false;
		if (BMIElements.BMIResult.isDisplayed()) {
			bool = true;
		}
		return bool;
	}

	public boolean verifyErrorMsg() {
		boolean bool = false;
		if (BMIElements.BMIError.isDisplayed()) {
			bool = true;
		}
		return bool;
	}
}
