package eci.qa.page_objects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DigitalWalletPage {

	public DigitalWalletPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'id/digital_wallet_payment_methods')]")
	@iOSXCUITFindBy(accessibility = "Medios de pago. ")
	public MobileElement btnMediosPago;

	public void clickBtnMediosPago() {
		btnMediosPago.click();
	}
}
