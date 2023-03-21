package functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;

public class LeagueTest extends Base {

	public static void main(String[] args) {
		LeagueTest leagueTest = new LeagueTest();
		leagueTest.VerifyLeagueinScoreApp("NHL","NHL Hockey");

	}

	WebElement get_started() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/layout_get_started"));}

	List<MobileElement> leaugeNames() {
		return driver.findElements(By.xpath("android.widget.LinearLayout"));
	}

	WebElement nextButton() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/btn_next"));}	

	WebElement Btn_disallow() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/btn_disallow"));}

	WebElement Btn_allow() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/btn_allow"));}


	WebElement Btn_Image() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/image_view"));}

	WebElement Btn_League() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/action_leagues"));}

	List<MobileElement> leaugeMatch() {
		return driver.findElements(By.id("com.fivemobile.thescore:id/league_name_text"));
	}

	WebElement view_Title() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/title_text"));}

	WebElement LeaguePage_manage_text() {
		return driver.findElement(By.id("com.fivemobile.thescore:id/edit_text_view"));}

	public void VerifyLeagueinScoreApp(String leaugeName, String leaugeMatch) {
		startApplication();
		get_started().click();
		for(MobileElement leauge : leaugeNames()) {
			if(leauge.getText().equalsIgnoreCase(leaugeName)) {
				leauge.click();
				break;
			}
		}
		nextButton().click();
		Btn_disallow().click();
		nextButton().click();
		Btn_allow().click();
		Btn_League().click();
		for(MobileElement match : leaugeMatch()) {
			if(match.getText().equalsIgnoreCase(leaugeMatch)) {
				match.click();
				break;
			}
		}		
		String title = view_Title().getText();
		Assert.assertEquals(title, leaugeName);
		driver.navigate().back();
		boolean navigation = LeaguePage_manage_text().isDisplayed();
		Assert.assertTrue(navigation, "Successfully Navigated Back");

	}

}
