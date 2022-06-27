package eci.qa.page_objects.paymentMethods;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DetailCardPage {
	
	public DetailCardPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'add_payment_method_input_alias')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Alias del medio de pago\"]//following-sibling::XCUIElementTypeTextField")
	private MobileElement inputAliasCardECI;

	@AndroidFindBy(accessibility = "GUARDAR")
	@iOSXCUITFindBy(accessibility = "GUARDAR")
	private MobileElement btnSaveCardDetail;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'info_button')]")
	@iOSXCUITFindBy(accessibility = "Información de la tarjeta. ")
	private MobileElement btnCardInfo;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'movements_button')]")
	@iOSXCUITFindBy(accessibility = "Últimos movimientos. ")
	private MobileElement btnCardMovements;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'replenish_gift_button')]")
	@iOSXCUITFindBy(accessibility = "Recarga desde tarjeta regalo física. ")
	private MobileElement btnGiftCardRecharge;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'transfer_gift_button')]")
	@iOSXCUITFindBy(accessibility = "Traspaso a otra tarjeta regalo. ")
	private MobileElement btnGiftCardTransfer;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'refund_abono_button')]")
	@iOSXCUITFindBy(accessibility = "Recarga desde una devolución. ")
	private MobileElement btnAbonoCardRechargeReturn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'replenish_abono_button')]")
	@iOSXCUITFindBy(accessibility = "Recarga desde tarjeta de abono. ")
	private MobileElement btnAbonoCardRecharge;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'qr_image')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Código QR\")]")
	private MobileElement codQRCardAbono;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'transaction_price')])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell//*[contains(@name,'€')]")
	private MobileElement lblMovements;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'payment_methods_title')][contains(@text,'No tienes')]")
	@iOSXCUITFindBy(accessibility = "No tienes ningún movimiento")
	private MobileElement lblNotMovements;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'date_header')]")
	@iOSXCUITFindBy(accessibility = "Fecha")
	private MobileElement lblMDate;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'operation_header')]")
	@iOSXCUITFindBy(accessibility = "Operación")
	private MobileElement lblMOperation;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'amount_header')]")
	@iOSXCUITFindBy(accessibility = "Importe")
	private MobileElement lblMAmount;

	@iOSXCUITFindBy(accessibility = "Tienda")
	private MobileElement lblMShop;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id_header')]")
	@iOSXCUITFindBy(accessibility = "Número de operación")
	private MobileElement lblMOperationNumber;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'gift_add_number_input')]")
	@iOSXCUITFindBy(accessibility = "Número de tarjeta")
	private MobileElement inputRechargeNumberCard;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'gift_add_pin_input')]")
	@iOSXCUITFindBy(accessibility = "PIN")
	private MobileElement inputRechargePINCard;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'gift_add_button')]")
	@iOSXCUITFindBy(accessibility = "CONTINUAR")
	private MobileElement btnContinueRecharge;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'dialog_message_text')][contains(@text,'TARJETA ORIGEN INEXISTENTE')]")
	@iOSXCUITFindBy(accessibility = "TARJETA ORIGEN EN BAJA")
	private MobileElement lblErrorRechargeGC;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'dialog_message_text')][contains(@text,'TARJETA ORIGEN INEXISTENTE')]")
	@iOSXCUITFindBy(accessibility = "TOKEN-CUC ORIGEN INEXISTENTE")
	private MobileElement lblErrorRechargeNotExist;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'selection_message')]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,\"Selecciona una tarjeta regalo donde quieras traspasar\")])[1]")
	private MobileElement lblMultipleCardsToTransfer;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'transfer_warning')][contains(@text,'Comprueba los')]")
	@iOSXCUITFindBy(accessibility = "Comprueba los datos de la tarjeta antes de añadir el saldo.")
	private MobileElement lblOrigenDestinationTransfer;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@resource-id,'card_layout')])[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[2]")
	private MobileElement multipleCards;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'origin_title')]")
	@iOSXCUITFindBy(accessibility = "Origen")
	private MobileElement lblOriginTransfer;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'target_title')]")
	@iOSXCUITFindBy(accessibility = "Destino")
	private MobileElement lblDestinationTransfer;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'transfer_button')]")
	@iOSXCUITFindBy(accessibility = "ACEPTAR")
	private MobileElement btnAcceptDestinationOrigin;

	public void checkPageOrigenDestinationTrans() {
		lblOrigenDestinationTransfer.isDisplayed();
		lblOriginTransfer.isDisplayed();
		lblDestinationTransfer.isDisplayed();
		btnAcceptDestinationOrigin.isDisplayed();
	}

	public void checkCodQRCardAbono() {
		codQRCardAbono.isDisplayed();
	}

	public void checkMultipleCardsToTransfer() {
		lblMultipleCardsToTransfer.isDisplayed();
		multipleCards.isDisplayed();
	}

	public void clickBtnMultipleCard() {
		multipleCards.click();
	}

	public void enterInputRechargePINCard(String PIN) {
		inputRechargePINCard.sendKeys(PIN);
	}

	public void enterInputRechargeNumberCard(String number) {
		inputRechargeNumberCard.sendKeys(number);
	}

	public void editInputAliasCardECI(String alias) {
		inputAliasCardECI.clear();
		inputAliasCardECI.sendKeys(alias);
	}

	public void clickBtnContinueRecharge() {
		btnContinueRecharge.click();
	}

	public void clickBtnSaveCardDetail() {
		btnSaveCardDetail.click();
	}

	public void clickBtnCardMovements() {
		btnCardMovements.click();
	}

	public void clickBtnGiftCardRecharge() {
		btnGiftCardRecharge.click();
	}

	public void clickBtnGiftCardTransfer() {
		btnGiftCardTransfer.click();
	}

	public void clickBtnAbonoCardRechargeReturn() {
		btnAbonoCardRechargeReturn.click();
	}

	public void clickBtnAbonoCardRecharge() {
		btnAbonoCardRecharge.click();
	}

	public void checkErrorCardNotExist() {
		lblErrorRechargeNotExist.isDisplayed();
	}

	public void clickBtnCardInfo() {
		btnCardInfo.click();
	}

	public void checkMovements() {
		lblMovements.isDisplayed();
	}

	public void clickMovement() {
		lblMovements.click();
	}

	public void checkLblNotMovements() {
		lblNotMovements.isDisplayed();
	}

	public void checkLblErrorRechargeGC() {
		lblErrorRechargeGC.isDisplayed();
	}

	public void checkInfoMovement() {
		lblMovements.isDisplayed();
		lblMDate.isDisplayed();
		lblMOperation.isDisplayed();
		lblMAmount.isDisplayed();
		lblMOperationNumber.isDisplayed();
	}
}
