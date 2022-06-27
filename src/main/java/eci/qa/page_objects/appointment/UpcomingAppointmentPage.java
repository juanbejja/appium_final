package eci.qa.page_objects.appointment;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class UpcomingAppointmentPage {

	public UpcomingAppointmentPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Borra tu cita")
	@iOSXCUITFindBy(accessibility = "Borra tu cita")
	private MobileElement btnDeleteAppointment;

	@AndroidFindBy(accessibility = "Modifica tu cita")
	@iOSXCUITFindBy(accessibility = "Modifica tu cita")
	private MobileElement btnUpdateAppointment;

	@AndroidFindBy(accessibility = "Muestra localización de la cita")
	@iOSXCUITFindBy(accessibility = "Muestra localización de la cita")
	private MobileElement btnLocationAppointment;

	public void checkPage() {
		btnDeleteAppointment.isDisplayed();
		btnUpdateAppointment.isDisplayed();
		btnLocationAppointment.isDisplayed();
	}

	public void clickBtnUpdateAppointment() {
		btnUpdateAppointment.click();
	}

	public void clickBtnDeleteAppointment() {
		btnDeleteAppointment.click();
	}

}
