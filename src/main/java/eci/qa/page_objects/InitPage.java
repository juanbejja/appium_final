package eci.qa.page_objects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class InitPage {

	public InitPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@resource-id,'id/onboarding_skip')]")
	private MobileElement btnSkip;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmas que has leído y aceptado la información sobre las cookies.\"]")
	@AndroidFindBy(xpath = "(//android.widget.Button)[2]")
	private MobileElement btnAcceptCookies;

	@iOSXCUITFindBy(accessibility = "PERMITIR NOTIFICACIONES")
	private MobileElement btnPermitirNotificaciones;

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnNoWIFI;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Solicitar a la app no rastrear\"]")
	private MobileElement btnAppNoRastreator;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Salta las pantallas de bienvenida y accede a la aplicación directamente.\"]")
	private MobileElement btnOnboardingJump;

	@iOSXCUITFindBy(accessibility = "Don’t Allow")
	private MobileElement btnDontAllowNoti;

	public void clickBtnAcceptCookies() {
		btnAcceptCookies.click();
	}

	public void clickBtnDontAllowNoti() {
		if (Base.getProperty("SO").equals("iOS")) {
			btnDontAllowNoti.click();
		} else if (Base.getProperty("AMBIENTE").equals("PRO")
				|| Base.getProperty("AMBIENTE").equals("PRE") && Base.getProperty("SO").equals("ANDROID")) {
			btnSkip.click();
		}
	}

	public void clickBtnNoWIFI() {
		if (Base.getProperty("SO").equals("ANDROID")) {
			btnNoWIFI.click();
		}
	}

	public void clickBtnPermNotificaciones() {

		if (Base.getProperty("SO").equals("iOS")) {
			btnPermitirNotificaciones.click();
		}
	}
	
	public void clickBtnAppNoRastreator() {
		if (Base.getProperty("SO").equals("iOS")) {
			btnAppNoRastreator.click();
		}
	}
	
	public void clickBtnOnboardingJump() {
		if (Base.getProperty("SO").equals("iOS")) {
		btnOnboardingJump.click();
		}
	}
}
