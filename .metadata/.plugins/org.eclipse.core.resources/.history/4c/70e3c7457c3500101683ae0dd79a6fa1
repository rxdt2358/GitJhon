package Modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Common.Global;
import Common.WebControls;
import io.netty.handler.timeout.TimeoutException;

public class projectView {
	public static void project() throws IOException {

		Global.LoadProperty(".\\Properties\\Login.properties");
		Global.clickWhenReady(By.xpath(".//div[contains(@title,'View Projects')]"));
		WebControls.Textbox(Global.prop.getProperty("SearchPR"), "Auto Test");
		Global.clickWhenReady(By.xpath(Global.prop.getProperty("SearchPRBT"))).click();
		Global.driver.findElement(By.xpath(Global.prop.getProperty("ProjectView"))).click();

	}

}
