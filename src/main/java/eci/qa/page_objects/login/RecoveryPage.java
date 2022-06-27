package eci.qa.page_objects.login;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RecoveryPage {

	public RecoveryPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(accessibility = "Introduce el email que usaste al registrarte y te enviaremos un mensaje para crear una nueva contraseña.")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/recovery_title")
	private MobileElement recoveryTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Por favor, revisa el correo electrónico (ej. nombre@gmail.com).\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/textinput_error")
	private MobileElement lblFormatFail;

	@iOSXCUITFindBy(accessibility = "Correo electrónico")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/login_input_username")
	private MobileElement inputEmail;

	@iOSXCUITFindBy(accessibility = "ENVIAR EMAIL")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/button")
	private MobileElement btnSendEmail;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/login_user_icon")
	private MobileElement iconEmailSend;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Hemos enviado un e-mail a')]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/email_sent_title")
	private MobileElement emailSentTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Si existe una cuenta')]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/email_sent_text")
	private MobileElement emailSentText;

	@iOSXCUITFindBy(accessibility = "INICIAR SESIÓN")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/return_to_login_button")
	private MobileElement btnReturnToLogin;

	@iOSXCUITFindBy(accessibility = "REENVIAR EMAIL")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/resend_email_button")
	private MobileElement btnResendEmail;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/dialog_message_text")
	@iOSXCUITFindBy(accessibility = "No reconocemos este correo electrónico.")
	private MobileElement emailUnrecognizedMsg;

	public void checkRecoveryPage() {
		recoveryTitle.isDisplayed();
		btnSendEmail.isDisplayed();
	}

	public void checkPageEmailSent() {
		iconEmailSend.isDisplayed();
		emailSentTitle.isDisplayed();
		emailSentText.isDisplayed();
		btnReturnToLogin.isDisplayed();
		btnResendEmail.isDisplayed();
	}

	public String getTextEmailSent() {
		return emailSentTitle.getText();
	}

	public String getEmailUnrecognizedMsg() {
		return emailUnrecognizedMsg.getText();
	}

	public void checkFormatFail() {
		lblFormatFail.isDisplayed();
	}

	public void enterEmail(String email) {
		inputEmail.click();
		inputEmail.sendKeys(email);
	}

	public void clickBtnSendEmail() throws InterruptedException {
		Thread.sleep(4000);
		btnSendEmail.isDisplayed();
		btnSendEmail.click();
	}

}
