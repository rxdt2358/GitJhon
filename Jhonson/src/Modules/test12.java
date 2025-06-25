package Modules;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Global;
import Common.WebControls;

public class test12 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Global.initializeBrowser();
		Login.login();
		
		
		 JavascriptExecutor js = (JavascriptExecutor) Global.driver;
		  projectView.project();
		  Global.driver.switchTo().window(Global.driver.getWindowHandles().toArray()[1].toString());
		  Global.driver.findElement(By.xpath(Global.prop.getProperty("lineTab"))).click();

		 
		  Global.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//igx-icon"))).click();
		  
		  
		  js.executeScript("window.scrollBy(0,800)", "");
		  Global.clickWhenReady(By.xpath(Global.prop.getProperty("LinePhaseDetail")));
		  js.executeScript("window.scrollBy(0,100)", "");
		  Global.driver.findElement(By.xpath(Global.prop.getProperty("approvalPhase"))).click();
		 // Global.clickWhenReady(By.xpath(Global.prop.getProperty("approvalPhase")));
		  js.executeScript("window.scrollBy(0,300)", "");
		
		
		  int taskCount = Global.driver.findElements(By.xpath(Global.prop.getProperty("bTNViewTask"))).size();

		  for (int i = 0; i < taskCount; i++) {
		      try {
		          // Re-fetch elements inside the loop to avoid stale references
		          List<WebElement> assignList = Global.driver.findElements(By.xpath(Global.prop.getProperty("assigntoNew")));
		          List<WebElement> viewTaskList = Global.driver.findElements(By.xpath(Global.prop.getProperty("bTNViewTask")));

		          if (assignList.size() <= i || viewTaskList.size() <= i) {
		              System.out.println("Skipping task " + (i + 1) + " - index out of bounds.");
		              continue;
		          }

		          WebElement assignTo = assignList.get(i);
		          WebElement viewTaskBtn = viewTaskList.get(i);

		          String assignText = assignTo.getText().trim();
		          if (!viewTaskBtn.isEnabled()) {
		              System.out.println("Skipping task " + (i + 1) + " - not 'New' or button disabled.");
		              continue;
		          }

		          // Optional wait to ensure overlay/modals are gone
		          WebDriverWait wait = new WebDriverWait(Global.driver, 10);
		          wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-class-or-overlay"))); // Replace with actual class

		          wait.until(ExpectedConditions.elementToBeClickable(assignTo)).click();
		          Global.clickWhenReady(By.xpath(Global.prop.getProperty("dDJSAdmin")));
		          Global.clickWhenReady(By.xpath(Global.prop.getProperty("bTNViewTask")));

		          WebElement statusDD = Global.driver.findElement(By.xpath(Global.prop.getProperty("statusDD")));
		          if (statusDD != null) {
		              statusDD.click();
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
		          System.out.println("⚠️ Error in task " + (i + 1) + ": " + e.getMessage());
		          // Optional: take screenshot or log more details
		          continue;
		      }
		  }
		}
	}


