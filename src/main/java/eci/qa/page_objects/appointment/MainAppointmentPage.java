package eci.qa.page_objects.appointment;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MainAppointmentPage {

	public MainAppointmentPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Pedir cita")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Pedir cita\"]")
	private MobileElement titleAskAppointment;

	@AndroidFindBy(id = "appointment_request")
	@iOSXCUITFindBy(accessibility = "Nueva cita. ")
	private MobileElement btnNewAppointment;

	@AndroidFindBy(id = "coming_appointments")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Próximas citas')]")
	private MobileElement btnUpcomingAppointment;

	@AndroidFindBy(id = "past_appointments")
	@iOSXCUITFindBy(accessibility = "Citas pasadas. ")
	private MobileElement btnPastAppointment;
	
	@AndroidFindBy(id = "extra_text")
	@iOSXCUITFindBy(accessibility = "Próximas citas. Tienes 1 cita pendiente. ")
	private MobileElement msgAppointmentPending;

	public void checkPage() {
		titleAskAppointment.isDisplayed();
		btnNewAppointment.isDisplayed();
		btnUpcomingAppointment.isDisplayed();
		btnPastAppointment.isDisplayed();
	}

	public void clickBtnNewAppointment() {
		btnNewAppointment.click();
	}

	public void clickBtnUpcomingAppointment() {
		btnUpcomingAppointment.click();
	}

	public void clickBtnPastAppointment() {
		btnPastAppointment.click();
	}
	
	public void checkAppointmentPending() {
		msgAppointmentPending.isDisplayed();
	}

}
