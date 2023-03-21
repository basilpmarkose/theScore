package functions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Base {
	
	public static AppiumDriver<MobileElement> driver;
	
	public void startApplication() {
		try {
			Repo repo = new Repo("build.properties");
			InitilizeAndOpenAppliction(repo.getValue("ApplicationScore"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void InitilizeAndOpenAppliction(String appLocation) {	
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", "emulator-5554");
			cap.setCapability("deviceOrientation", "portrait");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("app", appLocation);
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,cap);
			System.out.println("Application started...");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public boolean isPresent(List<WebElement> element) {
		return element.size()>0;		
	}
}
