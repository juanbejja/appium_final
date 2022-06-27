package eci.qa.page_objects.login;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage {

	public LoginPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(accessibility = "Correo electrónico")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,\"login_input_username\")]")
	private MobileElement inputEmail;

	@iOSXCUITFindBy(accessibility = "Contraseña")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,\"login_input_password\")]")
	private MobileElement inputContrasena;

	@iOSXCUITFindBy(accessibility = "INICIAR SESIÓN")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,\"login_submit_button\")]")
	private MobileElement btnIniciarSesion;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lo sentimos, algunos de los datos no son correctos.\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/dialog_message_text")
	private MobileElement lblLoginFail;

	@iOSXCUITFindBy(accessibility = "¿HAS OLVIDADO TU CONTRASEÑA?")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/login_recover_password")
	private MobileElement btnRecuperarContrasena;

	@iOSXCUITFindBy(accessibility = "Si quieres tener acceso a tu perfil, inicia sesión o crea una cuenta.")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/login_title")
	private MobileElement lblLoginPerfil;

	public void clickBtnRecuperarContrasena() {
		btnRecuperarContrasena.click();
	}

	public String getlblPerfil() {
		return lblLoginPerfil.getText();
	}

	public void sendDataInputEmail(String email) {
		inputEmail.sendKeys(email);
	}

	public void sendDataInputContrasena(String contrasena) {
		inputContrasena.sendKeys(contrasena);
	}

	public void clickBtnIniciarSesion() {
		btnIniciarSesion.click();
	}

	public String getTextLoginFail() {
		return lblLoginFail.getText();
	}

	public void checkLoginPage() {
		inputEmail.isDisplayed();
		inputContrasena.isDisplayed();
		btnIniciarSesion.isDisplayed();
	}
}
