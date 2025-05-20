package Common;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class WebControls
{
	public static void Textbox(String Xpath, String value)throws IOException
	{
		WebElement TextBox = Global.driver.findElement(By.xpath(Xpath));
		TextBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		TextBox.click();
		TextBox.sendKeys(value);
	}

	public static void BTDrop(String Xpath) throws IOException
	{
		WebElement drop = Global.driver.findElement(By.xpath(Xpath));
		drop.click();
	}

	public static void radio(String Xpath)throws IOException
	{
		WebElement radio = Global.driver.findElement(By.xpath(Xpath));
		boolean selectState = radio.isSelected();

		if(!selectState) {
			radio.click();
		}
	}

}
