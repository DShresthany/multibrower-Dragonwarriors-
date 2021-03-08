package webMD.Actions;

import org.openqa.selenium.support.PageFactory;

import webMD.PageElements.CoronaVirusUpdateElements;
import webMD.Utilities.SetupDrivers;

public class CoronaVirusUpdateActions {

	CoronaVirusUpdateElements VirusUpdateElements;
	String State;

	public CoronaVirusUpdateActions() {
		this.VirusUpdateElements = new CoronaVirusUpdateElements();
		PageFactory.initElements(SetupDrivers.driver, VirusUpdateElements);
	}

	public void clickCoronaUpdateLink() {
		VirusUpdateElements.CoronavirusLink.click();
	}

	public boolean verifyVirusUpdatePage() {
		boolean bool = false;
		if (VirusUpdateElements.CoronaVirusUpdateVerify.isDisplayed()) {
			bool = true;
		}
		return bool;
	}

	public String clickState(String State) {
		if (State == "Wyoming") {
			System.out.println(VirusUpdateElements.Wyoming.getText());
			VirusUpdateElements.Wyoming.click();
		} else if (State == "Kansas") {
			System.out.println(VirusUpdateElements.Kansas.getText());
			VirusUpdateElements.Kansas.click();
		}
		return State;
	}

	public boolean verifyupdateResult() {
		boolean bool = false;
	
		if(VirusUpdateElements.Kansas.isDisplayed() ||  VirusUpdateElements.Wyoming.isDisplayed()) {
			bool = true;
		}
		
		return bool;
		
	}
	
//	public boolean verifyupdateResult(String State) {
//		boolean bool = false;
//		if (State == "Wyoming") {
//			if (VirusUpdateElements.ResultWyoming.isDisplayed()) {
//				bool = true;
//			}
//		}
//		if (State == "kansas") {
//			if (VirusUpdateElements.ResultKansas.isDisplayed()) {
//				bool = true;
//			}
//		}
//
//		return bool;
//	}

}
