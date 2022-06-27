package eci.qa.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import eci.qa.appium.Utilities.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ServicesPage {

	public ServicesPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "com.elcorteingles.app.pre:id/toolbar_title")
	public MobileElement titleToolBar;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Compra manos libres. Compra en la tienda sin bolsas. \"]")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,\"digital_cart_button\")]")
	public MobileElement btnCompraManosLibres;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Parking. Gestiona tu parking y paga sin hacer colas. \"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Parking\"]")
	public MobileElement btnParking;

	
	@AndroidFindBy(id = "appointments_button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Pedir cita. Reserva cita en nuestros servicios. \"]")
	public WebElement btnAskAppointment;

	public void clickBtnCompraManosLibres() {
		btnCompraManosLibres.click();
	}
	
	public void clickBtnParking() {
		if(Base.getProperty("SO").equals("ANDROID")) {
			Utilities.scrollBottomAndroid();
		}else {
			Utilities.swipeInElementIOS(btnCompraManosLibres, Direction.UP);
		}
		
		btnParking.click();
	}

	public void clickBtnAskAppointment() {
		btnAskAppointment.click();
	}

}
