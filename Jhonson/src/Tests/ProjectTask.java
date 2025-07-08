package Tests;

import org.testng.annotations.Test;
import Common.Global;
import Common.WebControls;
import Modules.Login;
import Modules.projectView;

import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;

public class ProjectTask {

	@BeforeTest
	public void beforeTest() throws Exception {
		Global.initializeBrowser();
		Login.login();
	}

	@Test
	public void LineupNormalTask() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) Global.driver;
			projectView.project();
			Global.driver.switchTo().window(Global.driver.getWindowHandles().toArray()[1].toString());
			Global.driver.findElement(By.xpath(Global.prop.getProperty("lineTab"))).click();

			Global.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//igx-icon"))).click();

			js.executeScript("window.scrollBy(0,800)", "");
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("LinePhaseDetail")));
			js.executeScript("window.scrollBy(0,100)", "");
			Global.driver.findElement(By.xpath(Global.prop.getProperty("approvalPhase"))).click(); //
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("approvalPhase")));
			js.executeScript("window.scrollBy(0,300)", "");

			Global.driver.findElement(By.xpath(Global.prop.getProperty("assigntoNew"))).click();
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("dDJSAdmin")));
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("bTNViewTask")));

			WebElement XX = Global.driver.findElement(By.xpath(Global.prop.getProperty("statusDD")));

			if (XX != null) {
				XX.click();
				Global.driver.findElement(By.xpath(Global.prop.getProperty("dDInProcess"))).click();
				Global.driver.findElement(By.xpath(Global.prop.getProperty("btnSave"))).click();
				js.executeScript("document.body.style.zoom='80%'");
				Global.driver.findElement(By.xpath(Global.prop.getProperty("close"))).click();
				Global.clickWhenReady(By.xpath(Global.prop.getProperty("bTNViewTask")));
			} else {
				Global.driver.findElement(By.xpath(Global.prop.getProperty("close"))).click();
			}

			Global.driver.findElement(By.xpath(Global.prop.getProperty("updateInproccess"))).click();
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("btnLogHr")));
			Global.driver.findElement(By.xpath(Global.prop.getProperty("hours"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("time"))).click();
			WebControls.Textbox(Global.prop.getProperty("hourComment"), "Automation Test");
			Global.driver.findElement(By.xpath(Global.prop.getProperty("logSubmit"))).click();

			WebControls.Textbox(Global.prop.getProperty("description"), "Test123");
			Global.driver.findElement(By.xpath(Global.prop.getProperty("desSave"))).click();

			Global.driver.findElement(By.xpath(Global.prop.getProperty("comments"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("statusHistory"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("documentHistory"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("changeHistory"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("workLog"))).click();

			Global.driver.findElement(By.xpath(Global.prop.getProperty("statusDD"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("dDComplete"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("btnSave"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("btnConfirm"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("close"))).click();
		} catch (Exception e) {
			System.out.println("❌ Exception in LineupNormalTask: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void LineupReviewTask() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) Global.driver;
			projectView.project();
			Global.driver.switchTo().window(Global.driver.getWindowHandles().toArray()[1].toString());
			Global.driver.findElement(By.xpath(Global.prop.getProperty("lineTab"))).click();

			Global.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//igx-icon"))).click();

			js.executeScript("window.scrollBy(0,800)", "");
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("LinePhaseDetail")));
			js.executeScript("window.scrollBy(0,100)", "");
			Global.driver.findElement(By.xpath(Global.prop.getProperty("approvalPhase"))).click();
			js.executeScript("window.scrollBy(0,300)", "");

			String status = Global.driver.findElement(By.xpath(Global.prop.getProperty("statusRtask"))).getText();
			System.out.println(status);

			if (status.equals("New")) {
				Global.driver.findElement(By.xpath(Global.prop.getProperty("assignRTask"))).click();
				Global.clickWhenReady(By.xpath(Global.prop.getProperty("dDJSAdmin")));
				Global.clickWhenReady(By.xpath(Global.prop.getProperty("btnRTask")));
				Global.clickWhenReady(By.xpath(Global.prop.getProperty("statusDD")));
				Global.driver.findElement(By.xpath(Global.prop.getProperty("dDInProcess"))).click();
				Global.clickWhenReady(By.xpath(Global.prop.getProperty("btnSave")));
				Global.driver.findElement(By.xpath(Global.prop.getProperty("close"))).click();
			}

			Global.driver.findElement(By.xpath(Global.prop.getProperty("btnRTask"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("rAssignTo"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("rJSAdmin"))).click();

			WebElement fileInput = Global.driver.findElement(By.xpath(Global.prop.getProperty("fileUpload")));
			File file = new File(".//Docs//doc1.pdf"); // or use the full path directly
			String absolutePath = file.getAbsolutePath();
			((JavascriptExecutor) Global.driver).executeScript("arguments[0].style.display='block';", fileInput);
			fileInput.sendKeys(absolutePath);

			WebControls.Textbox(Global.prop.getProperty("description"), "Test123");
			Global.driver.findElement(By.xpath(Global.prop.getProperty("desSave"))).click();
			// Global.driver.findElement(By.xpath(Global.prop.getProperty("description"))).sendKeys("Test123");

			Global.clickWhenReady(By.xpath(Global.prop.getProperty("statusDD")));
			Global.driver.findElement(By.xpath(Global.prop.getProperty("dDSTER"))).click();
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("btnSave")));
			js.executeScript("document.body.style.zoom='80%'");
			Global.driver.findElement(By.xpath(Global.prop.getProperty("close"))).click();

			Global.driver.findElement(By.xpath(Global.prop.getProperty("btnER"))).click();
			Global.clickWhenReady(By.xpath(Global.prop.getProperty("statusDD")));
			Global.driver.findElement(By.xpath(Global.prop.getProperty("rAssignTo"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("rJSAdmin"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("dDASFR"))).click();

			Global.driver.findElement(By.xpath(Global.prop.getProperty("dDPurchasing"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("ddRJSadmin"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("dDQuality"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("ddRJSadmin"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("dDME"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("ddRJSadmin"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("btnSubmit"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("btnSave"))).click();
			Global.driver.findElement(By.xpath(Global.prop.getProperty("btnSubmit"))).click();
			js.executeScript("document.body.style.zoom='80%'");
			Global.driver.findElement(By.xpath(Global.prop.getProperty("close"))).click();
		} catch (Exception e) {
			System.out.println("❌ Exception in LineupNormalTask: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@AfterTest
	public void afterTest() {
	}

}
