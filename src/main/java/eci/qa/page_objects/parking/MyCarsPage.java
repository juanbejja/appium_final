package eci.qa.page_objects.parking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import eci.qa.appium.Utilities.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MyCarsPage {
	public MyCarsPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "com.elcorteingles.app.pre:id/toolbar_title")
	public MobileElement titleToolBar;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Añadir otro vehículo\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/add_vehicle_action")
	public MobileElement btnAddCar;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Matrícula\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/car_license_input_name")
	public MobileElement inputMatricula;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GUARDAR\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/button")
	public MobileElement btnSaveCar;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Siguiente\"]")
	public MobileElement btnNext;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONFIRMAR\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/parking_add_vehicle_dialog_accept_button")
	public MobileElement btnSaveCarConfirm;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"5322GFD\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"5322GFD\"]")
	private MobileElement btnLicenceDetail;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ELIMINAR VEHÍCULO\"]")
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"ELIMINAR VEHÍCULO\"]")
	private MobileElement btnLicenceDelete;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ACEPTAR\"]")
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"ACEPTAR\"]")
	private MobileElement btnLicenceDeleteConfirm;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOBORRAR\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"NOBORRAR\"]")
	private MobileElement btnNumeroMatricula;
	
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Parking\"]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Activado\"]")
	private MobileElement matriculaActivada;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/switch_vehicle_enable")
	public MobileElement btnVehiculoSwitch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Vuelve a la pantalla anterior.\"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/toolbar_navigation_button")
	public MobileElement btnIconBack;


	public void clickBtnAddCar() {		
		btnAddCar.click();
	}
	
	public void clickBtnSaveCar() {
		if(Base.getProperty("SO").equals("ANDROID")) {
			btnSaveCar.click();
		}else {
			btnNext.click();
			btnSaveCar.click();
		}
	}
	
	public void clickBtnSaveCarConfirm() {
		btnSaveCarConfirm.click();
	}
	
	public void clickLicenceDetail() {
		btnLicenceDetail.click();
	}
	
	public void clickBtnLicenceDelete () {
		btnLicenceDelete.click();
	}
	
	public void clickBtnLicenceDeleteConfirm() {
		btnLicenceDeleteConfirm.click();
	}
	
	public void clickNumeroMatricula() {
		btnNumeroMatricula.click();
	}
	
	public void clickVehiculoSwitch() {
		btnVehiculoSwitch.click();
	}
	
	public void clickIconBack() {
		btnIconBack.click();
	}
	
	public void checkAddMatriculaPage() {
		ExpectedConditions.visibilityOf(inputMatricula);
	}
	
	public void enterMatricula(String matricula) {
		inputMatricula.sendKeys(matricula);
	}
}

	
	

