package webMD.StepDef;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import webMD.Utilities.SetupDrivers;

public class BeforeActions {
	String browserName =System.getProperty("browser");
	
	@Before
	public void beforeScenario(Scenario scen) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		
		System.out.println("..Driver initilization..");
		SetupDrivers.setupChromeDriver();
		System.out.println("..ChromeDriver initialized..");
		System.out.println("scene.getName");
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.out.println("..Driver initilization..");
			SetupDrivers.setupFirefoxDriver();
			System.out.println("..FirefoxDriver initialized..");
			System.out.println("scene.getName");
		}
	}

}
