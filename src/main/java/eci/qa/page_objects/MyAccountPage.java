package eci.qa.page_objects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MyAccountPage {

	public MyAccountPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/my_account_logout")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cerrar sesión. \"]")
	public MobileElement btnCloseSession;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/dialog_message_text")
	@iOSXCUITFindBy(accessibility = "¿Quieres cerrar sesión?")
	public MobileElement msgCloseSession;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/dialog_top_button")
	@iOSXCUITFindBy(accessibility = "ACEPTAR")
	public MobileElement btnAcceptClose;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/dialog_bottom_button")
	@iOSXCUITFindBy(accessibility = "CANCELAR")
	public MobileElement btnCancelClose;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/my_account_profile")
	@iOSXCUITFindBy(accessibility = "Perfil. ")
	public MobileElement btnPerfil;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'id/my_account_digital_wallet')]")
	@iOSXCUITFindBy(accessibility = "Cartera Digital. ")
	public MobileElement btnCarteraDigital;

	public void clickBtnPerfil() {
		btnPerfil.click();
	}

	public void clickBtnCarteraDigital() {
		btnCarteraDigital.click();
	}

	public void clickBtnCloseSession() {
		btnCloseSession.click();
	}

	public void checkMyAccountPage() {
		btnCloseSession.isDisplayed();
		btnPerfil.isDisplayed();
	}

	public void checkPopCloseSession() {
		msgCloseSession.isDisplayed();
		btnAcceptClose.isDisplayed();
		btnCancelClose.isDisplayed();
	}

	public void clickBtnAcceptClose() {
		btnAcceptClose.click();
	}
}
