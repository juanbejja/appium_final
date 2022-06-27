package eci.qa.planes_prueba;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eci.qa.appium.Base;
import eci.qa.appium.Constantes;
import eci.qa.appium.Utilities;
import eci.qa.page_objects.HomePage;
import eci.qa.page_objects.InitPage;
import eci.qa.page_objects.ServicesPage;
import eci.qa.page_objects.login.LoginPage;
import eci.qa.page_objects.search.BuyPage;
import eci.qa.page_objects.search.ItemPage;
import eci.qa.zephyr.ZephyrUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestsSearch extends Base {

	@BeforeClass
	public static void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		System.setProperty("http.proxyHost", "proxycorp.geci");
		System.setProperty("http.proxyPort", "8080");
		System.getProperties().put("http.proxyUser", "XY8776BE");
		System.getProperties().put("http.proxyPassword", "BEJARAN0");
		System.setProperty("https.proxyHost", "proxycorp.geci");
		System.setProperty("https.proxyPort", "8080");
		System.getProperties().put("https.proxyUser", "XY8776BE");
		System.getProperties().put("https.proxyPassword", "BEJARAN0");
		Thread.sleep(3000);
	}

	@AfterClass
	public static void killProcess() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Runtime.getRuntime().exec("pkill adb");
		Runtime.getRuntime().exec("pkill WebDriver");
		Runtime.getRuntime().exec("pkill qemu-syst");
	}

	@Test(dataProvider = "search")
	public void TC1804009(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1804009);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			BuyPage buy = new BuyPage(driver);

			ItemPage item = new ItemPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1804009").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1804009").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnBuy();

			buy.checkBuyPage();

			buy.enterSearch(dataJSON.get("TC1804009").get("busqueda"));

			Utilities.clickSearchKeyboard();

			Thread.sleep(7000);

			buy.checkMultipleItems();

			// AGREGAR STEPS CESTA

			buy.clickItem();

			item.checkItemPage();

			item.selectSize();

			item.validateItemAdded();

			ZephyrUtilities.addAttachment(1804009);

			ZephyrUtilities.addComentary(1804009, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1804009, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1804009, "2");

			ZephyrUtilities.addComentary(1804009, e.getMessage());

			ZephyrUtilities.addAttachment(1804009);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "search")
	public void TC1804002(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1804002);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			BuyPage buy = new BuyPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1804002").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1804002").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnBuy();

			buy.checkBuyPage();

			buy.enterSearch(dataJSON.get("TC1804002").get("busqueda"));

			Utilities.clickSearchKeyboard();

			Thread.sleep(10000);

			buy.checkNotResults();

			ZephyrUtilities.addAttachment(1804002);

			ZephyrUtilities.addComentary(1804002, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1804002, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1804009, "2");

			ZephyrUtilities.addComentary(1804002, e.getMessage());

			ZephyrUtilities.addAttachment(1804002);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "search")
	public void TC1804020(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1804020);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			BuyPage buy = new BuyPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1804020").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1804020").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnBuy();

			buy.checkBuyPage();

			buy.enterSearch(dataJSON.get("TC1804020").get("busqueda"));

			Utilities.clickSearchKeyboard();

			Thread.sleep(10000);

			buy.checkOnlyResult();

			ZephyrUtilities.addAttachment(1804020);

			ZephyrUtilities.addComentary(1804020, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1804020, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1804020, "2");

			ZephyrUtilities.addComentary(1804020, e.getMessage());

			ZephyrUtilities.addAttachment(1804020);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "search")
	public void TC1804015(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1804015);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			BuyPage buy = new BuyPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1804015").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1804015").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnBuy();

			buy.checkBuyPage();

			buy.enterSearch(dataJSON.get("TC1804015").get("busqueda"));

			Utilities.clickSearchKeyboard();

			Thread.sleep(10000);

			buy.clickBtnBack();

			buy.clickInputSearch();

			buy.checkRecentlySearch();

			ZephyrUtilities.addAttachment(1804015);

			ZephyrUtilities.addComentary(1804015, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1804015, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1804015, "2");

			ZephyrUtilities.addComentary(1804015, e.getMessage());

			ZephyrUtilities.addAttachment(1804015);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "search")
	public void TC1804023(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1804023);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			BuyPage buy = new BuyPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1804023").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1804023").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnBuy();

			buy.checkBuyPage();

			buy.enterSearch(dataJSON.get("TC1804023").get("busqueda"));

			buy.checkOptionSuggested();

			ZephyrUtilities.addAttachment(1804023);

			ZephyrUtilities.addComentary(1804023, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1804023, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1804023, "2");

			ZephyrUtilities.addComentary(1804023, e.getMessage());

			ZephyrUtilities.addAttachment(1804023);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@Test(dataProvider = "search")
	public void TC1804029(Map<String, Map<String, String>> dataJSON) throws Exception {

		try {

			service = startAppiumServer();

			AppiumDriver<MobileElement> driver = capabilities();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			ZephyrUtilities.cleanAttachments(1804029);

			InitPage init = new InitPage(driver);

			HomePage home = new HomePage(driver);

			ServicesPage servicep = new ServicesPage(driver);

			LoginPage login = new LoginPage(driver);

			BuyPage buy = new BuyPage(driver);

			init.clickBtnNoWIFI();

			init.clickBtnAcceptCookies();

			init.clickBtnPermNotificaciones();

			init.clickBtnDontAllowNoti();

			home.clickBtnServicios();

			servicep.clickBtnCompraManosLibres();

			login.sendDataInputEmail(dataJSON.get("TC1804029").get("email"));

			login.sendDataInputContrasena(dataJSON.get("TC1804029").get("password"));

			login.clickBtnIniciarSesion();

			home.existBtnServicios();

			home.clickBtnBuy();

			buy.checkBuyPage();

			buy.enterSearch(dataJSON.get("TC1804029").get("busqueda"));

			Utilities.clickSearchKeyboard();

			Thread.sleep(7000);

			buy.clearInputSearch();

			buy.enterSearchInItem(dataJSON.get("TC1804029").get("busquedaCaracter"));

			Utilities.clickSearchKeyboard();

			buy.checkErrorOneCaracter();

			ZephyrUtilities.addAttachment(1804029);

			ZephyrUtilities.addComentary(1804029, Constantes.TESTOK_MSG);

			ZephyrUtilities.updateZephyr(1804029, "1");

		} catch (Exception e) {

			e.printStackTrace();

			ZephyrUtilities.updateZephyr(1804029, "2");

			ZephyrUtilities.addComentary(1804029, e.getMessage());

			ZephyrUtilities.addAttachment(1804029);

			throw new Exception(e);

		} finally {

			driver.closeApp();

			driver.quit();

			service.stop();
		}

	}

	@DataProvider(name = "search")
	public Object[][] getDataProviderSearch() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();

		Object obj = parser.parse(new FileReader(Constantes.JSON_SEARCH));
		jsonObject = (JSONObject) obj;

		ObjectMapper jsonMapper = new ObjectMapper();
		Map<String, Map<String, String>> configMap = jsonMapper.readValue(jsonObject.toJSONString(), HashMap.class);
		return new Object[][] { { configMap } };
	}

}
