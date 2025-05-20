package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global {
	public static WebDriver driver = null;
	public static WebDriverWait wait;
	public static FileInputStream fi;
	public static Properties prop;

	public static void initializeBrowser() {

		String OS = System.getProperty("os.name").toUpperCase();
		System.out.println("Current Operating System: " + OS);

		if (OS.contains("WINDOWS")) {

			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		}

		else if (OS.contains("UBUNTU") || OS.contains("LINUX")) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,30);

		//wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	}

	public static void LoadProperty(String FPath) throws IOException {

		prop = null;
		File objFile = new File(FPath);
		fi = new FileInputStream(objFile);
		prop = new Properties();
		prop.load(fi);

	}

	public static void waitForLoaderToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Wait for loader to appear
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));

		// Wait for it to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
	}

	public static void clickWhenReady(By locator) {
		// clickable method for loader
		WebDriverWait wait = new WebDriverWait(driver, 20);
		waitForLoaderToDisappear(); // Ensure page is stable
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
}
