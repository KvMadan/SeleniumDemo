/**
 * 
 */
package com.kvm.sel;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Madan Kavarthapu
 *
 */
public class Browser {
	private static String driverPath = "C:\\Dev\\Selenium\\";
	
	public static RemoteWebDriver getDriver(String browser)
			throws MalformedURLException {
		return new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
				getBrowserCapabilities(browser));
	}

	private static MutableCapabilities getBrowserCapabilities(String browserType) {
		switch (browserType) {
		case "firefox":
			System.out.println("Using Firefox Driver");
			return new FirefoxOptions();
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", driverPath	+ "chromedriver.exe");
			System.out.println("Using Chrome Driver");
			return new ChromeOptions();

		case "IE":
			System.out.println("Using IE Driver");
			System.setProperty("webdriver.ie.driver", driverPath
					+ "IEDriverServer.exe");
			return DesiredCapabilities.internetExplorer();
			
		case "Edge":
			System.out.println("Using Edge Driver");
			System.setProperty("webdriver.edge.driver", driverPath
					+ "MicrosoftWebDriver.exe");
			return new EdgeOptions();
			
		default: 
			System.out.println("" + browserType + " Unknown Browser Type, using chrome Driver.");
			//System.setProperty("webdriver.chrome.driver", driverPath	+ "chromedriver.exe");
			return DesiredCapabilities.chrome();
		}
	}
}
