package eci.qa.page_objects.appointment;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PastAppointmentPage {

	public PastAppointmentPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//*[contains(@resource-id,'repeat_appointment_button')])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Volver a pedir cita\"])[1]")
	private MobileElement btnAskAppointmentAgain;

	@AndroidFindBy(accessibility = "Citas pasadas")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Citas pasadas\"]")
	private MobileElement titlePage;

	@AndroidFindBy(id = "cancel_text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Cita cancelada\")]")
	private MobileElement lblAppointmentCancelled;

	public void checkPage() {
		titlePage.isDisplayed();
		btnAskAppointmentAgain.isDisplayed();
		lblAppointmentCancelled.isDisplayed();
	}

	public void clickBtnAskAppointmentAgain() {
		btnAskAppointmentAgain.click();
	}

}
