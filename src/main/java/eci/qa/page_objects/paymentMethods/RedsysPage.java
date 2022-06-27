package eci.qa.page_objects.paymentMethods;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RedsysPage {

	public RedsysPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//button[@id="divImgAceptar"]
	@iOSXCUITFindBy(accessibility = "Aceptar")
	public MobileElement btnAcceptRedsys;

	@iOSXCUITFindBy(accessibility = "Redsys")
	public MobileElement redsysPage;

	//input[@id="inputCard"]
	@iOSXCUITFindBy(accessibility = "Número de la tarjeta")
	public MobileElement inputCardBankNumber;

	//input[@id="cad1"]
	@iOSXCUITFindBy(accessibility = "Mes")
	public MobileElement inputCardBankMonth;

	//input[@id="cad2"]
	@iOSXCUITFindBy(accessibility = "Año")
	public MobileElement inputCardBankYear;

	//input[@id="codseg"]
	@iOSXCUITFindBy(accessibility = "Cód. Seguridad")
	public MobileElement inputCardBankCod;

	//input[@name="pin"]
	@iOSXCUITFindBy(accessibility = "Código de Identificación Personal CIP")
	public MobileElement inputCIP;

	//img[@alt="Aceptar"]
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name=\"Aceptar\"]")
	public MobileElement btnAcceptCIP;

	public void checkPage() {
		redsysPage.isDisplayed();
		btnAcceptRedsys.isDisplayed();
	}

	public void enterInputCIP(String CIP) {
		inputCIP.sendKeys(CIP);
	}

	public void enterCardBankNumber(String number) {
		inputCardBankNumber.sendKeys(number);
	}

	public void enterCardBankMonth(String month) {
		inputCardBankMonth.sendKeys(month);
	}

	public void enterCardBankYear(String year) {
		inputCardBankYear.sendKeys(year);
	}

	public void enterCardBankCod(String cod) {
		inputCardBankCod.sendKeys(cod);
	}

	public void clickBtnAcceptRedsys() {
		btnAcceptRedsys.click();
	}

	public void clickBtnAcceptCIP() {
		btnAcceptCIP.click();
	}

}
