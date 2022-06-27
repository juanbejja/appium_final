package eci.qa.page_objects.search;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import eci.qa.appium.Base;
import eci.qa.appium.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BuyPage {

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,\"search_edit_text\")]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Buscar en El Corte Inglés\"]")
	private MobileElement inputSearch;

	@AndroidFindBy(accessibility = "Escanéa el código de barras")
	@iOSXCUITFindBy(accessibility = "Escanéa el código de barras")
	private MobileElement btnScanCode;

	@AndroidFindBy(accessibility = "Supermercado")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Supermercado\"]")
	private MobileElement btnMarket;

	@AndroidFindBy(accessibility = "Hipercor")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Hipercor\"]")
	private MobileElement btnHiper;

	@AndroidFindBy(accessibility = "Viajes")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Viajes\"]")
	private MobileElement btnTravels;

	@AndroidFindBy(accessibility = "Seguros")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Seguros\"]")
	private MobileElement btnInsurance;

	@AndroidFindBy(accessibility = "Entradas")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Entradas\"]")
	private MobileElement btnTickets;

	@AndroidFindBy(accessibility = "Primeriti")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Primeriti\"]")
	private MobileElement btnPrimariti;

	// Focus input sin busqueda

	@AndroidFindBy(id = "com.elcorteingles.app:id/search_recent_title")
	@iOSXCUITFindBy(accessibility = "Búsquedas recientes")
	private MobileElement lblRecentSearch;

	@AndroidFindBy(id = "com.elcorteingles.app:id/search_delete_recent_btn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BORRAR\"]")
	private MobileElement btnDeleteRecentSearch;

	@AndroidFindBy(id = "com.elcorteingles.app:id/categories_item_text_view")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]//XCUIElementTypeCell//XCUIElementTypeButton")
	private MobileElement optRecentSearch;

	@AndroidFindBy(id = "com.elcorteingles.app:id/search_cancel_btn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancelar\"]")
	private MobileElement btnCancelSearch;

	// Busqueda sin resultado

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"RESULTADOS DE BÚSQUEDA:\")]")
	private MobileElement titleResult;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"0 resultados en todo el catálogo para \")]")
	private MobileElement lblEmptyResult;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lo sentimos, no hemos encontrado productos que coincidan con tu búsqueda.\"]")
	private MobileElement titleEmptyResult;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(accessibility = "Comprueba que has escrito tu búsqueda correctamente o usa términos más generales.")
	private MobileElement subtitleEmptyResult;

	@AndroidFindBy(id = "products-list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"RESULTADOS DE BÚSQUEDA: \")]")
	private MobileElement titleOptSearchExist;

	@AndroidFindBy(xpath = "//div[@data-synth=\"LOCATOR_PRODUCT_PREVIEW_LIST\"]")
	@iOSXCUITFindBy(xpath = "//*[@label=\"Camiseta interior de hombre de algodón en blanco de manga corta\"]")
	private MobileElement optSearched;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//*[@label=\"Categorías\"]")
	private MobileElement btnCategorias;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//*[@label=\"Filtros\"]")
	private MobileElement btnFiltros;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//*[@label=\"Ordenar por\"]")
	private MobileElement btnOrdenar;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//*[contains(@label,'Compartir')]")
	private MobileElement btnCompartir;

	@iOSXCUITFindBy(xpath = "//*[contains(@label,'Camiseta térmica de hombre Boomerang')]")
	@AndroidFindBy(xpath = "//li[@class=\"products_list-item\"][1]")
	private MobileElement optCamiseta;

	// simple result
	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"La pirámide blanca (Tapa dura)\"]")
	private MobileElement titleOnlyResult;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(accessibility = "COMPRAR EN UN CLIC")
	private MobileElement btnComprarEnUnClick;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(accessibility = "RESERVAR")
	private MobileElement btnReservarItem;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(accessibility = "Vuelve a la pantalla anterior.")
	private MobileElement btnBack;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText[contains(@value,'Camiseta de hombre Real')]")
	private MobileElement optionSuggested;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(accessibility = "Por favor, introduce al menos 2 caracteres")
	private MobileElement lblErrorOneCaracter;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(accessibility = "ACEPTAR")
	private MobileElement btnAcepptErrorOneCaracter;

	@AndroidFindBy(accessibility = "as")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField")
	private MobileElement inputSearchInItem;

	public BuyPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void checkBuyPage() {
		inputSearch.isDisplayed();
//		btnScanCode.isDisplayed();
	}

	public void clickInputSearch() {
		inputSearch.click();
	}

	public void clearInputSearch() {
		inputSearchInItem.clear();
	}

	public void enterSearch(String item) {
		inputSearch.click();
		inputSearch.sendKeys(item);
	}

	public void enterSearchInItem(String item) {
		inputSearchInItem.sendKeys(item);
	}

	public void clickBtnBack() {
		btnBack.click();
	}

	public void checkMultipleItems() throws Exception {

		if (Base.getProperty("SO").equals("iOS")) {
			titleOptSearchExist.isDisplayed();
//			optSearched.isDisplayed();
//			btnCategorias.isDisplayed();
//			btnFiltros.isDisplayed();
//			btnOrdenar.isDisplayed();
//			btnCompartir.isDisplayed();
		} else {
			Utilities.changeContext("WEBVIEW_com.elcorteingles.app");
			Base.getDriver().findElement(By.id("products-list")).isDisplayed();
			Base.getDriver().findElement(By.xpath("//ul[@id=\"js-express-zip-no-express\"]//li[1]")).isDisplayed();
//			Base.getDriver().findElement(By.id("js-mobile-categories")).isDisplayed();
//			Base.getDriver().findElement(By.id("js-mobile-filters")).isDisplayed();
//			Base.getDriver().findElement(By.xpath("//div[@class=\"sorting js-sort\"]")).isDisplayed();
//			Base.getDriver().findElement(By.xpath(
//					"//div[@class=\"products_list-info\"]//p[contains(text(),'resultados en todo el catálogo')]"))
//					.isDisplayed();
		}

	}

	public void clickItem() throws InterruptedException {
		if (Base.getProperty("SO").equals("iOS") && Base.getProperty("AMBIENTE").equals("PRO")) {
			optCamiseta.click();
		} else if (Base.getProperty("SO").equals("iOS") && Base.getProperty("AMBIENTE").equals("PRE")) {
			Thread.sleep(5000);
			Base.getDriver().findElement(By.xpath(
					"//*[@label='Camiseta entrenamiento de niños FEF Selección Española de Fútbol 2020 adidas']"))
					.click();
		} else {
			Base.getDriver().findElement(By.xpath("//li[@class=\"products_list-item\"][1]")).click();
		}
	}

	public void checkNotResults() {
		titleResult.isDisplayed();
		lblEmptyResult.isDisplayed();
		titleEmptyResult.isDisplayed();
		subtitleEmptyResult.isDisplayed();
	}

	public void checkOnlyResult() {
		titleOnlyResult.isDisplayed();
		btnComprarEnUnClick.isDisplayed();
		btnReservarItem.isDisplayed();
	}

	public void checkRecentlySearch() {
		lblRecentSearch.isDisplayed();
		btnDeleteRecentSearch.isDisplayed();
		optRecentSearch.isDisplayed();
		btnCancelSearch.isDisplayed();
	}

	public void checkOptionSuggested() {
		optionSuggested.isDisplayed();
	}

	public void checkErrorOneCaracter() {
		lblErrorOneCaracter.isDisplayed();
		btnAcepptErrorOneCaracter.isDisplayed();
	}

}
