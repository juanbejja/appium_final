package eci.qa.page_objects.profile;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddAddressPage {

	public AddAddressPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Añadir dirección\"]")
	private MobileElement titlePage;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Tipo de vía")
	private MobileElement cmbTypeRoad;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Nombre de la vía")
	private MobileElement inputNameRoad;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Nº - KM - S/N")
	private MobileElement inputNumAddress;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"País / Región\"])[1]")
	private MobileElement cmbCountry;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Código postal")
	private MobileElement inputPostalCode;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Provincia")
	private MobileElement inputProvince;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Localidad")
	private MobileElement inputLocation;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Edificio (opcional)")
	private MobileElement inputEdifice;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Escaleras (opcional)")
	private MobileElement inputStairs;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Piso (opcional)")
	private MobileElement inputFloor;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Puerta (opcional)")
	private MobileElement inputDoor;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"¿Alguna indicación especial?\"])[1]")
	private MobileElement inputIndication;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Destinatario")
	private MobileElement titleAddressee;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Nombre")
	private MobileElement inputAddresseeName;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Primer apellido")
	private MobileElement inputAddresseeSurname;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Segundo apellido (Opcional)")
	private MobileElement inputAddresseeSecondSurname;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Teléfono")
	private MobileElement titleMovil;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"País / Región\"])[2]")
	private MobileElement inputCountryMovil;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Núm. de móvil")
	private MobileElement inputNumMovil;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"¿Alguna indicación especial?\"])[2]")
	private MobileElement inputMovilIndication;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Opciones de dirección")
	private MobileElement titleAddressOption;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Introduce un alias para nombrar la dirección")
	private MobileElement inputAlias;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Dirección principal")
	private MobileElement titleMainAddress;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSwitch)[1]")
	private MobileElement switchMainAddress;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Dirección de facturación")
	private MobileElement inputAddressBilling;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "(//XCUIElementTypeSwitch)[2]")
	private MobileElement switchAddressBilling;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "CREAR")
	private MobileElement btnAddAddress;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Agrupación. No seleccionado\"]")	
	private MobileElement optRoadGroup;

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(accessibility = "Portugal. No seleccionado")
	private MobileElement optCountryPortugal;

	public void checkAddAddressPage() {
		ExpectedConditions.visibilityOf(titlePage);
		ExpectedConditions.visibilityOf(cmbTypeRoad);
		ExpectedConditions.visibilityOf(inputNameRoad);
		ExpectedConditions.visibilityOf(inputNumAddress);
		ExpectedConditions.visibilityOf(cmbCountry);
		ExpectedConditions.visibilityOf(inputPostalCode);
		ExpectedConditions.visibilityOf(inputProvince);
		ExpectedConditions.visibilityOf(inputLocation);
		ExpectedConditions.visibilityOf(inputEdifice);
		ExpectedConditions.visibilityOf(inputStairs);
		ExpectedConditions.visibilityOf(inputFloor);
		ExpectedConditions.visibilityOf(inputDoor);
		ExpectedConditions.visibilityOf(inputIndication);
		ExpectedConditions.visibilityOf(titleAddressee);
		ExpectedConditions.visibilityOf(inputAddresseeName);
		ExpectedConditions.visibilityOf(inputAddresseeSurname);
		ExpectedConditions.visibilityOf(inputAddresseeSecondSurname);
		ExpectedConditions.visibilityOf(titleMovil);
		ExpectedConditions.visibilityOf(inputCountryMovil);
		ExpectedConditions.visibilityOf(inputNumMovil);
		ExpectedConditions.visibilityOf(inputMovilIndication);
		ExpectedConditions.visibilityOf(titleAddressOption);
		ExpectedConditions.visibilityOf(inputAlias);
		ExpectedConditions.visibilityOf(titleMainAddress);
		ExpectedConditions.visibilityOf(switchMainAddress);
		ExpectedConditions.visibilityOf(inputAddressBilling);
		ExpectedConditions.visibilityOf(switchAddressBilling);
		ExpectedConditions.visibilityOf(btnAddAddress);
	}

	public void selectRoad() {
		cmbTypeRoad.click();
		
//		optRoadGroup.click();
	}

	public void enterRoadName(String name) {
		inputNameRoad.sendKeys(name);
	}

	public void enterNumAddress(String num) {
		inputNumAddress.sendKeys(num);
	}

	public void enterPostalCode(String postalCode) {
		inputPostalCode.sendKeys(postalCode);
	}

	public void enterProvince(String province) {
		inputProvince.sendKeys(province);
	}

	public void enterLocation(String location) {
		inputLocation.sendKeys(location);
	}

}
