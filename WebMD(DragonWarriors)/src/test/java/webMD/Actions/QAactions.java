package webMD.Actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webMD.PageElements.QAElements;
import webMD.Utilities.SetupDrivers;

public class QAactions {
	QAElements QA;
	
	public QAactions() {
		this.QA=new QAElements();
		PageFactory.initElements(SetupDrivers.driver, QA);
	}
	public void moveMouseOver() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(SetupDrivers.chromeDriver, 5);
//	wait.until(ExpectedConditions.elementToBeClickable(QA.Health));
	Thread.sleep(5000);
	Actions action = new Actions(SetupDrivers.driver);
	action.moveToElement(QA.Health).perform();
		
	}
	
	public void clickQALink() {
		QA.QAlink.click();
	}
	
	public boolean verifyQAPage() {
		boolean bool = true;
		if(SetupDrivers.driver.getTitle().contains("Questions & Answers")) {
			bool = true;
		}
		return bool;
	}
	
	public void clickTopic() {
		QA.Topic.click();
	}
	
	public boolean verifyTopic() {
		boolean bool = true;
		if(SetupDrivers.driver.getTitle().contains("Eating Disorder")) {
			bool = true;
		}
		return bool;
	}
	
	public void clickQuestion() {
		QA.Question.click();
	}
	
	
	public boolean verifyAnswerPage() {
		boolean bool = true;
		if(QA.Answer.isDisplayed()) {
			bool = true;
		}
		return bool;
	}
}
