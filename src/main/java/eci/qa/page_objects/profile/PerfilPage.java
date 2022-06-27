package eci.qa.page_objects.profile;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PerfilPage {

	public PerfilPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/more_identifier_qr_image")
	@iOSXCUITFindBy(accessibility = "Código QR para identificar el usuario")
	private MobileElement iconQR;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/more_identifier_qr_help")
	@iOSXCUITFindBy(accessibility = "¿Cómo usar mi identificador?")
	private MobileElement lblQR;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/profile_access")
	@iOSXCUITFindBy(accessibility = "Acceso. ")
	private MobileElement btnAcceso;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/profile_personal_data")
	@iOSXCUITFindBy(accessibility = "Datos personales. ")
	private MobileElement btnDatosPersonales;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/profile_directions")
	@iOSXCUITFindBy(accessibility = "Direcciones. ")
	private MobileElement btnDirecciones;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/profile_unsubscribe")
	@iOSXCUITFindBy(accessibility = "Cancelar cuenta. ")
	private MobileElement btnCancelarCuenta;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/dialog_title_text")
	@iOSXCUITFindBy(accessibility = "Mi identificador")
	private MobileElement titleInformation;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/title_text")
	@iOSXCUITFindBy(accessibility = "Un QR para identificarte")
	private MobileElement lblInformationQR;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/subtitle_text")
	@iOSXCUITFindBy(accessibility = "Este es el código que deberás mostrar en tienda para acceder a los servicios que soliciten tu identificación.")
	private MobileElement lblInformationCode;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/title_text")
	@iOSXCUITFindBy(accessibility = "Guarda tus tiques de compras")
	private MobileElement titleSaveHashInfo;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/subtitle_text")
	@iOSXCUITFindBy(accessibility = "Si todavía no tienes guardada ninguna tarjeta para pago QR en tienda, enseñando este QR al pagar en caja, se guardará tu tique en la sección Compras.")
	private MobileElement lblSaveHashInfo;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/done_button")
	@iOSXCUITFindBy(accessibility = "ENTENDIDO")
	private MobileElement btnOKInfo;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.elcorteingles.app.pre:id/more_identifier_qr_help\"]//android.widget.ImageView")
	private MobileElement iconInformation;

	public void checkPerfilPage() {
		iconQR.isDisplayed();
		lblQR.isDisplayed();
		btnAcceso.isDisplayed();
		btnDatosPersonales.isDisplayed();
		btnDirecciones.isDisplayed();
		btnCancelarCuenta.isDisplayed();
	}

	public void checkModalInformation() throws Exception {
		titleInformation.isDisplayed();
		lblInformationQR.isDisplayed();
		lblInformationCode.isDisplayed();
		
		if (Base.getProperty("SO").equals("iOS")) {
			Utilities.mobileSwipeElementIOS(lblInformationCode);
		} else {
			Utilities.swipeElementAndroid(lblInformationCode);
		}
		
		titleSaveHashInfo.isDisplayed();
		lblSaveHashInfo.isDisplayed();
		btnOKInfo.isDisplayed();
	}

	public void clickBtnAcceso() {
		btnAcceso.click();
	}

	public void clickBtnDatosPersonales() {
		btnDatosPersonales.click();
	}

	public void clickBtnDirecciones() {
		btnDirecciones.click();
	}

	public void clickBtnCancelarCuenta() {
		btnCancelarCuenta.click();
	}

	public void clickBtnInformation() {
		lblQR.isDisplayed();
		if (Base.getProperty("SO").equals("iOS")) {
			Utilities.clickByCoordinates(300, 275);
		} else {
			iconInformation.click();
		}
	}
}
