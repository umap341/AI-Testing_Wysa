package sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.concurrent.TimeUnit;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.time.Duration;

public class Demo {
	public static void main(String args[]) throws IOException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability("platformName", "android");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		driver.startRecordingScreen();

        driver.startRecordingScreen(new AndroidStartScreenRecordingOptions().withVideoSize("1280x720")

                          .withTimeLimit(Duration.ofSeconds(900)));
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Wysa");
		
		el1.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]");
		el2.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement el2a = (MobileElement) driver.findElementByAccessibilityId("Health\nAnxiety");
		el2a.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Breathe Deeply\"]")));		
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Breathe Deeply");
		el3.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement el4 = (MobileElement) driver.findElementById("bot.touchkin:id/messages");
		el4.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Start");
		el5.click();
		
		MobileElement el6 = (MobileElement) driver.findElementById("bot.touchkin:id/complete_container");
		el6.click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Reply or say help…");
		el7.sendKeys("Do you remember why I felt stressed?");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("Send");
		el8.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement el7a = (MobileElement) driver.findElementByAccessibilityId("Let's just talk");
		el7a.click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")));		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		MobileElement el8a = (MobileElement) driver.findElementByAccessibilityId("Reply or say help…");
		el8a.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		el8a.sendKeys("Do you remember why I felt stressed?");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Send");
		el9.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("That's all");
		el10.click();	
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		System.out.println("Finished automation.");
		System.out.println("Taking a screenshot!");
		File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //takes SS of screen
		FileUtils.copyFile(scrFile2, new File("1.3." + "2" + ".jpg"));
		System.out.println("Screenshot taken and saved to folder.");
		String video = driver.stopRecordingScreen();

        byte[] decode = Base64.getDecoder().decode(video);

        FileUtils.writeByteArrayToFile(new File("appiumRecorded3.mp4"), decode);

        driver.quit();
	}
}