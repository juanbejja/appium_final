package eci.qa.page_objects.parking;

import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import eci.qa.appium.Utilities.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MallsListPage {
	public MallsListPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable")
	public MobileElement btnScrollMyListPage;
	
	public void clickScrollUp() {
		if(Base.getProperty("SO").equals("ANDROID")) {
			Utilities.scrollBottomAndroid();
		}else {
			Utilities.swipeInElementIOS(btnScrollMyListPage, Direction.UP);
		}
	}
}
