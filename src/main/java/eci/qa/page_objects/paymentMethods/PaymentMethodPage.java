package eci.qa.page_objects.paymentMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import eci.qa.appium.Utilities.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PaymentMethodPage {

	public PaymentMethodPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/payment_methods_title')]")
	@iOSXCUITFindBy(accessibility = "No tienes ningún medio de pago")
	private MobileElement lblWithoutPaymentMethod;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'id/payment_methods_button')]")
	@iOSXCUITFindBy(accessibility = "AÑADIR MEDIO DE PAGO")
	private MobileElement btnAddMethod;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id,'id/payment_method_selection_root')])[1]")
	@iOSXCUITFindBy(accessibility = "Tarjeta de El Corte Inglés. ")
	private MobileElement btnCardECI;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/add_payment_method_input_card_number')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	private MobileElement inputCardECINumber;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/add_payment_method_input_alias')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
	private MobileElement inputCardECIAlias;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'/payment_method_name')][contains(@text,'Tarjeta bancaria')]")
	@iOSXCUITFindBy(accessibility = "Tarjeta bancaria ")
	private MobileElement btnCardBank;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'/payment_method_name')][contains(@text,'Tarjeta regalo')]")
	@iOSXCUITFindBy(accessibility = "Tarjeta regalo. ")
	private MobileElement btnCardGift;

	@AndroidFindBy(accessibility = "GUARDAR")
	@iOSXCUITFindBy(accessibility = "GUARDAR")
	private MobileElement btnSaveCard;

	@iOSXCUITFindBy(accessibility = "AÑADIRLA COMO MEDIO DE PAGO EN TIENDA")
	private MobileElement btnAddCardAssMPShop;

	@iOSXCUITFindBy(accessibility = "MEJOR EN OTRA OCASIÓN")
	private MobileElement btnBetterAnotherTime;

	@iOSXCUITFindBy(xpath = "//*[contains(@name,'¿Deseas añadirla también como medio de pago')]")
	private MobileElement lblModalCardAssMPShop;

	@AndroidFindBy(xpath = "//android.widget.ViewFlipper[contains(@content-desc,'Tarjeta El Corte Inglés acabada en')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Tarjeta El Corte Inglés *')]")
	private MobileElement lblCardAdded;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	private MobileElement switchPaidF2F;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/delete_payment_method_button')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ELIMINAR TARJETA\"]")
	private MobileElement btnRemoveCard;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'id/dialog_top_button')]")
	@iOSXCUITFindBy(accessibility = "ACEPTAR")
	private MobileElement btnAcceptRemoveCard;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'add_payment_method_input_alias')]")
	@iOSXCUITFindBy(accessibility = "Alias del medio de pago")
	private MobileElement inputCardBankAlias;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'gift_add_number_input')]")
	@iOSXCUITFindBy(accessibility = "Número de tarjeta")
	private MobileElement inputCardGiftNumber;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'gift_add_pin_input')]")
	@iOSXCUITFindBy(accessibility = "PIN")
	private MobileElement inputCardGiftPIN;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'gift_add_alias_input')]")
	@iOSXCUITFindBy(accessibility = "Alias")
	private MobileElement inputCardGiftAlias;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'gift_add_button')]")
	@iOSXCUITFindBy(accessibility = "CONTINUAR")
	private MobileElement btnContinueGiftCard;

	@iOSXCUITFindBy(accessibility = "CONFIRMAR")
	private MobileElement btnConfirmGiftCard;

	@iOSXCUITFindBy(accessibility = "ESTA TARJETA YA ESTA AÑADIDA PARA ESTE CUC")
	private MobileElement lblGiftCardExist;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/card_number_evolve')][contains(@text,'*774')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tarjeta Visa *7774\"]")
	private MobileElement bankCardAdded;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeCollectionView)[last()]")
	private MobileElement scrollerCards;

	@iOSXCUITFindBy(accessibility = "***** ****7662")
	private MobileElement lblGiftCardNumberPreSave;

	@iOSXCUITFindBy(accessibility = "Podrás usar esta tarjeta para pagos online y en tienda.")
	private MobileElement lblGiftCardInfoPreSave;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tarjeta regalo *7662\"]")
	private MobileElement giftCardAdded;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@resource-id,'card_image_evolve')])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,\"Tarjeta El Corte Inglés\")])[1]")
	private MobileElement cardECISaved;

	@AndroidFindBy(accessibility = "Tarjeta regalo acabada en 7712")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,\"Tarjeta regalo\")])[1]")
	private MobileElement cardGiftSaved;

	@AndroidFindBy(accessibility = "Tarjeta abono acabada en 4544")
	@iOSXCUITFindBy(accessibility = "Tarjeta abono *4544")
	private MobileElement cardAbonoMovements;

	@AndroidFindBy(accessibility = "Tarjeta abono acabada en 0476")
	@iOSXCUITFindBy(accessibility = "Tarjeta abono *0476")
	private MobileElement cardAbonoWhitoutMovements;

	@AndroidFindBy(accessibility = "Tarjeta regalo acabada en 0048")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TARJETA ABONO\"]")
	private MobileElement cardGiftWithoutMovements;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'card_alias_evolve')][contains(@text,'aliasECIModifie')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"aliasECIModifie\"]")
	private MobileElement lblAliasCardModified;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'dialog_message_text')][contains(@text,'TARJETA INEXISTENTE')]")
	@iOSXCUITFindBy(accessibility = "TARJETA INEXISTENTE")
	private MobileElement lblCardGiftNotExist;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Si tienes al\")]")
	private MobileElement lblSuggestion;

	public void checkErrorCGnotExist() {
		lblCardGiftNotExist.isDisplayed();
	}

	public void clickDetailCardGift() {
		if (Base.getProperty("SO").equals("iOS")) {
			Utilities.swipeInElementIOS(lblSuggestion, Direction.UP);
		}
		cardGiftSaved.click();
	}

	public void clickDetailCGWithoutMovements() {
		if (Base.getProperty("SO").equals("iOS")) {
			Utilities.swipeInElementIOS(lblSuggestion, Direction.UP);
			Utilities.swipeInElementIOS(scrollerCards, Direction.UP);
		}
		cardGiftWithoutMovements.click();
	}

	public void clickDetailCardAbono() {
		if (Base.getProperty("SO").equals("iOS")) {
			Utilities.swipeInElementIOS(lblSuggestion, Direction.UP);
		}
		cardAbonoMovements.click();
	}

	public void clickDetailCAWithoutMovements() {
		if (Base.getProperty("SO").equals("iOS")) {
			Utilities.swipeInElementIOS(lblSuggestion, Direction.UP);
		}
		cardAbonoWhitoutMovements.click();
	}

	public void clickDetailCardECI() {
		cardECISaved.click();
	}

	public void checkAliasModified() {
		lblAliasCardModified.isDisplayed();
	}

	public void checkGCData() {
		lblGiftCardNumberPreSave.isDisplayed();
		lblGiftCardInfoPreSave.isDisplayed();
	}

	public void checkGiftCardAdded() {
		giftCardAdded.isDisplayed();
	}

	public void enterInputCardBankAlias(String alias) {
		inputCardBankAlias.sendKeys(alias);
	}

	public void checkErrorGCAlreadyAdded() {
		lblGiftCardExist.isDisplayed();
	}

	public void enterInputCardGiftAlias(String alias) {
		inputCardGiftAlias.sendKeys(alias);
	}

	public void enterInputCardGiftNumber(String number) {
		inputCardGiftNumber.sendKeys(number);
	}

	public void enterInputCardGiftPIN(String PIN) {
		inputCardGiftPIN.sendKeys(PIN);
	}

	public void enterCardECINumber(String number) {
		inputCardECINumber.sendKeys(number);
	}

	public void checkBankCardAdded() {
		bankCardAdded.isDisplayed();
	}

	public void enterCardECIAlias(String alias) {
		inputCardECIAlias.sendKeys(alias);
	}

	public void checkPMPage() {
		btnAddMethod.isDisplayed();
	}

	public void clickBtnAcceptRemoveCard() {
		btnAcceptRemoveCard.click();
	}

	public void checkPMethodCardAdded() {
		btnAddMethod.isDisplayed();
		lblCardAdded.isDisplayed();
	}

	public void clickBtnContinueGiftCard() {
		btnContinueGiftCard.click();
	}

	public void clickBtnConfirmGiftCard() {
		btnConfirmGiftCard.click();
	}

	public void clickCardAdded() {
		lblCardAdded.click();
	}

	public void clickBtnRemoveCard() {
		if (Base.getProperty("SO").equals("ANDROID")) {
			Utilities.scrollToElement("id/delete_payment_method_button");
		}
		btnRemoveCard.click();
	}

	public void clickBtnSaveCard() {
		btnSaveCard.click();
	}

	public void checkModalCardAssMPShop() {
		if (Base.getProperty("SO").equals("iOS")) {
			btnAddCardAssMPShop.isDisplayed();
			btnBetterAnotherTime.isDisplayed();
			lblModalCardAssMPShop.isDisplayed();
		}
	}

	public void clickBtnBetterAnotherTime() {
		if (Base.getProperty("SO").equals("iOS")) {
			btnBetterAnotherTime.click();
		}
	}

	public void clickBtnCardECI() {
		btnCardECI.click();
	}

	public void clickBtnCardBank() {
		btnCardBank.click();
	}

	public void clickBtnCardGift() {
		btnCardGift.click();
	}

	public void clickBtnAddMethod() {
		btnAddMethod.click();
	}

	public void enterCardDNI(String dni) throws Exception {
		if (Base.getProperty("SO").equals("ANDROID") && Base.getProperty("AMBIENTE").equals("PRE")) {
			Thread.sleep(3000);
			Utilities.changeContext("WEBVIEW_com.elcorteingles.app.pre");
			Base.getDriver().findElement(By.xpath("//input[@id=\"dni\"]")).click();
			Base.getDriver().findElement(By.xpath("//input[@id=\"dni\"]")).sendKeys(dni);
		} else {
			Base.getDriver().findElement(By.xpath("//*[@value='DNI/NIE']")).click();
			Base.getDriver().findElement(By.xpath("//*[@value='DNI/NIE']")).sendKeys(dni);
		}

	}

	public void enterPostalCode(String postalCode) throws Exception {
		if (Base.getProperty("SO").equals("ANDROID") && Base.getProperty("AMBIENTE").equals("PRE")) {
			Utilities.changeContext("WEBVIEW_com.elcorteingles.app.pre");
			Base.getDriver().findElement(By.xpath("//input[@id=\"codigopostal\"]")).click();
			Base.getDriver().findElement(By.xpath("//input[@id=\"codigopostal\"]")).sendKeys(postalCode);
		} else {
			Base.getDriver().findElement(By.xpath("//*[@value='Código Postal']")).click();
			Base.getDriver().findElement(By.xpath("//*[@value='Código Postal']")).sendKeys(postalCode);
		}
	}

	public void clickBtnAcceptCardData() throws Exception {
		if (Base.getProperty("SO").equals("ANDROID") && Base.getProperty("AMBIENTE").equals("PRE")) {
			Utilities.changeContext("WEBVIEW_com.elcorteingles.app.pre");
			Base.getDriver().findElement(By.xpath("//button[@id=\"btnAceptar\"]")).click();
			Utilities.changeContext("NATIVE_APP");
			Thread.sleep(5000);
			Base.getDriver().findElementByAccessibilityId("Vuelve a la pantalla anterior.").click();
		} else {
			Base.getDriver().findElement(By.xpath("//*[contains(@label,'Aceptar')]")).click();
		}
	}

}
