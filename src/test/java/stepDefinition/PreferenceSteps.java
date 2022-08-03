package stepDefinition;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Base;	

public class PreferenceSteps extends Base {
	AndroidDriver<AndroidElement>driver;
	Properties p;

	@Given("user launches demo application")
	public void user_launches_demo_application() throws IOException {
		driver= capabilities();
		
		p=new Properties();
		FileInputStream fs = new FileInputStream("./Locators/locatorsrepo.properties");
		p.load(fs);	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@When("user clicks on Preference btn, Preference Dependencies btn should  appear")
	public void user_clicks_on_preference_btn_preference_dependencies_btn_should_appear() {
		driver.findElementByXPath(p.getProperty("preferenceXpath")).click();
	}
	@When("user clicks on Preference Dependencies btn, wifi check box should appear")
	public void user_clicks_on_preference_dependencies_btn_wifi_check_box_should_appear() {
		driver.findElementByXPath(p.getProperty("preferenceDepXpath")).click();
	}
	@When("user clicks on wifi check box, WifiSettings btn should appear")
	public void user_clicks_on_wifi_check_box_wifi_settings_btn_should_appear() {
		driver.findElementById(p.getProperty("wifiChkId")).click();
	}
	@When("user clicks on WifiSettings btn, WifiSettings edit box should appear")
	public void user_clicks_on_wifi_settings_btn_wifi_settings_edit_box_should_appear() {
		driver.findElementByXPath(p.getProperty("wifiSettingXpath")).click();
	}
	@When("user enters wifi name and  clicks on ok btn")
	public void user_enters_wifi_name_and_clicks_on_ok_btn() {
		driver.findElementById(p.getProperty("editBoxId")).sendKeys("WIFITEST");  
	}
	@Then("Wifi edit box should close")
	public void wifi_edit_box_should_close() {
		driver.findElementByXPath(p.getProperty("okBtnXpath")).click(); 
	}


	@When("user clicks on Views btn, Date Widgets btn should  appear")
	public void user_clicks_on_views_btn_date_widgets_btn_should_appear() {
		driver.findElementByAndroidUIAutomator(p.getProperty("viewsAndroidUi")).click();
	}
	@When("user clicks on Date Widgets btn, Inline btn should  appear")
	public void user_clicks_on_date_widgets_btn_inline_btn_should_appear() {
		driver.findElementByAndroidUIAutomator(p.getProperty("dateWidgetAndroidUi")).click();
	}
	@When("^user clicks on Inline btn, time icon should  appear$")
	public void user_clicks_on_inline_btn_time_icon_should_appear()  {
		driver.findElementByAndroidUIAutomator(p.getProperty("inlineAndroidUi")).click();
	}
	@Then("user should be able to change the time")
	public void user_should_be_able_to_change_the_time() {
		driver.findElementByXPath(p.getProperty("clockXpath")).click();

		TouchAction<?> t = new TouchAction<>(driver);
		WebElement li=driver.findElementByXPath(p.getProperty("srcXpath"));
		WebElement li2=driver.findElementByXPath(p.getProperty("desXpath"));
		t.longPress(longPressOptions().withElement(element(li)).withDuration(ofSeconds(2))).moveTo(element(li2)).release().perform();

	}

}
