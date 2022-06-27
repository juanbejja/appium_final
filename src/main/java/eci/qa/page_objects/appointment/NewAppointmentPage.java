package eci.qa.page_objects.appointment;

import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import eci.qa.appium.Utilities.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NewAppointmentPage {

	public NewAppointmentPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Nueva cita")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Nueva cita\"]")
	private MobileElement titleNewAppointment;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'INFORMACIÓN DE TU CITA')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"INFORMACIÓN DE TU CITA\"]")
	private MobileElement subtitleNewAppointment;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Añadir\"][@enabled=\"true\"]")
	@iOSXCUITFindBy(accessibility = "Añadir")
	private MobileElement btnAdd;

	@AndroidFindBy(id = "personal_data_button")
	@iOSXCUITFindBy(accessibility = "Datos personales")
	private MobileElement sectionPersonalData;

	@AndroidFindBy(id = "services_form_commentary")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Indícanos alguna necesidad para el servicio\"]")
	private MobileElement inputObservations;

	@AndroidFindBy(id = "consents_accept_check")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'Caja de verificación')])[1]")
	private MobileElement btnAcceptConditions;

	@AndroidFindBy(accessibility = "CONFIRMAR Y ACEPTAR")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CONFIRMAR Y ACEPTAR\"])[1]")
	private MobileElement btnConfirm;

	@AndroidFindBy(accessibility = "Servicio")
	@iOSXCUITFindBy(accessibility = "SELECCIONA UN SERVICIO")
	private MobileElement titleAddService;

	@AndroidFindBy(id = "search_edit_text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Buscar por nombre\"]")
	private MobileElement inputFindService;

	@AndroidFindBy(xpath = "(//android.widget.Button[@id,'select_service_button'])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"SELECCIONAR Y CONTINUAR \"])[1]")
	private MobileElement btnSelectAndContinue;

	@AndroidFindBy(accessibility = "Detalle del servicio")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Detalle del servicio\"]")
	private MobileElement titleDetailService;

	@AndroidFindBy(xpath = "(//android.widget.RadioButton)[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Baby Expert\"]")
	private MobileElement optDetailService;

	@AndroidFindBy(id = "confirm_button")
	@iOSXCUITFindBy(accessibility = "CONTINUAR ")
	private MobileElement btnContinueDetailService;

	@AndroidFindBy(accessibility = "Localización")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Localización\"]")
	private MobileElement titleLocation;

	@AndroidFindBy(id = "enable_location_view")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Permitir localización para mostrar las tiendas más cercanas\"]")
	private MobileElement btnAllowLocation;

	@AndroidFindBy(accessibility = "Provincia")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Provincia\"])[2]")
	private MobileElement cmbProvince;

	@AndroidFindBy(accessibility = "Madrid, no seleccionado")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"MADRID\"]")
	private MobileElement optMadrid;

	@AndroidFindBy(id = "select_territory_button")
	@iOSXCUITFindBy(accessibility = "SELECCIONAR Y CONTINUAR")
	private MobileElement btnSelectCenter;

	@AndroidFindBy(accessibility = "Día y hora")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Día y hora\"]")
	private MobileElement titleDayHour;

	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout)[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeCell[1]")
	private MobileElement optFirstDay;

	@AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView)[2]//android.widget.LinearLayout[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView)[2]//XCUIElementTypeCell[1]")
	private MobileElement optFirstHour;

	@AndroidFindBy(id = "continue_button")
	@iOSXCUITFindBy(accessibility = "CONTINUAR")
	private MobileElement btnContinueSelectDay;

	@AndroidFindBy(id = "thanks_text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Gracias')]")
	private MobileElement msgThanksAppointment;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar\"])[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Editar\"])[2]")
	private MobileElement btnEditDay;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"description_text\")][contains(@text,'Se ha modificado la cita correctamente')]")
	@iOSXCUITFindBy(accessibility = "Se ha modificado la cita correctamente")
	private MobileElement msgAppointmentModify;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"description_text\")][contains(@text,'Se ha eliminado la cita correctamente')]")
	@iOSXCUITFindBy(accessibility = "Se ha eliminado la cita correctamente")
	private MobileElement msgAppointmentDeleted;

	@AndroidFindBy(id = "cancelled_title")
	@iOSXCUITFindBy(accessibility = "Cita cancelada")
	private MobileElement msgAppointmentCancel;

	@AndroidFindBy(id = "continue_button")
	@iOSXCUITFindBy(accessibility = "ACEPTAR")
	private MobileElement btnAccept;

	@AndroidFindBy(id = "dialog_top_button")
	private MobileElement btnAcceptDelete;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable)[2]")
	private MobileElement optSelectedService;

	public void checkPage() {
		titleNewAppointment.isDisplayed();
		subtitleNewAppointment.isDisplayed();
		btnAdd.isDisplayed();
		sectionPersonalData.isDisplayed();
		inputObservations.isDisplayed();
	}

	public void clickBtnAddField() {
		btnAdd.click();
	}

	public void checkServices() {
		titleAddService.isDisplayed();
		inputFindService.isDisplayed();
		btnSelectAndContinue.isDisplayed();
	}

	public void selectFirstService() {
		btnSelectAndContinue.click();
	}

	public void checkDetailService() {
		titleDetailService.isDisplayed();
		optDetailService.isDisplayed();
		btnContinueDetailService.isDisplayed();
	}

	public void selectDetailService() {
		optDetailService.click();
		btnContinueDetailService.click();
	}

	public void checkLocation() {
		titleLocation.isDisplayed();
		btnAllowLocation.isDisplayed();
		cmbProvince.isDisplayed();
	}

	public void selectProvince() {
		cmbProvince.click();
		optMadrid.click();
		btnSelectCenter.isDisplayed();
		btnSelectCenter.click();
	}

	public void checkDayHour() {
		titleDayHour.isDisplayed();
		optFirstDay.isDisplayed();
	}

	public void selectDayHour() {
		optFirstDay.click();
		optFirstHour.isDisplayed();
		optFirstHour.click();
		btnContinueSelectDay.click();
	}

	public void clickCheckBoxAcceptConditions() {
		if(Base.getProperty("SO").equals("ANDROID")) {
			Utilities.scrollBottomAndroid();
//			Utilities.swipeInElementIOS(optSelectedService, Direction.UP);
//			Utilities.swipeInElementIOS(optSelectedService, Direction.DOWN);
		}
		btnAcceptConditions.click();
	}

	public void clickBtnConfirmAppointment() {
		btnConfirm.click();
	}

	public void checkAppointment() {
		msgThanksAppointment.isDisplayed();
		btnAccept.isDisplayed();
		btnAccept.click();
	}

	public void checkAppointmentModify() {
		msgAppointmentModify.isDisplayed();
		btnAccept.isDisplayed();
		btnAccept.click();
	}

	public void checkAppointmentDeleted() {
		msgAppointmentDeleted.isDisplayed();
		msgAppointmentCancel.isDisplayed();
		btnAccept.isDisplayed();
		btnAccept.click();
	}

	public void sendObservation(String observation) {
		inputObservations.sendKeys(observation);
	}

	public void clickBtnAccept() {
		btnAccept.click();
	}

	public void clickBtnAcceptDelete() {

		if (Base.getProperty("SO").equals("iOS")) {

			btnAccept.click();

		} else {
			btnAcceptDelete.click();

		}
	}

	public void clickBtnEditDay() {
		btnEditDay.click();
	}

}
