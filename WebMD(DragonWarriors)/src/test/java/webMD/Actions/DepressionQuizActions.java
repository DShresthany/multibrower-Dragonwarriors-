package webMD.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webMD.PageElements.DepressionQuizElements;
import webMD.Utilities.SetupDrivers;

public class DepressionQuizActions {

	DepressionQuizElements QuizElements;

	public DepressionQuizActions() {
		this.QuizElements = new DepressionQuizElements();
		PageFactory.initElements(SetupDrivers.driver, QuizElements);
	}

	public void mousehover() {
		Actions action = new Actions(SetupDrivers.driver);
		action.moveToElement(QuizElements.Healthlink);
	}

	public void clickDepressionLink() {
		QuizElements.Depressionlink.click();
	}

	public boolean verifyDepressionPage() {
		boolean bool = false;
		if (SetupDrivers.driver.getTitle().contains("Depression")) {
			bool = true;
		}
		return bool;
	}

	public void clickMenuBtn() {
		QuizElements.MenuBtn.click();
	}

	public void clickquizzeslink() {
		QuizElements.QuizzesLink.click();
	}

	public boolean verifyDepressionQuizPage() {
		boolean bool = false;
		if (SetupDrivers.driver.getCurrentUrl().contains("https://www.webmd.com/depression/quiz/default.htm")) {
			bool = true;
		}
		return bool;
	}

	public void clickSymptomsLink() {
		QuizElements.articleTitle.click();
	}

	public boolean verifyQuizPage() {
		boolean bool = false;
		if (SetupDrivers.driver.getCurrentUrl().contains("https://www.webmd.com/depression/rm-quiz-depression")) {
			bool = true;
		}
		return bool;
	}

	public void clickAnswer1() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)SetupDrivers.driver;
		jse.executeScript("arguments[0].click()", 	QuizElements.Truelink);
		Thread.sleep(5000);

//		QuizElements.Truelink.click();
	}
//		List<WebElement> question = SetupDrivers.chromeDriver
//				.findElements(By.xpath("//li[@class='slide question slide-with-image']"));
//		for (WebElement li : question) {
//			if (li.isDisplayed()) {
//				li.findElement(By.xpath(
//						"//ul[@id='rmq_slides']/li[@data-slide-type='question' and @style[not(contains(., 'display: none'))]]//ul[@class='radio_inputs']//a[@data-selected-answer='a']"))
//						.click();
//			}
//		}
//
//	}


	public void clickNext() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)SetupDrivers.driver;
		jse.executeScript("arguments[0].click()", 	QuizElements.NextBtn);
		Thread.sleep(5000);

//		QuizElements.NextBtn.click();
//		List<WebElement> answer = SetupDrivers.chromeDriver.findElements(By.xpath("//li[@class='slide answer']"));
//		for (WebElement li : answer) {
//			if (li.isDisplayed()) {
//				li.findElement(By.xpath(
//						"//ul[@id='rmq_slides']/li[@data-slide-type='answer' and @style[contains(., 'display: list-item')]]/div/div[3]/ul/li/a/span"))
//						.click();
//			}
//		}

	}

	public boolean verifyQuizResult() {
		boolean bool = false;
//		if(QuizElements.Quizresult.isDisplayed()) {
//			  bool = true;
//		  }
//		  return bool;

		if (QuizElements.Quizresult.isDisplayed()) {
			bool = true;
		}
		return bool;
	}
}
