package webMD.Actions;

import org.openqa.selenium.support.PageFactory;
import webMD.PageElements.LowestDrugPricesElements;
import webMD.Utilities.SetupDrivers;

public class FindLowestDrugPricesActions {
	LowestDrugPricesElements priceElements;
	
	public FindLowestDrugPricesActions() {
		this.priceElements = new LowestDrugPricesElements();
		PageFactory.initElements(SetupDrivers.driver, priceElements);
	}
	
	public void clicklowestDrugLink() {
		priceElements.FindLowestDrugPriceLink.click();
	}
	
	public void clickviewDrugsLink() {
		priceElements.ViewAllDrugsLink.click();
	}

	public void clickDrug() {
		priceElements.LipitorLink.click();
	}
	
	public boolean verifylowestDrug() {
		boolean bool = false;
		if (priceElements.drugsresult.isDisplayed()) {
			bool = true;
		}
		return bool;
		
	}
}
