package eci.qa.page_objects.profile;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DatosPersonalesPage {

	public DatosPersonalesPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/personal_data_information_title")
	@iOSXCUITFindBy(accessibility = "Datos personales")
	private MobileElement titleDatosPersonales;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/personal_data_edit_information_button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\" Editar\"])[1]")
	private MobileElement btnEditarDatosPersonales;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/personal_data_cellphone_title")
	@iOSXCUITFindBy(accessibility = "Teléfono móvil")
	private MobileElement titleTelefonoMovil;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/personal_data_edit_cellphone_button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\" Editar\"])[2]")
	private MobileElement btnEditarTelefonoMovil;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/personal_data_landline_title")
	@iOSXCUITFindBy(accessibility = "Teléfono fijo")
	private MobileElement titleTelefonoFijo;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/personal_data_edit_landline_button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\" Editar\"])[3]")
	private MobileElement btnEditarTelefonoFijo;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/personal_data_landline")
	@iOSXCUITFindBy(accessibility = "Sin número añadido")
	private MobileElement lblSinNumero;

	public void checkDatosPage() {
		titleDatosPersonales.isDisplayed();
		btnEditarDatosPersonales.isDisplayed();
		titleTelefonoMovil.isDisplayed();
		btnEditarTelefonoMovil.isDisplayed();
		titleTelefonoFijo.isDisplayed();
		btnEditarTelefonoFijo.isDisplayed();
	}

	public void clickBtnEditarDatosPer() {
		btnEditarDatosPersonales.click();
	}

	public void clickBtnEditarTelefonoMovil() {
		btnEditarTelefonoMovil.click();
	}

	public void clickBtnEditarTelefonoFijo() {
		btnEditarTelefonoFijo.click();
	}

}
