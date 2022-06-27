package eci.qa.page_objects.paymentMethods;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CardInfoPage {
	public CardInfoPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'gift_info_number')]")
	@iOSXCUITFindBy(accessibility = "Número de tarjeta")
	private MobileElement lblCardNumber;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'gift_alias_header')]")
	@iOSXCUITFindBy(accessibility = "Alias")
	private MobileElement lblCardAlias;

	@AndroidFindBy(accessibility = "Edita el alias de esta tarjeta")
	@iOSXCUITFindBy(accessibility = "Edita el alias de esta tarjeta")
	private MobileElement btnEditAlias;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'gift_info_expiry')]")
	@iOSXCUITFindBy(accessibility = "Fecha de caducidad")
	private MobileElement lblCardDateExpire;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'gift_info_reference')]")
	@iOSXCUITFindBy(accessibility = "Identificador")
	private MobileElement lblCardIdentifier;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'conditions_button')]")
	@iOSXCUITFindBy(accessibility = "VER CONDICIONES DE USO")
	private MobileElement btnConditions;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'toolbar_menu_button')]")
	@iOSXCUITFindBy(accessibility = "Accede a la información")
	private MobileElement btnInfoCard;

	@AndroidFindBy(accessibility = "Cerrar pantalla actual")
	@iOSXCUITFindBy(accessibility = "Cerrar pantalla actual")
	private MobileElement btnCloseInfoPop;

	public void checkCardGiftInfo() {
		lblCardNumber.isDisplayed();
		lblCardAlias.isDisplayed();
		btnEditAlias.isDisplayed();
		lblCardDateExpire.isDisplayed();
		lblCardIdentifier.isDisplayed();
		btnConditions.isDisplayed();
		btnInfoCard.isDisplayed();
	}
	
	public void checkCardAbonoInfo() {
		lblCardNumber.isDisplayed();
		lblCardDateExpire.isDisplayed();
		lblCardIdentifier.isDisplayed();
		btnConditions.isDisplayed();
		btnInfoCard.isDisplayed();
	}

	public void clickBtnInfo() {
		btnInfoCard.click();
	}

	public void clickBtnCloseInfoPop() {
		btnCloseInfoPop.click();
	}

}
