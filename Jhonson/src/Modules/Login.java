package Modules;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import Common.Global;

public class Login {
	public static void login() throws IOException{

	    Global.LoadProperty(".\\Properties\\Login.properties");
	    Global.driver.get(Global.prop.getProperty("baseUrl"));
	    JavascriptExecutor js = (JavascriptExecutor) Global.driver;
	    js.executeScript("document.body.style.zoom='80%'");
  }
}
