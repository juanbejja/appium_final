package eci.qa.page_objects.profile;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DireccionesPage {

	public DireccionesPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/address_title")
	@iOSXCUITFindBy(accessibility = "No tienes ninguna dirección guardada")
	private MobileElement titleSinDireccion;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/address_message")
	@iOSXCUITFindBy(accessibility = "Puedes añadir tantas direcciones como quieras: tu casa, el trabajo…")
	private MobileElement lblSinDireccion;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/address_add_button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"AÑADIR DIRECCIÓN\"])[1]")
	private MobileElement btnAnadirDireccion;

	public void checkSinDireccion() {
		ExpectedConditions.visibilityOf(titleSinDireccion);
		ExpectedConditions.visibilityOf(btnAnadirDireccion);
		ExpectedConditions.visibilityOf(lblSinDireccion);
	}
	
	public void clickBtnAddAddress() {
		btnAnadirDireccion.click();
	}

}
