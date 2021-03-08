package webMD.StepDef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import webMD.Utilities.SetupDrivers;

public class AfterActions {
	@After
	public void afterScenario(Scenario scen) {
		System.out.println("..Test Ended..");
		try {
			if (scen.isFailed()) {
				String screenshotName = scen.getName().replaceAll(" ", "_");
				TakesScreenshot ts = (TakesScreenshot) SetupDrivers.driver;
				byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
				scen.attach(screenshotBytes, "image/png", screenshotName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		SetupDrivers.closeDriver();
		System.out.println("..Browser Closed..");
	}
}
