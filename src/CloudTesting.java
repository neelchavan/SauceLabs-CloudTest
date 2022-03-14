import java.net.*;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class CloudTesting {
	
	static public WebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.setCapability("platformName", "Windows 7");
		options.setCapability("browserVersion", "79");

		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "oauth-neelchavan9-7d850");
		sauceOptions.put("accessKey", "4bdaef19-eae9-4b9f-a4ae-b533a439fab2");

		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com/wd/hub");

		driver = new RemoteWebDriver(url, options);

		driver.get("https://www.saucedemo.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		driver.quit();
	}

}
