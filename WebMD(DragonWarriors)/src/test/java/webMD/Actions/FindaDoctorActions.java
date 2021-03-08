package webMD.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webMD.PageElements.FindaDoctorElements;
import webMD.Utilities.SetupDrivers;

public class FindaDoctorActions {
	// WebDriver chromeDriver;
	FindaDoctorElements doctorElements;

	public FindaDoctorActions( /* WebDriver chromeDriver */ ) {
		this.doctorElements = new FindaDoctorElements( /* chromeDriver */ );
//		SetupDrivers.setupChromeDriver();
		PageFactory.initElements(SetupDrivers.driver, doctorElements);
	}

	public void getwebMDHomepage() {
		SetupDrivers.driver.get("https://www.webmd.com/");
		SetupDrivers.driver.manage().window().maximize();
		SetupDrivers.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	public void cookieClose() {
		doctorElements.cookie.click();
	}

	public void clickFindaDoctor() {
		doctorElements.link.click();
	}

	public boolean verifyFindaDocPage() {
		boolean bool = false;
		WebDriverWait wait = new WebDriverWait(SetupDrivers.driver, 10);
		wait.until(ExpectedConditions.titleContains("Find Doctors Near You"));
		System.out.println(SetupDrivers.driver.getTitle());
		if (SetupDrivers.driver.getTitle().contains("Find Doctors Near You")) {
			bool = true;
		}
		return bool;
	}

	public void enterdoctorinfo(String string) {

		doctorElements.firstSearchBar.sendKeys(string);
	}

	public void enterTabBtn() {
		doctorElements.firstSearchBar.sendKeys(Keys.TAB);
	}

	public void enterzip(String zip) {
		doctorElements.secondSearchBar.sendKeys(zip);
		;

	}

	public void enterBtn() {
		doctorElements.firstSearchBar.sendKeys(Keys.ENTER);
	}

	public boolean verifyWebMDHomepage() {
		boolean bool = false;
		if (SetupDrivers.driver.getTitle().contains("WebMD")) {
			bool = true;
		}
		return bool;
	}

	public boolean verifyFindaDoctorResult() {
		boolean bool = false;
		if (doctorElements.searchResult.isDisplayed()) {
			bool = true;
		}
		return bool;
	}

	public boolean verifyErrorMsg() {
		boolean bool = false;
		if (doctorElements.errorMsg.isDisplayed()) {
			bool = true;
		}
		return bool;
	}
}
