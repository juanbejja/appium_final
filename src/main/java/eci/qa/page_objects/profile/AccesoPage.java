package eci.qa.page_objects.profile;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccesoPage {

	public AccesoPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/access_data_username_title")
	@iOSXCUITFindBy(accessibility = "Cuenta de acceso")
	private MobileElement titleCuentaAcceso;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/access_data_username_advice")
	@iOSXCUITFindBy(accessibility = "Si la modificas recibirás un correo electrónico para validar que tu nueva dirección es correcta.")
	private MobileElement lblCuentaAcceso;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/access_data_username_edit_button")
	@iOSXCUITFindBy(accessibility = "CAMBIAR CUENTA DE ACCESO")
	private MobileElement btnCambiarCuenta;

	@AndroidFindBy(id = "om.elcorteingles.app.pre:id/access_data_password_title")
	@iOSXCUITFindBy(accessibility = "Contraseña")
	private MobileElement titleContrasena;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/access_data_password_advice")
	@iOSXCUITFindBy(accessibility = "Al modificar tu contraseña te pediremos que valides la actual.")
	private MobileElement lblContrasena;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/access_data_password_edit_button")
	@iOSXCUITFindBy(accessibility = "SOLICITAR CAMBIO DE CONTRASEÑA")
	private MobileElement btnSolCambioContraena;

	public void checkAccesoPage() {
		titleCuentaAcceso.isDisplayed();
		lblCuentaAcceso.isDisplayed();
		btnCambiarCuenta.isDisplayed();
		titleContrasena.isDisplayed();
		lblContrasena.isDisplayed();
		btnSolCambioContraena.isDisplayed();
	}

	public void clickBtnCambiarCuentacceso() {
		btnCambiarCuenta.click();
	}

	public void clickBtnSolCambioContraena() {
		btnSolCambioContraena.click();
	}
}
