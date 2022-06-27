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

public class ParkingPage {
	public ParkingPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mis vehículos. \"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/parking_go_to_my_vehicles")
	public MobileElement btnMyCars;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Accede a la información\"]")
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Accede a la información\"]")
	public MobileElement btnAyudaContextual;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ENTENDIDO\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/done_button")
	public MobileElement btnAyudaOk;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cerrar pantalla actual\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/close_button")
	public MobileElement btnAyudaClose;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Añade los vehículos que quieras y una forma de pago\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Añade los vehículos que quieras y una forma de pago\"]")
	public MobileElement btnSwipeLeft1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Acércate a nuestro parking y se levantará la barrera sin pulsar ningún botón\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Acércate a nuestro parking y se levantará la barrera sin pulsar ningún botón\"]")
	public MobileElement btnSwipeLeft2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Lista de centros disponibles. \"]")
	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'id/parking_go_to_malls')]")
	public MobileElement btnMallsList;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cerrar pantalla actual\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/close_button")
	public MobileElement btnCloseModal;

	
	public void clickBtnMyCars() {
		btnMyCars.click();
	}
	
	public void clickBtnAyudaContextual() {
		btnAyudaContextual.click();	
	}
	
	public void clickBtnAyudaOk() {
		btnAyudaOk.click();
	}
	
	public void clickBtnAyudaClose () {
		btnAyudaClose.click();
	}
	
	public void clickMallsList() {
		btnMallsList.click();
	}
	
	public void clickSwipeLeft() {
		btnSwipeLeft1.click();
		btnSwipeLeft2.click();
	}
	
	public void swipeLeft() {
		if(Base.getProperty("SO").equals("ANDROID")) {
			Utilities.swipeScreenAndroid(Direction.LEFT);
		}else {
			Utilities.swipeInElementIOS(btnSwipeLeft1, Direction.LEFT);
			Utilities.swipeInElementIOS(btnSwipeLeft2, Direction.LEFT);
		}
	}
	
	public void clickBtnCloseModal() {
		btnCloseModal.click();
	}

}
	
	
	