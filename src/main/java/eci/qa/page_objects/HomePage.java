package eci.qa.page_objects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage {

	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(accessibility = "Servicios +")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Servicios +\"]")
	private MobileElement btnServicios;

	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/toolbar_my_account_button")
	@iOSXCUITFindBy(accessibility = "Navega a tu cuenta")
	private MobileElement btnMiCuenta;

	@AndroidFindBy(accessibility= "Comprar")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Comprar\"]")
	private MobileElement btnBuy;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"INICIA SESIÓN O REGÍSTRATE\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/home_login_component_button")
	private MobileElement btnLogin;

	public void clickBtnServicios() {
		btnServicios.click();
	}

	public void clickBtnLogin() {

		if (Base.getProperty("SO").equals("ANDROID")) {

			Utilities.scrollToElement("com.elcorteingles.app.pre:id/home_login_component_button");
		}

		btnLogin.click();
	}

	public void clickBtnBuy() {
		btnBuy.click();
	}

	public void clickBtnMiCuenta() {
		btnMiCuenta.click();
	}

	public boolean existBtnServicios() {
		ExpectedConditions.visibilityOf(btnServicios);
		return btnServicios.isDisplayed();
	}

}
